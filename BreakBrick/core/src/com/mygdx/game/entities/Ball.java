package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.CollisionBox;

public class Ball {
    private static Ball INSTANCE=new Ball();
    public static final String spriteUrl="ball.png";
    public static final int width=10;
    public static final int height=10;
    public static boolean onPaddle;
    public static float xPosition;
    public static float yPosition;
    public static float xVel;
    public static float yVel;
    private CollisionBox box;

    private Ball(){
        onPaddle=true;
        this.xVel=0f;
        this.yVel=0f;
        box=new CollisionBox(xPosition,yPosition,width,height);
    }

    public static Ball getInstance(){
        return INSTANCE;
    }

    public void setVelocity(float xVel,float yVel){
        this.xVel=xVel;
        this.yVel=yVel;
    }

    public void move(){
        if(xVel!=0f&&yVel!=0f){
            xPosition+=xVel;
            yPosition+=yVel;
        }

        box.move(xPosition,yPosition);
    }

    public CollisionBox getBox() {
        return box;
    }

    public Boolean hitLRSide(Brick brick){
        if(brick.getExisted()){
            if(yPosition>=brick.getyPosition()-height/2&&yPosition<=brick.getyPosition()+Brick.height-height/2){
                xVel=-xVel;
                return true;
            }
        }
        return false;
    }

    public Boolean hitTBSide(Brick brick){
        if(brick.getExisted()){
            if(xPosition>=brick.getxPosition()-width/2&&xPosition<=brick.getxPosition()+Brick.width-width/2){
                yVel=-yVel;
                return true;
            }
        }
        return false;
    }

    public void hitThePlayer(){
        if(!onPaddle&&yVel<0){
            //hit the middle of the paddle
            if((xPosition>=Player.xPosition&&Ball.xPosition<=Player.xPosition+Player.width)
                    &&(yPosition>Player.yPosition&&yPosition<Player.yPosition+height)){
                yVel=-yVel;
            }

            //hit the left top corner of the paddle
            if(xPosition<Player.xPosition&&xPosition>Player.xPosition-width){
                if(yPosition>Player.yPosition&&yPosition<Player.yPosition+Player.height){
                    if(xVel>=0){
                        yVel=-yVel;
                        xVel=-xVel;
                    }
                }
            }

            //hit the right top corner of the paddle
            if(xPosition<Player.xPosition+Player.width&&xPosition>Player.xPosition+Player.width-width){
                if(yPosition>Player.yPosition&&yPosition<Player.yPosition+Player.height){
                    if(xVel<=0){
                        yVel=(-1)*Ball.yVel;
                        xVel=(-1)*Ball.xVel;
                    }
                }
            }
        }
    }

    public void hitCorner(Brick brick){
        if(brick.getExisted()){
            xVel=-xVel;
            yVel=-yVel;
        }
    }

    public void hitTheEdge(){
        if(Ball.xPosition<=0f){
            Ball.xPosition=0f;
            Ball.xVel=-Ball.xVel;
        }else if(Ball.xPosition>=(480-Ball.width)){
            Ball.xPosition=(480-Ball.width);
            Ball.xVel=-Ball.xVel;
        }
        if(Ball.yPosition>=Gdx.graphics.getHeight()-Ball.height){
            Ball.yVel=-Ball.yVel;
        }
    }
}
