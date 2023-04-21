package com.mygdx.game;

import static com.mygdx.game.Magame.SCR_HEIGHT;
import static com.mygdx.game.Magame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenAbout implements Screen {
    Magame mg;
    Texture imgBackGround;
    TextButton btnBack;
    String textAbout =  "Эта игра-стрелялка\n" +
            "создана в IT-школе\n" +
            "Samsung на Java\n" +
            "под Android c\n" +
            "использованием LibGdx\n\n" +
            "Цель игры - сбивать\n" +
            "вражеские самолётики\n";
    public ScreenAbout(Magame magame){
        mg = magame;
        imgBackGround = new Texture("bg/cosmos04.jpg");
        btnBack = new TextButton(mg.fontLarge, "ВЫХОД", 100, 200, true);
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
        mg.batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        mg.font.draw(mg.batch, textAbout, 30, 1100);
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
        imgBackGround.dispose();
    }
}
