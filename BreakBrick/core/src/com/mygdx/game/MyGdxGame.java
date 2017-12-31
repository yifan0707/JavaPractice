package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
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
	private Player player;
	private Ball ball;
	
	@Override
	public void create () {
		player=Player.getInstance();
		ball=Ball.getInstance();

		batch = new SpriteBatch();
		brickTexture=new Texture(Player.spriteUrl);
		ballTexture=new Texture(Ball.spriteUrl);
		ballSprite=new Sprite(ballTexture);

		brickSprite=new Sprite(brickTexture);
		brickSprite.setSize(Player.width,Player.height);
		ballSprite.setSize(Ball.getWidth(),Ball.getHeight());
		ball.setxPosition(Player.xPosition);
		ball.setyPosition(Player.yPosition+20/4);
		brickSprite.setPosition(Player.xPosition,Player.yPosition);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//not sure what this do???

		//dealing with the player movement

		player.move();
		ball.move();
		movement();
		//dealing with the fireball input
		fireBall();
		//Starting to draw the images
		batch.begin();
		brickSprite.setPosition(Player.xPosition,Player.yPosition);
		ballSprite.setPosition(ball.getxPosition(),ball.getyPosition());
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



	public void movement(){
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			//player.setxVel(-4f);
			player.xPosition-=4f;
			if(ball.getOnPaddle()){
				ball.setxPosition(Player.xPosition);
			}
			//ballSprite.setPosition(ball.getxPosition()-4f,ball.getyPosition());
		}else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			//player.setxVel(4f);
			player.xPosition+=4f;
			if(ball.getOnPaddle()){
				ball.setxPosition(Player.xPosition);
			}
			//ballSprite.setPosition(ball.getxPosition()+4f,ball.getyPosition());
		}

		if(Player.xPosition<=0f){
			Player.xPosition=0f;
			brickSprite.setPosition(0,Player.yPosition);
		}else if(Player.xPosition>=(480-Player.width)){
			Player.xPosition=(480-Player.width);
			brickSprite.setPosition((480-Player.width),Player.yPosition);
		}

		if(ball.getxPosition()<=0f){
			ball.setxPosition(0f);
			brickSprite.setPosition(0,Player.yPosition);
		}else if(ball.getxPosition()>=(480-Player.width)){
			ball.setxPosition(480-Ball.getWidth());
			Player.xPosition=(480-Player.width);
			brickSprite.setPosition((480-Player.width),Player.yPosition);
		}

		//handling the movement of the ball
		//ballSprite.setPosition(ball.getxPosition(),ball.getyPosition());

	}


	public void fireBall(){
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			if(ball.getOnPaddle()){
				ball.setOnPaddle(false);
				//get xVel as random number from -1 to 1;
				//get yVel as random number from 0 to 1;
				float xVel=(float)(Math.random()*10)-5f;
				float yVel=(float)Math.random()*10;
				//give the ball the initial movement direction and speed
				ball.setVelocity(xVel,yVel);
			}
		}
	}


}
