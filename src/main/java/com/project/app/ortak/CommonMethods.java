package com.project.app.ortak;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


//belirli format icin kullanilacak date convert classı

public class CommonMethods {

    public static final String REVISION_ID = "$Id: CommonMethods.java,v 1.25.2.5 2014/09/16 14:46:15 barisd Exp $";

    public static final String DATE_TIME_FORMAT_GS1 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT_GS1 = "yyyy-MM-dd";
    public static final String TIME_FORMAT_GS1 = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT_LONG = "yyyyMMddHHmmssSSS";
    public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT = "yyyyMMdd";
    public static final String TIME_FORMAT = "HHmmss";
    public static final String TIME_FORMAT_LONG = "HHmmssSSS";

    public static final String DATE_TIME_FORMAT_DISPLAY = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_FORMAT_DISPLAY = "dd/MM/yyyy";
    public static final String TIME_FORMAT_DISPLAY = "HH:mm:ss";

    private static final int ENVELOPEID_LENGTH = 36;

    public static final GregorianCalendar DUMMY_DATE = (GregorianCalendar) new GregorianCalendar();
    static final String yuz = "Yüz ";
    static final String birler[] =
            {
                    "", "Bir ", "İki ", "Üç ", "Dört ", "Beş ", "Altı ", "Yedi ", "Sekiz ", "Dokuz "
            };
    static final String onlar[] =
            {
                    "", "On ", "Yirmi ", "Otuz ", "Kırk ", "Elli ", "Altmış ", "Yetmiş ", "Seksen ", "Doksan "
            };
    static final String basamak[] =
            {
                    "", "Bin ", "Milyon ", "Milyar ", "Trilyon ", "Katrilyon ", "Kentrilyon "
            };

    static final String hundred = "Hundred ";
    static final String one[] =
            {
                    "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "
            };
    static final String ten[] =
            {
                    "", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "
            };
    static final String otherTen[] =
            {
                    "", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eigthy ", "Ninety "
            };
    static final String digit[] =
            {
                    "", "Thousand ", "Million ", "Billion ", "Trillion ", "Quadrillion ", "Quintillion  "
            };



    public static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(100, 100, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 100, 100, null);
        g.dispose();

        return resizedImage;
    }



    public static String getCurrentDate(String format) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

}
