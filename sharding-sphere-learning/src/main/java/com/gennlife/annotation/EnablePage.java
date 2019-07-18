package com.gennlife.annotation;

import javax.xml.bind.annotation.XmlType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liuzhen278
 * @title: EnablePage
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/59:58
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EnablePage {
    String enable() default "true";
}
