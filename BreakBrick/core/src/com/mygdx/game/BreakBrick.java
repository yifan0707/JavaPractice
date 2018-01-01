package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Ball;
import com.mygdx.game.entities.Brick;
import com.mygdx.game.entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class BreakBrick extends ApplicationAdapter{
	SpriteBatch batch;
	Texture ballTexture;
	Texture playerTexture;
	Texture brickTexture;

	//Texture test;
	Sprite testSprite;
	public static final int width=480;
	public static final int height=320;
	private Sprite ballSprite;
	private Sprite paddleSprite;
	private Player player;
	private Ball ball;
	private LevelManager levelManager;
	private List<Brick> bricks;
	
	@Override
	public void create () {
		player=Player.getInstance();
		ball=Ball.getInstance();

		levelManager=new LevelManager();
		levelManager.setupLevel1();
		bricks=levelManager.getBricks();
		brickTexture=new Texture(Brick.textureURL);

//		test=new Texture(Brick.textureURL);
//		testSprite=new Sprite(test);
//		testSprite.setSize(200,50);
//		testSprite.setPosition(0,0);
//		testSprite=new Sprite(test,0,0,80,50);

		batch = new SpriteBatch();
		playerTexture=new Texture(Player.spriteUrl);
		ballTexture=new Texture(Ball.spriteUrl);
		ballSprite=new Sprite(ballTexture);

		paddleSprite=new Sprite(playerTexture);
		paddleSprite.setSize(Player.width,Player.height);
		ballSprite.setSize(Ball.width,Ball.height);
		Ball.xPosition=Player.xPosition;
		Ball.yPosition=Player.yPosition+Ball.height;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//not sure what this do???

		//dealing with the player movement
		ball.move();
		//handle the user input
		gameInput();
		//handle the collision
		hitTheEdge();
		hitTheBall();
		//dealing with respawn
		respawn();

		//Starting to draw the images
		batch.begin();
		for(Brick brick:bricks){
			Sprite brickSprite=new Sprite(brickTexture);
			brickSprite.setSize(Brick.width,Brick.height);
			brickSprite.setPosition(brick.getxPosition(),brick.getyPosition());
			brickSprite.draw(batch);
		}

		//testSprite.draw(batch);

		paddleSprite.setPosition(Player.xPosition,Player.yPosition);
		ballSprite.setPosition(Ball.xPosition,Ball.yPosition);
		paddleSprite.draw(batch);
		ballSprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		playerTexture.dispose();
		ballTexture.dispose();
	}

	public void gameInput(){
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			player.xPosition-=4f;
			if(Ball.onPaddle){
				Ball.xPosition=Player.xPosition;
			}
		}else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			player.xPosition+=4f;
			if(Ball.onPaddle){
				Ball.xPosition=Player.xPosition;
			}
		}else if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			if (Ball.onPaddle) {
				Ball.onPaddle = false;
				if(Math.random()>=0.5f){
					ball.setVelocity(3f, 3f);
				}else{
					ball.setVelocity(-3f,3f);
				}
			}
		}
	}

	public void hitTheEdge(){
		if(Ball.xPosition<=0f){
			Ball.xPosition=0f;
			ball.hitTheWall();
		}else if(Ball.xPosition>=(480-Ball.width)){
			Ball.xPosition=(480-Ball.width);
			ball.hitTheWall();
		}

		if(Player.xPosition<=0f){
			Player.xPosition=0f;
		}else if(Player.xPosition>=(480-Player.width)){
			Player.xPosition=(480-Player.width);
		}

		if(Ball.yPosition>=height-Ball.height){
			ball.hitTheCelling();
		}
	}

	public void hitTheBall(){
		if(!Ball.onPaddle&&Ball.yVel<0){
			//hit the middle of the paddle
			if((Ball.xPosition>=Player.xPosition&&Ball.xPosition<=Player.xPosition+Player.width)
				&&(Ball.yPosition>Player.yPosition&&Ball.yPosition<(Player.yPosition+Ball.height))){
				ball.hitThePlayer();
			}

			//hit the left top corner of the paddle
			if(Ball.xPosition<Player.xPosition&&Ball.xPosition>Player.xPosition-Ball.width){
				if(Ball.yPosition>Player.yPosition&&Ball.yPosition<Player.yPosition+Player.height){
					if(Ball.xVel>=0){
						Ball.yVel=-Ball.yVel;
						Ball.xVel=-Ball.xVel;
					}
				}
			}

			//hit the right top corner of the paddle
			if(Ball.xPosition<Player.xPosition+Player.width&&Ball.xPosition>Player.xPosition+Player.width-Ball.width){
				if(Ball.yPosition>Player.yPosition&&Ball.yPosition<Player.yPosition+Player.height){
					if(Ball.xVel<=0){
						Ball.yVel=(-1)*Ball.yVel;
						Ball.xVel=(-1)*Ball.xVel;
					}
				}
			}
		}
	}

	public void respawn(){
		if(Ball.yPosition<0f){
			Player.xPosition=width/2;
			Ball.xPosition=Player.xPosition;
			Ball.yPosition=Player.yPosition+Ball.height;
			Ball.xVel=0f;
			Ball.yVel=0f;
			Ball.onPaddle=true;
		}
	}






}
