package com.mygdx.game;

import static com.mygdx.game.Magame.SCR_HEIGHT;
import static com.mygdx.game.Magame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenAbout implements Screen {
    Magame mg;
    Texture imgAbout;
    TextButton btnBack;
    String textAbout = "In this game you\n" +
            "have to find a way out \n" +
            "of the maze faster \n" +
            "of your opponent.\n\n";

    public ScreenAbout(Magame magame){
        mg = magame;
        imgAbout = new Texture("aboutfon.jpg");
        btnBack = new TextButton(mg.fontLarge, "EXIT", 100, 200, true);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            mg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            mg.camera.unproject(mg.touch);

            if(btnBack.hit(mg.touch.x, mg.touch.y)) {
                mg.setScreen(mg.screenIntro);
            }

        }

        mg.camera.update();
        mg.batch.setProjectionMatrix(mg.camera.combined);
        mg.batch.begin();
        mg.batch.draw(imgAbout, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        mg.font.draw(mg.batch, textAbout, 30, 700);
        btnBack.font.draw(mg.batch, btnBack.text, btnBack.x, btnBack.y);
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
        imgAbout.dispose();
    }
}
