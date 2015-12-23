package com.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.guice.annotations.Bad;
import com.guice.annotations.Good;
import com.guice.service.Player;
import com.guice.service.impl.BadPlayer;
import com.guice.service.impl.GoodPlayer;

public class PlayerModule implements Module{

	public void configure(Binder binder) {
		binder.bind(Player.class).to(GoodPlayer.class);
//		binder.bind(Player.class).annotatedWith(Bad.class).to(BadPlayer.class);
	}

}
