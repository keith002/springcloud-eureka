package com.csdn.service.impl;


import org.springframework.stereotype.Component;

import com.csdn.service.IService;

@Component
public class IServiceFallback implements IService{

	@Override
	public String getUser(Integer id) {
		// TODO Auto-generated method stub
		return "getUserFallback";
	}

	@Override
	public String myAnnotationHello() {
		// TODO Auto-generated method stub
		return "myAnnotationHelloFallback";
	}

}
