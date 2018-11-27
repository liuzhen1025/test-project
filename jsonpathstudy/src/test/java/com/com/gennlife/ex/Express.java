/**
 * copyRight
 */
package com.com.gennlife.ex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/4/23
 * Time: 19:59
 */
public class Express {
    private static String regChinessEnglish = "zo?";
    public static void main(String[] args){
        Pattern pattern = Pattern.compile(regChinessEnglish);
        Matcher matcher = pattern.matcher("z");
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
}
