package com.mygdx.game.entities;

import com.mygdx.game.BreakBrick;
import com.mygdx.game.CollisionBox;

public class Player {
    public static final String spriteUrl="paddle.jpg";
    public static final int width=70;
    public static final int height=10;
    public static float xPosition;
    public static final float yPosition=20f;

    private static final Player INSTANCE=new Player();
    private CollisionBox box;

    private Player(){
       xPosition= BreakBrick.WIDTH/2;
       System.out.println(xPosition);
       box=new CollisionBox(xPosition,yPosition,width,height);
    }

    public static Player getInstance(){
        return INSTANCE;
    }

    public void hitTheEdge(){
        if(Player.xPosition<=0f){
            Player.xPosition=0f;
        }else if(Player.xPosition>=(480-Player.width)){
            Player.xPosition=(480-Player.width);
        }
    }

//    public CollisionBox getBox() {
//        return box;
//    }
}
