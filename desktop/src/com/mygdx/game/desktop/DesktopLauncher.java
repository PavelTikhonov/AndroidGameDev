package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name","Public");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        float aspect = 3f/4f;
        config.width = 400;
        config.height = (int) (config.width / aspect);
        config.resizable = false;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
