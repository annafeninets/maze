package com.mygdx.game;
import static com.mygdx.game.Magame.SCR_HEIGHT;
import static com.mygdx.game.Magame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class ScreenGame implements Screen {
    Magame mg;
    ImgButton btnExit;
    Texture imgGame;
    Texture imgPlayer;
    Texture wallTexture;
    Texture closedTexture;
    Maze mazeGenerator = new Maze();
    int[][] firstmaze = mazeGenerator.generateMaze(10, 10);
    int[][] secondmaze = mazeGenerator.generateMaze(10, 10);
    Texture floorTexture;
    Texture exitTexture;
    SpriteBatch batch;
    Player [] player = new Player[2];
    public ScreenGame(Magame magame){
        mg = magame;
        imgGame = new Texture("gamefon.jpg");
        //imgPlayer = new Texture("circle.png");
        closedTexture = new Texture("closed.png");
        wallTexture = new Texture("wall.png");
        floorTexture = new Texture("floor.png");
        exitTexture = new Texture("exit.png");
        batch = new SpriteBatch();
        //player[0]=new Player(firstmaze.getStart(),10,imgPlayer);
        //player[1]=new Player(secondmaze.getStart(),10,imgPlayer);
        firstmaze[5][5]=0;
        secondmaze[5][5]=0;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Clear the screen
        //Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //if (Gdx.input.justTouched()) {
          //  mg.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            //mg.camera.unproject(mg.touch);
            //if (btnExit.hit(mg.touch.x, mg.touch.y)) {
             //   mg.setScreen(mg.screenIntro);
          //  }
        // Draw the matrix
        mg.camera.update();
        mg.batch.setProjectionMatrix(mg.camera.combined);
        mg.batch.begin();
        mg.batch.draw(imgGame, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        mg.font.draw(mg.batch, mg.playerName1, 250, 650);
        mg.font.draw(mg.batch, mg.playerName2, 800, 650);
        for (int x = 0; x < firstmaze.length; x++) {
           for (int y = 0; y < firstmaze[x].length; y++) {
              if (firstmaze[x][y] == 1) {
                mg.batch.draw(closedTexture, x * 40 + 140, y * 40 + 140, 40, 40);
              }  else {
                mg.batch.draw(closedTexture, x * 40 + 140, y * 40 + 140, 40, 40);
              }
        }
    }
        for (int x = 0; x < secondmaze.length; x++) {
           for (int y = 0; y < secondmaze[x].length; y++) {
             if (secondmaze[x][y] == 1) {
                mg.batch.draw(closedTexture, x*40+700, y*40+140, 40, 40);
             } else {
                mg.batch.draw(closedTexture, x*40+700, y*40+140, 40, 40);
             }
        }
    }
        btnExit = new ImgButton(exitTexture,1200,680,40,40);
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
        wallTexture.dispose();
        exitTexture.dispose();
        floorTexture.dispose();
        closedTexture.dispose();
        imgGame.dispose();    }
}
