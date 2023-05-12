package com.mygdx.game;
import static com.mygdx.game.Magame.SCR_HEIGHT;
import static com.mygdx.game.Magame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenGame implements Screen {
    Magame mg;
    Texture imgGame;
    private Maze mazeGenerator = new Maze();
    private Texture wallTexture;
    private Texture closedTexture;
    int[][] firstmaze = mazeGenerator.generateMaze(10, 10);
    int[][] secondmaze = mazeGenerator.generateMaze(10, 10);
    private Texture floorTexture;
    private SpriteBatch batch;

    public ScreenGame(Magame magame){
        mg = magame;
        imgGame = new Texture("settingfon.jpg");
        closedTexture = new Texture("closed.png");
        wallTexture = new Texture("wall.png");
        floorTexture = new Texture("floor.png");
        batch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Draw the matrix
        mg.camera.update();
        mg.batch.setProjectionMatrix(mg.camera.combined);
        mg.batch.begin();
        for (int x = 0; x < firstmaze.length; x++) {
            for (int y = 0; y < firstmaze[x].length; y++) {
                if (firstmaze[x][y] == 1) {
                    mg.batch.draw(wallTexture, x * 32, y * 32, 32, 32);
                } else {
                    mg.batch.draw(floorTexture, x * 32, y * 32, 32, 32);
                }
            }
        }
        //for (int x = 0; x < secondmaze.length; x++) {
         //   for (int y = 0; y < secondmaze[x].length; y++) {
          //      mg.batch.draw(closedTexture,600,100,40,40);
           // }
        //}
        mg.batch.draw(imgGame, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        mg.font.draw(mg.batch, mg.playerName1, 250, 650);
        mg.font.draw(mg.batch, mg.playerName2, 800, 650);
        mg.batch.end();    }

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
        wallTexture.dispose();
        floorTexture.dispose();
        closedTexture.dispose();
        imgGame.dispose();
        batch.dispose();
    }
}
