package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Ball;
import com.mygdx.game.entities.Player;

public class MyGdxGame extends ApplicationAdapter{
	SpriteBatch batch;
	Texture ballTexture;
	Texture brickTexture;
	public static final int width=480;
	public static final int height=320;
	private Sprite ballSprite;
	private Sprite brickSprite;
	private Player player=Player.getInstance();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		brickTexture=new Texture(Player.spriteUrl);
		ballTexture=new Texture(Ball.spriteUrl);
		ballSprite=new Sprite(ballTexture);

		brickSprite=new Sprite(brickTexture);
		brickSprite.setSize(Player.width,Player.height);
		ballSprite.setSize(20,20);
		ballSprite.setPosition(Player.xPosition+10,(Player.yPosition+20/4));
		brickSprite.setPosition(Player.xPosition,Player.yPosition);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//not sure what this do???

		//dealing with the player movement
		move();
		//Starting to draw the images
		batch.begin();
		brickSprite.draw(batch);
		ballSprite.draw(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		brickTexture.dispose();
		ballTexture.dispose();
	}

	public void move(){
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			Player.xPosition-=4f;
			brickSprite.setPosition(Player.xPosition,Player.yPosition);
		}else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			Player.xPosition+=4f;
			brickSprite.setPosition(Player.xPosition,Player.yPosition);
		}

		if(Player.xPosition<=0f){
			Player.xPosition=0f;
			brickSprite.setPosition(0,Player.yPosition);
		}else if(Player.xPosition>=(480-Player.width)){
			Player.xPosition=(480-Player.width);
			brickSprite.setPosition((480-Player.width),Player.yPosition);
		}
	}
}
