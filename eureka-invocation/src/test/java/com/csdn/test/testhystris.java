package com.csdn.test;

import org.springframework.web.client.RestTemplate;

public class testhystris {
	
	/**
	 * 测试断路器
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		RestTemplate restTemplate = new RestTemplate();
		for (int i = 0; i < 20; i++) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						String templateUrl = "http://127.0.0.1:8666/sayHello";
						String result = restTemplate.getForObject(templateUrl, String.class);
						System.out.println(result);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			thread.start();
		}
		Thread.sleep(20000);
	}
}
