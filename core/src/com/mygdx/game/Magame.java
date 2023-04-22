package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Vector;

public class Magame extends com.badlogic.gdx.Game {
	public static final float SCR_WIDTH=720, SCR_HEIGHT=1280;
	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;
	BitmapFont font, fontLarge;

	ScreenIntro screenIntro;
	ScreenGame screenGame;
	ScreenSettings screenSettings;
	ScreenAbout screenAbout;
	String playerName1 = "Noname";

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera=new OrthographicCamera();
		camera.setToOrtho(false,SCR_WIDTH,SCR_HEIGHT);
		touch=new Vector3();
		generateFont();
		screenIntro=new ScreenIntro(this);
		screenGame = new ScreenGame(this);
		screenSettings = new ScreenSettings(this);
		screenAbout = new ScreenAbout(this);
		setScreen(screenIntro);

	}


	
	@Override
	public void dispose () {
		batch.dispose();
	}
	void generateFont(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Blakalnk-Regular.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 60;
		parameter.color = new Color().set(1, 0.9f, 0.4f, 1);
		parameter.borderColor = new Color().set(0, 0, 0, 1);
		parameter.borderWidth = 2;
		parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
		font = generator.generateFont(parameter);
		parameter.color = new Color().set(1, 0.9f, 0.4f, 1);
		parameter.size = 80;
		fontLarge = generator.generateFont(parameter);
		generator.dispose();
	}
}
