package com.mygdx.game.entities;

import com.mygdx.game.BreakBrick;

public class Player {
    public static final String spriteUrl="paddle.jpg";
    public static final float width=70f;
    public static final float height=10f;
    public static float xVel;
    public static float xPosition;
    public static final float yPosition=20f;

    private static final Player INSTANCE=new Player();

    private Player(){
       xVel=0f;
       xPosition= BreakBrick.width/2;
       System.out.println(xPosition);
    }

    public static Player getInstance(){
        return INSTANCE;
    }

    public void setxVel(float xVel){
        this.xVel=xVel;
    }

    public void move(){
        this.xPosition+=xVel;
    }


}
