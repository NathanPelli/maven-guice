package com.guice.junit;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.guice.annotations.Good;
import com.guice.module.PlayerModule;
import com.guice.service.Player;
import com.guice.service.impl.GoodPlayer;

/**
 * @author Nathan
 * 2015年12月23日 下午5:10:16
 */
public class GuiceJunit {
	@Before
	public void init(){
		
	}
	@Test
	public void annotaion_test(){//测试一个接口绑定多个实现,通过注解来区分,不同的实现
		PlayerModule module = new PlayerModule();
		Injector injector = Guice.createInjector(new Module[]{module});
		@Good Player player = (Player)injector.getInstance(Player.class);
		player.bat();
	}
}
