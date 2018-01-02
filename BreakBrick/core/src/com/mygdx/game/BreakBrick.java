package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Ball;
import com.mygdx.game.entities.Brick;
import com.mygdx.game.entities.Player;

import java.util.List;

public class BreakBrick extends ApplicationAdapter{
	SpriteBatch batch;
	Texture ballTexture;
	Texture playerTexture;
	Texture brickTexture;
	public static final int width=480;
	public static final int height=320;
	private BitmapFont font;
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
		font=new BitmapFont(Gdx.files.internal("gamefont.fnt"));

		levelManager=new LevelManager();
		levelManager.setupLevel(levelManager.getCurrentLevel());
		bricks=levelManager.getBricks();
		brickTexture=new Texture(Brick.textureURL);
		playerTexture=new Texture(Player.spriteUrl);
		ballTexture=new Texture(Ball.spriteUrl);
		ballSprite=new Sprite(ballTexture);
		paddleSprite=new Sprite(playerTexture);
		batch = new SpriteBatch();
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
		ball.hitTheEdge();
		ball.hitThePlayer();
		player.hitTheEdge();
		//dealing with respawn
		respawn();

		for(Brick brick:bricks){
			if(ball.getBox().collided(brick.getBox())){
				if(!ball.hitTBSide(brick)&&!ball.hitLRSide(brick)){
					ball.hitCorner(brick);
				}
				brick.setExisted(false);
			}
		}

		//Starting to draw the images
		batch.begin();
		for(Brick brick:bricks){
			if(brick.getExisted()){
				Sprite brickSprite=new Sprite(brickTexture);
				batch.draw(brickSprite,brick.getxPosition(),brick.getyPosition(),Brick.width,Brick.height);
			}
		}
		batch.draw(paddleSprite,Player.xPosition,Player.yPosition,Player.width,Player.height);
		batch.draw(ballSprite,Ball.xPosition,Ball.yPosition,Ball.width,Ball.height);

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
