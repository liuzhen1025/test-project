/**
 * copyRight
 */
package com.liuz.beancontext.comparableandcomparator;

import java.util.*;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/29
 * Time: 14:42
 */
public class Test {

    public static void main(String[] args){
        System.out.println(Currency.getInstance(Locale.US).getSymbol());
        List<MyCompareable> compareables = new ArrayList<>();
        MyCompareable able = new MyCompareable(2);
        MyCompareable able1 = new MyCompareable(1);
        MyCompareable able2 = new MyCompareable(5);
        MyCompareable able3 = new MyCompareable(0);
        compareables.add(able);
        compareables.add(able1);
        compareables.add(able2);
        compareables.add(able3);
        Collections.sort(compareables);
        List<MyComparetor> myComparetors = new ArrayList<>();
        MyComparetor tor = new MyComparetor(9);
        MyComparetor tor1 = new MyComparetor(5);
        tor.compare(tor,tor1);
        MyComparetor tor2 = new MyComparetor(10);
        MyComparetor tor3 = new MyComparetor(1);
        MyComparetor tor4 = new MyComparetor(2);
        myComparetors.add(tor);
        myComparetors.add(tor1);
        myComparetors.add(tor2);
        myComparetors.add(tor3);
        myComparetors.add(tor4);
        lable:
        while (true){
            continue lable;
        }

    }
}
