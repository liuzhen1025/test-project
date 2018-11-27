/**
 * copyRight
 */
package com.gennlife.json.path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/3/13
 * Time: 11:44
 */
public class DateUtils {
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public static String allFormat = "yyyy-MM-dd HH:mm:ss";
    public static Date getDate(String date,String dateFormat){
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date d = null;
        try {
            d = format.parse(date);
        } catch (Exception e) {
            logger.error("日期格式化异常,原始日期{},日期格式{},异常信息{}",date,dateFormat,e);
        }
        return  d;
    }

    public static boolean before(Date value1, Date value2){
        if(value1 == null || value1 == null){

        }
        return value1.before(value2);
    }
    public static boolean after(Date value1, Date value2){
        if(value1 == null || value1 == null){

        }
        return value1.after(value2);
    }

    public static boolean betten(Date value, Date before, Date after){
        if( value == null || before == null || after == null ){
            return false;
        }
        return after(value,before)&&before(value,after);
    }


}
