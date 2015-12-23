package com.guice.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.guice.annotations.Good;
import com.guice.module.PlayerModule;
import com.guice.service.HelloWorldService;
import com.guice.service.Player;

/**
 * @author Nathan
 * 2015年12月23日 下午5:09:51
 */
public class ProgramEntry {
	public static void main(String[] args){
		PlayerModule module = new PlayerModule();
		Injector injector = Guice.createInjector(new Module[]{module});
	    Player player = (Player)injector.getInstance(Player.class);
		player.bat();
		HelloWorldService helloWorldService = (HelloWorldService)injector.getInstance(HelloWorldService.class);
		helloWorldService.say();
		HelloWorldService helloWorldService1 = (HelloWorldService)injector.getInstance(HelloWorldService.class);
		System.out.println(helloWorldService1.hashCode());
		HelloWorldService helloWorldService2 = (HelloWorldService)injector.getInstance(HelloWorldService.class);
		System.out.println(helloWorldService2.hashCode());
		
		HelloCaller helloCaller = injector.getInstance(HelloCaller.class);
		helloCaller.sayHello();
	}
}
