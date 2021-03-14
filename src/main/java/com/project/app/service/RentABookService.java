package com.project.app.service;


import com.project.app.model.*;
import com.project.app.repository.IEducationLevelDAO;
import com.project.app.ortak.CommonMethods;
import com.project.app.repository.IMemberDAO;
import com.project.app.repository.IRentABookDAO;
import com.project.app.repository.IRentalBookDAO;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentABookService implements IRentABookService{

    @Autowired
    private IRentABookDAO rentABookDAO;

    @Autowired
    private IMemberService memberService;

    @Autowired
    private IEducationLevelDAO educationLevelDAO;

    @Autowired
    private IRentalBookDAO rentalBookDAO;

    //kiralama sureclerine ait islemleri icerir.

    @Override
    public leasedBookDO createRent(leasedBookDO rentInfo) throws ParseException {

        memberDO member = memberService.getMember(rentInfo.getMemberId());

        //tarihi belirli bir formatta kaydetmek icin yapildi
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");

        //kitabin verilis tarihi setlenir
        String startDate = df.format(date);
        rentInfo.setStartDate(startDate);


        //uyenin ceza bitis tarihi gecmemisse kiralama islemi yapilmayacaktir.
        if (Integer.valueOf(member.getBanEndDate()) < Integer.valueOf(startDate)) {
            educationLevelDO educationLevel=  educationLevelDAO.getMemberId(member.getEducationLevelId());

            //uyenin egitim seviyesine gore teslim tarihi bitis tarihi olarak hesaplanir
            String endDate = "";
            Calendar c = Calendar.getInstance();
            c.setTime(df.parse(startDate));
            c.add(Calendar.DATE, educationLevel.getPeriodWeek() * 7);  // number of days to add
            endDate = df.format(c.getTime());
            rentInfo.setEndDate(endDate);

            //kiralama kosulu uygun oldugundan stokta ilgili kitap olmadigi kaydedilir
            String bookId = rentInfo.getBookId();
            Optional<rentalBookDO> rentalBook = rentalBookDAO.findById(bookId);
            if(rentalBook.isPresent()){
                rentalBook.get().setStockStatus(false);
            }

            //kiralama islemi basarili oldugundan ban islemi kaldirilir.
            member.setBanEndDate(null);
            member.setBanStatus(false);
            memberService.save(member);

            return rentABookDAO.save(rentInfo);

        }else {
            return null;
        }

    }

    @Override
    public leasedBookDO updateRent(leasedBookDO rentInfo) throws ParseException {

        Long rentId = rentInfo.getOid();
        Optional<leasedBookDO> rent = rentABookDAO.findById(rentId);

        if(rent.isPresent()){

            //teslim tarihi update edilir.
            rent.get().setDeliveryDate(CommonMethods.getCurrentDate("yyyyMMdd"));
            rentABookDAO.save(rent.get());

            //teslim tarihi kitabın iade edilmesi gereken tarihten sonra ise uyeye ban islemi uygulanir.
            if (Integer.valueOf(rent.get().getEndDate()) < Integer.valueOf(rent.get().getDeliveryDate())) {
                memberDO member = memberService.getMember(rentInfo.getMemberId());
                member.setBanStatus(true);
                Date date = new Date();
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                String startDate = df.format(date);
                Calendar c = Calendar.getInstance();
                c.setTime(df.parse(startDate));
                c.add(Calendar.DATE, 30);  // number of days to add
                String endDate = df.format(c.getTime());
                member.setBanEndDate(endDate);
                memberService.updateMember(member);
            }

            String bookId = rentInfo.getBookId();
            Optional<rentalBookDO> rentalBook = rentalBookDAO.findById(bookId);
            if(rentalBook.isPresent()){
                rentalBook.get().setStockStatus(true);
                rentalBookDAO.save(rentalBook.get());
            }
            return rent.get();
        }else{
            return null;
        }

    }

    @Override
    public leasedBookDO getRentInfo(String oid) {

        Optional<leasedBookDO> rent = rentABookDAO.findById(oid);
        if(rent.isPresent()){
            leasedBookDO rentInfo = rentABookDAO.getOne(oid);
            return rentInfo;
        }else {
            return null;
        }

    }

    @Override
    public List<leasedBookDO> getAllRents() {
        return rentABookDAO.findAll();
    }
}
