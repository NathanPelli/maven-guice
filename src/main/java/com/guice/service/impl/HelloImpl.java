package com.guice.service.impl;

import com.google.inject.ImplementedBy;
import com.guice.service.Hello;

public class HelloImpl implements Hello{

	public void sayHello() {
		System.out.println("I am Nathan Pelli !");
		
	}

}
