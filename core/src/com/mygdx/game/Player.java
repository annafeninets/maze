package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
public class Player {
    int x,y;
    float width, height;
    Texture img;
    public Player(int x, int y, float width, float height, Texture img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }
}





