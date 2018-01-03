package com.mygdx.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.BreakBrick;


public class MenuScene implements Screen {

    BreakBrick game;
    private Texture startButtonTexture;
    private Texture exitButtonTexture;

    private Sprite startButtonSprite;
    private Sprite exitButtonSprite;

    public MenuScene(BreakBrick game){
        this.game=game;
    }

    @Override
    public void show() {
        startButtonTexture=new Texture("start_button.png");
        exitButtonTexture=new Texture("exit_button.png");
        exitButtonSprite=new Sprite(exitButtonTexture);
        startButtonSprite=new Sprite(startButtonTexture);
        exitButtonSprite.setSize(100f,50f);
        exitButtonSprite.setPosition(BreakBrick.WIDTH/2-exitButtonSprite.getWidth()/2,
                BreakBrick.HEIGHT/2-exitButtonSprite.getHeight()/2-80f);
        startButtonSprite.setSize(100f,50f);
        startButtonSprite.setPosition(BreakBrick.WIDTH/2-startButtonSprite.getWidth()/2,
                BreakBrick.HEIGHT/2-startButtonSprite.getHeight()/2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mouseInput();

        game.getBatch().begin();
        startButtonSprite.draw(game.getBatch());
        exitButtonSprite.draw(game.getBatch());
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        startButtonTexture.dispose();
        exitButtonTexture.dispose();
    }

    public void mouseInput(){
        if(Gdx.input.getX()<startButtonSprite.getX()+startButtonSprite.getWidth()&&Gdx.input.getX()>startButtonSprite.getX()
                &&BreakBrick.HEIGHT-Gdx.input.getY()<startButtonSprite.getY()+startButtonSprite.getHeight()
                &&BreakBrick.HEIGHT-Gdx.input.getY()>startButtonSprite.getY()){
            if(Gdx.input.isTouched()){
                dispose();
                game.setScreen(new MainScene(game));
            }
        }

        if(Gdx.input.getX()<exitButtonSprite.getX()+exitButtonSprite.getWidth()&&Gdx.input.getX()>exitButtonSprite.getX()
                &&BreakBrick.HEIGHT-Gdx.input.getY()<exitButtonSprite.getY()+exitButtonSprite.getHeight()
                &&BreakBrick.HEIGHT-Gdx.input.getY()>exitButtonSprite.getY()
                ){
            if(Gdx.input.isTouched()){
                dispose();
                Gdx.app.exit();
            }
        }
    }

}
