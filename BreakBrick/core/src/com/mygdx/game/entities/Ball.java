package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.CollisionBox;

import java.util.Iterator;
import java.util.List;

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
        Ball.xVel=0f;
        Ball.yVel=0f;
        box=new CollisionBox(xPosition,yPosition,width,height);
    }

    public static Ball getInstance(){
        return INSTANCE;
    }

    public static void setVelocity(float xVel,float yVel){
        Ball.xVel=xVel;
        Ball.yVel=yVel;
    }

    public void move(){
        if(xVel!=0f&&yVel!=0f){
            xPosition+=xVel;
            yPosition+=yVel;
        }
        box.move(xPosition,yPosition);
    }

    private CollisionBox getBox() {
        return box;
    }

    public Boolean hitTheBrick(List<Brick> bricks){
        Iterator it=bricks.iterator();
        while(it.hasNext()){
            Brick temp=(Brick)it.next();
            if(this.getBox().collided(temp.getBox())){
                if(yPosition>=temp.getyPosition()-height/2&&yPosition<=temp.getyPosition()+Brick.height-height/2){
                    xVel=-xVel;
                }else if(xPosition>=temp.getxPosition()-width/2&&xPosition<=temp.getxPosition()+Brick.width-width/2){
                    yVel=-yVel;
                }else{
                    xVel=-xVel;
                    yVel=-yVel;
                }
                it.remove();
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
