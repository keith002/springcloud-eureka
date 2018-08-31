package com.csdn.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;

import feign.Contract;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class BaseConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**自定义配置ribbon负载均衡算法
     * @return
     */
    @Bean
    public IRule myRule(){
		// return new RoundRobinRule(); //轮训
		// return new WeightedResponseTimeRule(); //加权权重
		// return new RetryRule(); //带有重试机制的轮训
		// return new RandomRule(); //随机
		// return new BestAvailableRule(); //请求数最少策略
		return new MyRule(); //自定义规则
    }
    
    @Bean
    public Contract feignContract(){
        return new MyContract();
    }
    
    @Bean
    public RequestInterceptor getRequestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                /** 设置请求头信息 **/
                requestTemplate.header("Content-Type", "application/json");
                System.out.println("自定义拦截器");
            }
        };
    }
}