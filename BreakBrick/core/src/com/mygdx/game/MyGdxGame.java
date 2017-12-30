package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Player;

public class MyGdxGame extends ApplicationAdapter{
	SpriteBatch batch;
	Texture brickTexture;
	public static final int width=480;
	public static final int height=320;
	private Sprite brickSprite;
	private Player player=Player.getInstance();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		brickTexture=new Texture(player.getSpriteUrl());
		brickSprite=new Sprite(brickTexture);
		brickSprite.setSize(Player.width,Player.height);
		brickSprite.setPosition(200,20);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//not sure what this do???
		move();
		//Starting to draw the images
		batch.begin();
		brickSprite.draw(batch);
		//batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		brickTexture.dispose();
	}

	public void move(){
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			brickSprite.translateX(-4f);
		}else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			brickSprite.translateX(4f);
		}

		if(brickSprite.getX()<=0){
			brickSprite.setPosition(0,Player.yPosition);
		}else if(brickSprite.getX()>=(480-Player.width)){
			brickSprite.setPosition((480-Player.width),Player.yPosition);
		}
	}
}
