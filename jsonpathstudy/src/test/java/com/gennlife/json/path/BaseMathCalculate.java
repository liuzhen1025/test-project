/**
 * copyRight
 */
package com.gennlife.json.path;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/3/13
 * Time: 11:32
 */
public abstract class BaseMathCalculate {
    public boolean isEquals(String value1,String value2) {
        if(StringUtils.isEmpty(value1) || StringUtils.isEmpty(value2)){
            return false;
        }
        return StringUtils.equalsIgnoreCase(value1,value2);
    }
    public boolean isNotEquals(String value1,String value2) {
        if(StringUtils.isEmpty(value1) || StringUtils.isEmpty(value2)){
            return false;
        }
        return !StringUtils.equalsIgnoreCase(value1,value2);
    }
    public boolean isContains(String value1,String value2){
        return StringUtils.containsIgnoreCase(value1,value2);
    }
    public boolean isNotContains(String value1,String value2){
        return !StringUtils.containsIgnoreCase(value1,value2);
    }

}
