package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.scenes.MainScene;
import com.mygdx.game.scenes.MenuScene;


public class BreakBrick extends Game {
	SpriteBatch batch;

	public static final int WIDTH=480;
	public static final int HEIGHT=320;



	@Override
	public void create () {
        batch = new SpriteBatch();

        setScreen(new MenuScene(this));
	}

	@Override
	public void render () {
        super.render();
	}



	public SpriteBatch getBatch(){
	    return batch;
    }






}
