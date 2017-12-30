package com.mygdx.game.entities;

import com.mygdx.game.MyGdxGame;

public class Player {
    public static final String spriteUrl="brick.jpg";
    public static final float width=70f;
    public static final float height=10f;
    public static float xVel;
    public static float xPosition;
    public static final float yPosition=20f;

    private static final Player INSTANCE=new Player();

    private Player(){
       xVel=1f;
       xPosition= MyGdxGame.width/2;
       System.out.println(xPosition);
    }

    public static Player getInstance(){
        return INSTANCE;
    }


}
