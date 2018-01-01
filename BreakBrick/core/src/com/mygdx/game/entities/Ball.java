package com.mygdx.game.entities;

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

    private Ball(){
        onPaddle=true;
        this.xVel=0f;
        this.yVel=0f;
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
    }

    public void hitTheWall(){
        xVel=-xVel;
    }

    public void hitTheCelling(){
        yVel=-yVel;
    }

    public void hitThePlayer(){
        yVel=-yVel;
    }
}
