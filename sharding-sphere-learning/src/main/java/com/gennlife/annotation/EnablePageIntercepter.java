package com.gennlife.annotation;

import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @author liuzhen278
 * @title: EnablePageIntercepter
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/510:02
 */
/**@Pointcut("@annotation(com.gennlife.annotation.EnablePage)")
public void enablePage() {
}*/
@Aspect
@Component
public class EnablePageIntercepter {
    private static Logger LOG = LoggerFactory.getLogger(EnablePageIntercepter.class);

    @Before("@annotation(enablePage)")
    public void doPage(JoinPoint joinPoint, EnablePage enablePage){
        Object[] args = joinPoint.getArgs();
        try {
            Integer pageNum;
            Integer pageSize;
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
            LOG.error("设置分页及排序信息异常：{}",e);
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
