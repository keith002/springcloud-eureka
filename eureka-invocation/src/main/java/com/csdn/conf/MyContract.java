package com.csdn.conf;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import com.csdn.utils.MyAnnotation;

import feign.MethodMetadata;

/**
 * 自定义注解解释器
 */
public class MyContract extends SpringMvcContract {

    /**
     * 重写spring框架中对方法注解的解释器
     * 对父类方法进行增强
     * @param data
     * @param annotation
     * @param method
     */
    @Override
    protected void processAnnotationOnMethod(MethodMetadata data, Annotation annotation, Method method){
        super.processAnnotationOnMethod(data, annotation, method);
        if(MyAnnotation.class.isInstance(annotation)){
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            String url = myAnnotation.url();
            String httpMethod = myAnnotation.method();
            data.template().method(httpMethod);
            data.template().append(url);
        }
    }
}