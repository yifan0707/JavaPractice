package com.mygdx.game;

import com.mygdx.game.entities.Ball;
import com.mygdx.game.entities.Player;

public class CollisionBox {
    private float xPosition;
    private float yPosition;
    private int width;
    private int height;
    public CollisionBox(float x,float y,int width, int height){
        this.xPosition=x;
        this.yPosition=y;
        this.width=width;
        this.height=height;
    }

    /**
     * return true two object's collision box collided
     * return false if not collided
     * @param box
     * @return
     */
    public Boolean collided(CollisionBox box){
        if(this.xPosition<box.xPosition+box.width&&this.yPosition<box.yPosition+box.height){
            if(this.xPosition+this.width>box.xPosition&&this.yPosition+this.height>box.yPosition){
                return true;
            }
        }
        return false;
    }

    public void move(float x,float y){
        this.xPosition=x;
        this.yPosition=y;
    }

}
