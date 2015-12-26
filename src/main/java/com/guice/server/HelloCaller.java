package com.guice.server;

import com.google.inject.Inject;
import com.guice.service.Hello;

public class HelloCaller {
	@Inject
	private Hello hello;
	public void sayHello(){
		this.hello.sayHello();
	}
}
