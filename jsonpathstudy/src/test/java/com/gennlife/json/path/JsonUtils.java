/**
 * copyRight
 */
package com.gennlife.json.path;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/3/13
 * Time: 10:54
 */
public class JsonUtils {
    /**
     * 只要有一个key 对应的value 为空，即认为json为空
     * @param json
     * @param keys
     * @return
     */
    public static boolean isEmptyJSON(JSONObject json, String ...keys){
        boolean isNull = false;
        if(json == null){
            return true;
        }
        for (String key:keys){
            Object value = json.get(key);
            if(value == null || StringUtils.isEmpty(String.valueOf(value))){
                isNull = true;
            }
        }
        return isNull;
    }

    /**
     * 判断JSONArray 是否为空
     * @param array
     * @return
     */
    public static boolean isEmptyArray(JSONArray array){
        if(array == null){
            return true;
        }
        return (array.size()==0);
    }
}
