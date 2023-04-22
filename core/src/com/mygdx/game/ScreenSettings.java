package com.mygdx.game;

import static com.mygdx.game.Magame.SCR_HEIGHT;
import static com.mygdx.game.Magame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenSettings implements Screen {
    Magame mg;
    Texture imgBackGround;

    TextButton btnName, btnBack;
    InputKeyboard keyboard;


    boolean isEnterName;
    public ScreenSettings(Magame magame){
        mg = magame;
        imgBackGround = new Texture("settingfon.jpg");

        btnName = new TextButton(mg.fontLarge, "Имя: "+mg.playerName1, 20, 1100, true);
        btnBack = new TextButton(mg.fontLarge, "Назад", 20, 700, true);

        keyboard = new InputKeyboard(SCR_WIDTH, SCR_HEIGHT/1.7f, 8);
        loadSettings();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            mg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            mg.camera.unproject(mg.touch);
            if(isEnterName){
                if(keyboard.endOfEdit(mg.touch.x, mg.touch.y)){
                    mg.playerName1 = keyboard.getText();
                    btnName.setText("Имя: "+mg.playerName1);
                    isEnterName = false;
                }
            } else {
                if (btnName.hit(mg.touch.x, mg.touch.y)) {
                    isEnterName = true;
                }

                if (btnBack.hit(mg.touch.x, mg.touch.y)) {
                    mg.setScreen(mg.screenIntro);
                }
            }
        }

        mg.camera.update();
        mg.batch.setProjectionMatrix(mg.camera.combined);
        mg.batch.begin();
        mg.batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnName.font.draw(mg.batch, btnName.text, btnName.x, btnName.y);
        btnBack.font.draw(mg.batch, btnBack.text, btnBack.x, btnBack.y);
        if(isEnterName) keyboard.draw(mg.batch);
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
        keyboard.dispose();
    }
    void saveSettings() {
        Preferences pref = Gdx.app.getPreferences("settings");
        pref.putString("namePlayer", mg.playerName1);
        pref.flush();
    }

    void loadSettings() {
        Preferences pref = Gdx.app.getPreferences("settings");
        if(pref.contains("namePlayer")) mg.playerName1 = pref.getString("namePlayer");
        buttonsUpdate();
    }

    void buttonsUpdate() {
        btnName.setText("Имя: "+mg.playerName1);
    }
}

