package com.mygdx.game.entities;

public class Player {
    private static final String spriteUrl="brick.jpg";
    public static final float width=100f;
    public static final float height=20f;
    private static float xVel;
    private static float xPositon;
    public static final float yPosition=20f;

    private static final Player INSTANCE=new Player();

    private static void Player(){
       xVel=1f;
       xPositon=400f;
    }

    public static Player getInstance(){
        return INSTANCE;
    }

    public String getSpriteUrl(){
        return spriteUrl;
    }

    public void move(){

    }





}
