package com.mygdx.game.entities;

import com.mygdx.game.CollisionBox;

public class Brick {
    public static final int width=50;
    public static final int height=20;
    public static final String textureURL="brick.png";
    private boolean existed;
    private float xPosition;
    private float yPosition;
    private CollisionBox box;

    public Brick(float xPosition,float yPosition){
        this.existed=true;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.box=new CollisionBox(xPosition,yPosition,width,height);
    }

    public void setExisted(Boolean existed){
        this.existed=existed;
    }

    public Boolean getExisted(){
        return existed;
    }

    public float getxPosition(){
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

    public CollisionBox getBox() {
        return box;
    }
}
