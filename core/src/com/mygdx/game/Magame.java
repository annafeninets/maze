package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Vector;

public class Magame extends com.badlogic.gdx.Game {
	public static final float SCR_WIDTH=720, SCR_HEIGHT=1280;
	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;

	ScreenIntro screenIntro;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera=new OrthographicCamera();
		camera.setToOrtho(false,SCR_WIDTH,SCR_HEIGHT);
		touch=new Vector3();
		screenIntro=new ScreenIntro(this);
		setScreen(screenIntro);

	}


	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
