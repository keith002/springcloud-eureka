package com.csdn.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
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

}