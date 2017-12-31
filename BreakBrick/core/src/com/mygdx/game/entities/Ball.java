package com.mygdx.game.entities;

public class Ball {
    private static Ball INSTANCE=new Ball();
    public static final String spriteUrl="ball.png";
    private static final int width=20;
    private static final int height=20;
    private static boolean onPaddle;
    private static float xPosition;
    private static float yPosition;
    private static float xVel;
    private static float yVel;

    private Ball(){
        onPaddle=true;
        this.xVel=0f;
        this.yVel=0f;
    }

    public static Ball getInstance(){
        return INSTANCE;
    }

    public void setOnPaddle(boolean status){
        onPaddle=status;
    }

    public Boolean getOnPaddle(){
        return onPaddle;
    }

    public void setVelocity(float xVel,float yVel){
        this.xVel=xVel;
        this.yVel=yVel;
    }

    public float getXVel(){
        return xVel;
    }

    public float getYVel(){
        return yVel;
    }

    public float getxPosition() {
        return xPosition;
    }

    public float getyPosition(){
        return yPosition;
    }

    public void setxPosition(float xPosition){
        this.xPosition=xPosition;
    }

    public void setyPosition(float yPosition){
        this.yPosition=yPosition;
    }

    public void move(){
        if(xVel!=0f&&yVel!=0f){
            xPosition+=xVel;
            yPosition+=yVel;
        }
    }

    public static int getWidth(){
        return width;
    }

    public static int getHeight(){
        return height;
    }


}
