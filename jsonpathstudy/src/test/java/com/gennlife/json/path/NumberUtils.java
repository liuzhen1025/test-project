/**
 * copyRight
 */
package com.gennlife.json.path;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/3/13
 * Time: 13:00
 */
public class NumberUtils {
    private static Logger logger = LoggerFactory.getLogger(NumberUtils.class);
    public static boolean equals(String value1,String value2){
        if(StringUtils.isEmpty(value1) || StringUtils.isEmpty(value2)){
            return false;
        }
        try {
            BigDecimal v1 = new BigDecimal(value1).setScale(2,BigDecimal.ROUND_HALF_UP);
            BigDecimal v2 = new BigDecimal(value2).setScale(2,BigDecimal.ROUND_HALF_UP);
            return v1.equals(v2);
        } catch (Exception e) {
            logger.error("数据格式化异常,value1={},value2={}",value1,value2);
        }
        return false;
    }

    public static int substract(String value1,String value2){
        try {
            BigDecimal v1 = new BigDecimal(value1).setScale(2,BigDecimal.ROUND_HALF_UP);
            BigDecimal v2 = new BigDecimal(value2).setScale(2,BigDecimal.ROUND_HALF_UP);
            return v1.subtract(v2).compareTo(BigDecimal.ZERO);
        } catch (Exception e) {
            logger.error("数据格式化异常,value1={},value2={}",value1,value2);
        }
        return -2;
    }
    public static boolean greaterThan(String value1,String value2){
        if(value1 == null || value2 == null){
            return false;
        }
        return  substract(value1,value2)>0;
    }
    public static boolean lessThan(String value1,String value2){
        if(value1 == null || value2 == null){
            return false;
        }
        return  substract(value1,value2)<0;
    }
    public static boolean greaterThanEqusls(String value1,String value2){
        if(value1 == null || value2 == null){
            return false;
        }
        return  substract(value1,value2)>=0;
    }
    public static boolean lessThanEquals(String value1,String value2){
        if(value1 == null || value2 == null){
            return false;
        }
        int substract = substract(value1, value2);
        return  substract <=0&&substract!=-2;
    }


}
