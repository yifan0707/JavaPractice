package com.mygdx.game.scenes;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.BreakBrick;
import com.mygdx.game.LevelManager;
import com.mygdx.game.entities.Ball;
import com.mygdx.game.entities.Brick;
import com.mygdx.game.entities.Player;

import java.util.Iterator;
import java.util.List;

public class MainScene implements Screen {
    BreakBrick game;

    Texture brickTexture;
    Texture playerTexture;
    Texture ballTexture;
    Sprite ballSprite;
    Sprite paddleSprite;
    Player player;
    Ball ball;
    List<Brick> bricks;

    LevelManager levelManager;

    public MainScene(BreakBrick game){
        this.game=game;
        levelManager=new LevelManager();
        player=Player.getInstance();
        ball=Ball.getInstance();
    }

    @Override
    public void show() {
        brickTexture=new Texture(Brick.textureURL);
        ballTexture=new Texture(Ball.spriteUrl);
        playerTexture=new Texture(Player.spriteUrl);
        ballSprite=new Sprite(ballTexture);
        paddleSprite=new Sprite(playerTexture);

        levelManager.setupLevel(levelManager.getCurrentLevel());
        bricks=levelManager.getBricks();

        Ball.xPosition=Player.xPosition;
        Ball.yPosition=Player.yPosition+Ball.height;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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


        Iterator it=bricks.iterator();
        while(it.hasNext()){
            Brick temp=(Brick)it.next();
            if(ball.getBox().collided(temp.getBox())){
                if(!ball.hitTBSide(temp)&&!ball.hitLRSide(temp)){
                    ball.hitCorner();
                }
                it.remove();
            }
        }

        //Starting to draw the images
        game.getBatch().begin();
        for(Brick brick:bricks){
            Sprite brickSprite=new Sprite(brickTexture);
            game.getBatch().draw(brickSprite,brick.getxPosition(),brick.getyPosition(),Brick.width,Brick.height);
        }
        game.getBatch().draw(paddleSprite,Player.xPosition,Player.yPosition,Player.width,Player.height);
        game.getBatch().draw(ballSprite,Ball.xPosition,Ball.yPosition,Ball.width,Ball.height);

        game.getBatch().end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        ballTexture.dispose();
        playerTexture.dispose();
        game.getBatch().dispose();
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
        if(Ball.onPaddle==false){
            if(Ball.yPosition<0f||bricks.size()==0){
                Player.xPosition=BreakBrick.WIDTH/2;
                Ball.xPosition=Player.xPosition;
                Ball.yPosition=Player.yPosition+Ball.height;
                Ball.xVel=0f;
                Ball.yVel=0f;
                Ball.onPaddle=true;
            }
        }
    }


}
