package com.mygdx.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.BreakBrick;
import sun.applet.Main;


public class MenuScene implements Screen {

    BreakBrick game;
    private Texture buttonTexture;

    private Sprite buttonSprite;
    private BitmapFont font;
    public MenuScene(BreakBrick game){
        this.game=game;
        font=new BitmapFont(Gdx.files.internal("gamefont.fnt"));
    }

    @Override
    public void show() {
        buttonTexture=new Texture("button.png");
        buttonSprite=new Sprite(buttonTexture);
        buttonSprite.setSize(100f,50f);
        buttonSprite.setPosition(BreakBrick.WIDTH/2-buttonSprite.getWidth()/2,
                BreakBrick.HEIGHT/2-buttonSprite.getHeight()/2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_STENCIL_BITS);


        mouseInput();

        game.getBatch().begin();
        buttonSprite.draw(game.getBatch());
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

    }

    public void mouseInput(){
        if(Gdx.input.getX()<buttonSprite.getX()+buttonSprite.getWidth()&&Gdx.input.getX()>buttonSprite.getX()
                &&Gdx.input.getY()<buttonSprite.getY()+buttonSprite.getHeight()&&Gdx.input.getY()>buttonSprite.getY()){
            if(Gdx.input.isTouched()){
                dispose();
                game.setScreen(new MainScene(game));
            }
        }
    }

}
