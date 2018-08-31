package com.csdn.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.csdn.service.impl.IServiceFallback;
import com.csdn.utils.MyAnnotation;

@FeignClient(value = "eureka-service", fallback = IServiceFallback.class)
public interface IService {

    /**
     * spring的注解翻译器，会把@GetMapping()翻译给feign框架
     * 在feign整合到springcloud后就要用spring的注解，原feign的注解就不能使用了
     * 这里的@PathVariable（value = "id"）一定要带上value，否则会报错
     * @return
     */
    @GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getUser(@PathVariable(value = "id") Integer id);

    /**
     * 调用自定义接口的注解
     * @return
     */
    @MyAnnotation(url = "/hello", method = "GET")
    String myAnnotationHello();
}