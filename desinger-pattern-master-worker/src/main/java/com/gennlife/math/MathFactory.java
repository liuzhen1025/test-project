package com.gennlife.math;

import java.io.*;
import java.math.BigDecimal;
import java.sql.BatchUpdateException;

/**
 * Created by lz on 2017/9/27.
 */
public class MathFactory {
   private static final String ADD = "+";
   private static final String SUBTRACT = "-";
   private static final String MULTIPLY = "*";
   private static final String DIVIDE = "/";
   public static void main(String[] args){

       File file = new File("aaaaaa.txt");
       String path = file.getAbsolutePath();
       System.out.println(path);
       try {
           InputStream resourceAsStream1 = MathFactory.class.getClassLoader().getResourceAsStream("aaaaaa.txt");
           System.out.println(resourceAsStream1.read());
           InputStream resourceAsStream = Class.forName(MathFactory.class.getName()).getClassLoader().getResourceAsStream("aaaaaa.txt");
           int read = resourceAsStream.read();
           System.out.println(read);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   private MathFactory(){}
   private static class MathInstance{

       private static MathFactory factory = new MathFactory();
       private MathFactory getInstance(){
           return factory;
       }
   }

   public BigDecimal add(double first,double second, Integer precision){
        return new BigDecimal(first+second).setScale(precision,BigDecimal.ROUND_HALF_UP);
   }

   public BigDecimal add(int precision,double ...args){
       int length = args.length;
       double sum = 0;
       for(int i = 0; i < length; i++){
           sum += args[i];
       }
       return new BigDecimal(sum).setScale(precision,BigDecimal.ROUND_HALF_UP);
   }

}
