package com.gennlife.annotation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author liuzhen278
 * @title: EnablePageIntercepter
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/510:02
 */
@Aspect
@Component
public class EnablePageIntercepter {
    @Pointcut("@annotation(com.gennlife.annotation.EnablePage)")
    public void enablePage() {
    }
    @Before("enablePage()")
    public void doPage(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        try {
            int pageNum;
            int pageSize;
            String orderBy = "";
            for (Object o:args) {
                pageNum = Integer.valueOf(StringUtils.isEmpty(BeanUtils.getProperty(o, "pageNum"))? "0":BeanUtils.getProperty(o, "pageNum"));
                pageSize = Integer.valueOf(StringUtils.isEmpty(BeanUtils.getProperty(o, "pageSize"))? "0":BeanUtils.getProperty(o, "pageSize"));
                orderBy = BeanUtils.getProperty(o, "orderBy");
                PageHelper.startPage(pageNum,pageSize);
            }
            if (!StringUtils.isEmpty(orderBy)) {
                PageHelper.orderBy(orderBy);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
        }
    }
    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature msig = (MethodSignature) sig;
        return getClass(jp).getMethod(msig.getName(), msig.getParameterTypes());
    }
    private Class<? extends Object> getClass(JoinPoint jp) {
        return jp.getTarget().getClass();
    }
}
