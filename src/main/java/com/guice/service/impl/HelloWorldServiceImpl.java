package com.guice.service.impl;

import com.google.inject.Singleton;
import com.guice.service.HelloWorldService;
@Singleton
public class HelloWorldServiceImpl implements HelloWorldService{

	public void say() {
		System.out.println("Hello World !");
		
	}

}
