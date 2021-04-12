package cn.abb.oa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class string2date {
    public static Date standardDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate =sdf.parse(date);
        //java.sql.Date resultDate = new java.sql.Date(newDate.getTime());
        return newDate;
    }

}
