package com.guice.service;

import com.google.inject.ImplementedBy;
import com.guice.service.impl.HelloImpl;

@ImplementedBy(HelloImpl.class)
public interface Hello {
	public void sayHello();
}
