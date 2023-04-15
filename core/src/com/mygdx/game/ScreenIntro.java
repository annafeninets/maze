package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenIntro implements Screen {

    Magame mg;
    Texture zas;

    ScreenIntro(Magame magame){
        mg = magame;
        zas=new Texture("zastavka.jpg");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        mg.camera.update();
        mg.batch.setProjectionMatrix(mg.camera.combined);
        mg.batch.begin();
        mg.batch.draw(zas,0,0);
        mg.batch.end();
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
        zas.dispose();
    }
}
