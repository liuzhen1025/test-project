/**
 * copyRight
 */
package com.liuz.beancontext.comparableandcomparator;

import java.util.Comparator;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/29
 * Time: 14:39
 */
public class MyComparetor implements Comparator<MyComparetor> {
    private int test;

    public MyComparetor(int test) {

        this.test = test;
    }

    @Override
    public int compare(MyComparetor o1, MyComparetor o2) {
        if(o1.test - o2.test>0){
            return 1;
        }else if(o1.test-o2.test<0){
            return -1;
        }else {
            return 0;
        }
    }
}
