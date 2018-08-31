package com.csdn.action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${name}")
    String name;

	@GetMapping(value = "/hi")
	public String hi() {
		return name;
	}
}
