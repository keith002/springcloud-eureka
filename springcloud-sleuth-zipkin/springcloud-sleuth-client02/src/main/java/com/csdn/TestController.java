package com.csdn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@Autowired
    private RestTemplate restTemplate;
	
	@RequestMapping("/client2to1")
    public String callHome(){
        return restTemplate.getForObject("http://localhost:8081/client", String.class);
    }
	
    @RequestMapping("/client02")
    public String info(){
        return "client02";
    }
    
}