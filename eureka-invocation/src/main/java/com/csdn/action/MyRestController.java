package com.csdn.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.csdn.service.IService;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;

@RestController
//@DefaultProperties(groupKey = "hello-groupKey",
//commandProperties = {
//    // 超时时间（毫秒）
//    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "200")
//},
//threadPoolProperties = {
//    // 最大线程数
//    @HystrixProperty(name = "coreSize", value = "1")
//})
public class MyRestController {

    @Autowired
    private RestTemplate restTemplate;
    /**
     * 调用服务提供者的接口
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUser(@PathVariable Integer id) {
        String templateUrl = "http://eureka-service/getUser/" + id;
        String result = restTemplate.getForObject(templateUrl, String.class);
        return result;
    }
    
	@Autowired
	private IService iService;

	/**
	 * feign 调用服务提供者接口
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getUserFeign/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getUserFeign(@PathVariable(value = "id") Integer id) {
		return iService.getUser(id);
	}

	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@HystrixCommand(fallbackMethod = "helloFallback", commandKey = "hello-commandKey")
	public String hello() throws InterruptedException{
		Thread.sleep(3000);
	    return iService.myAnnotationHello();
	}
	
	public String helloFallback() {
		System.out.println("----------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return "helloFallback";
	}
	
	@GetMapping(value = "/sayHello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String sayHello() throws InterruptedException{
		String hello = iService.myAnnotationHello();
		 // 获取断路器对接口的开启状态，默认false
	    HystrixCircuitBreaker hystrixCircuitBreaker = HystrixCircuitBreaker.Factory
	            .getInstance(HystrixCommandKey.Factory.asKey("IService#myAnnotationHello()"));
	    System.out.println(hystrixCircuitBreaker.isOpen() + "");
	    return "hello  " + hello;
	}
	
	
}