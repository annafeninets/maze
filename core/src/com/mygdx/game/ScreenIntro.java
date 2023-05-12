package com.mygdx.game;
import static com.mygdx.game.Magame.SCR_HEIGHT;
import static com.mygdx.game.Magame.SCR_WIDTH;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
public class ScreenIntro implements Screen {
    Magame mg;
    Texture zas;
    TextButton btnPlay, btnSettings, btnAbout, btnExit;
    public ScreenIntro(Magame magame) {
        mg = magame;
        zas = new Texture("zastavka.jpg");
        btnPlay = new TextButton(mg.fontLarge, "PLAY", 100,500 );
        btnSettings = new TextButton(mg.fontLarge, "SETTINGS", 100, 400);
        btnAbout = new TextButton(mg.fontLarge, "ABOUT", 100, 300);
        btnExit = new TextButton(mg.fontLarge, "EXIT", 100, 200);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            mg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            mg.camera.unproject(mg.touch);
            if (btnPlay.hit(mg.touch.x, mg.touch.y)) {
                mg.setScreen(mg.screenGame);
            }
            if (btnSettings.hit(mg.touch.x, mg.touch.y)) {
                mg.setScreen(mg.screenSettings);
            }
            if (btnAbout.hit(mg.touch.x, mg.touch.y)) {
                mg.setScreen(mg.screenAbout);
            }
            if (btnExit.hit(mg.touch.x, mg.touch.y)) {
                Gdx.app.exit();
            }
        }
        mg.camera.update();
        mg.batch.setProjectionMatrix(mg.camera.combined);
        mg.batch.begin();
        mg.batch.draw(zas, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.font.draw(mg.batch, btnPlay.text, btnPlay.x, btnPlay.y);
        btnSettings.font.draw(mg.batch, btnSettings.text, btnSettings.x, btnSettings.y);
        btnAbout.font.draw(mg.batch, btnAbout.text, btnAbout.x, btnAbout.y);
        btnExit.font.draw(mg.batch, btnExit.text, btnExit.x, btnExit.y);
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
    public void dispose() {zas.dispose();}
}

