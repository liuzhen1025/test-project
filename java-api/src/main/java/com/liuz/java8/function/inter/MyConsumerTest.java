/**
 * copyRight
 */
package com.liuz.java8.function.inter;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author liuzhen
 *         Created by liuzhen.
 *         Date: 2019/2/19
 *         Time: 11:51
 */
public class MyConsumerTest<T> {

    private String aa = "first";

    public void testMyConsumer(T object, Consumer consumer) {

        consumer.accept(object);
    }

    public static void main(String[] args) {

        new ArrayList<Integer>().parallelStream().sorted((a, b) -> {
            if (a > b) {
                return 1;
            } else {
                return 0;
            }
        }).collect(Collectors.toList());
        JSONArray array = new JSONArray();
        array.add("aaaaaa");
        array.add("bbbbbb");
        array.add("cccccc");
        MyConsumerTest<JSONArray> test = new MyConsumerTest();
        test.testMyConsumer(array, (object) -> {
            if (object instanceof JSONArray) {
                JSONArray arr = (JSONArray) object;
                //arr.clear();
                arr.fluentAdd(2, "test11111");
                System.err.print(arr);
            }
        });

        /*test.testMyConsumer(new MyConsumer() {
            @Override
            public void print(Object o) {

                System.out.println(o);
            }
        });*/
    }
}
