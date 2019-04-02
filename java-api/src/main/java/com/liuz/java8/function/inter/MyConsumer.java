package com.liuz.java8.function.inter;

import java.util.Objects;

/**
 * @author liuzhen
 *         Created by liuzhen.
 *         Date: 2019/2/19
 *         Time: 11:44
 */
@FunctionalInterface
public interface MyConsumer<T> {
    void print(T t);
    default MyConsumer<T> addThen(MyConsumer<T> consumer,T t){
        Objects.requireNonNull(consumer);
        return (t1)-> {
            print(t1);
            consumer.print(t1);
        };
    }
}
