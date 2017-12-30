package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//configuration
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="BreakBrick";
		config.width=MyGdxGame.width;
		config.height=MyGdxGame.height;
		config.resizable=false;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
