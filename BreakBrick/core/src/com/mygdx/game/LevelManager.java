package com.mygdx.game;

import com.mygdx.game.entities.Brick;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    private int currentLevel;   //level are from 1 to 5
    private List<Brick> bricks;

    public LevelManager(){
        bricks=new ArrayList<Brick>();
    }

    public void setupLevel1(){
        float xPosition=Brick.width;
        float yPosition=BreakBrick.height*(3f/4f);


        for(int i=0;i<16;i++){
            Brick brick=new Brick(xPosition,yPosition);
            if(xPosition<=BreakBrick.width-Brick.width){
                System.out.println(brick.getxPosition()+" "+brick.getyPosition());
                bricks.add(brick);
                xPosition+=Brick.width;
            }else{
                yPosition+=Brick.height+1f;
                xPosition=Brick.width;
                brick.setxPosition(xPosition);
                brick.setyPosition(yPosition);

                bricks.add(brick);

                xPosition+=Brick.width;
            }
        }
    }

    public List<Brick> getBricks(){
        return bricks;
    }
}
