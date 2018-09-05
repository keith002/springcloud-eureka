package com.csdn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@Autowired
    private RestTemplate restTemplate;
	
	@RequestMapping("/clientto02")
    public String callHome(){
        return restTemplate.getForObject("http://localhost:8082/client02", String.class);
    }
	
    @RequestMapping("/client")
    public String info(){
        return "client";
    }
    
}