package com.mygdx.game;

import static com.mygdx.game.Magame.SCR_HEIGHT;
import static com.mygdx.game.Magame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenSettings implements Screen {
    Magame mg;
    Texture imgSettings;

    TextButton btnName1, btnName2, btnBack;
    InputKeyboard keyboard;


    boolean isEnterName1;
    boolean isEnterName2;
    public ScreenSettings(Magame magame){
        mg = magame;
        imgSettings = new Texture("settingfon.jpg");

        btnName1 = new TextButton(mg.fontLarge, "Имя: "+mg.playerName1, 20, 500, true);
        btnName2 = new TextButton(mg.fontLarge, "Имя: "+mg.playerName2, 20, 400, true);
        btnBack = new TextButton(mg.fontLarge, "Назад", 20, 300, true);

        keyboard = new InputKeyboard(SCR_WIDTH, SCR_HEIGHT/1.7f, 10);
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
            if(isEnterName1){
                if(keyboard.endOfEdit(mg.touch.x, mg.touch.y)){
                    mg.playerName1 = keyboard.getText();
                    btnName1.setText("Имя: "+mg.playerName1);
                    isEnterName1 = false;
                }
            } else {
                if (btnName1.hit(mg.touch.x, mg.touch.y)) {
                    isEnterName1 = true;
                }
                }
            }

        mg.camera.update();
        mg.batch.setProjectionMatrix(mg.camera.combined);
        mg.batch.begin();
        mg.batch.draw(imgSettings, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnName1.font.draw(mg.batch, btnName1.text, btnName1.x, btnName1.y);
        btnName2.font.draw(mg.batch, btnName2.text, btnName2.x, btnName2.y);
        btnBack.font.draw(mg.batch, btnBack.text, btnBack.x, btnBack.y);
        if(isEnterName1) keyboard.draw(mg.batch);
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
        saveSettings();
    }

    @Override
    public void dispose() {
        imgSettings.dispose();
        keyboard.dispose();
    }
    void saveSettings() {
        Preferences pref = Gdx.app.getPreferences("settings");
        pref.putString("namePlayer1", mg.playerName1);
        pref.putString("namePlayer2", mg.playerName2);
        pref.flush();
    }

    void loadSettings() {
        Preferences pref = Gdx.app.getPreferences("settings");
        if(pref.contains("namePlayer1")) mg.playerName1 = pref.getString("namePlayer1");
        if(pref.contains("namePlayer2")) mg.playerName2 = pref.getString("namePlayer2");
        buttonsUpdate();
    }

    void buttonsUpdate() {
        btnName1.setText("Имя: "+mg.playerName1);
        btnName2.setText("Имя: "+mg.playerName2);
    }
}

