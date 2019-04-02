/**
 * copyRight
 */
package com.liuz.beancontext.comparableandcomparator;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/29
 * Time: 14:37
 */
public class MyCompareable implements Comparable<MyCompareable> {
    private int test = 0;

    public MyCompareable(int test) {

        this.test = test;
    }

    @Override
    public int compareTo(MyCompareable o) {
        if(this.test-o.test>0){
            return 1;
        }else if(this.test-o.test<0){
            return -1;
        }else{
            return 0;
        }
    }
}
