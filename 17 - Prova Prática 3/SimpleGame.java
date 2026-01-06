package com.gpjecc.blogspot.chuvagame;


import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class SimpleGame extends ApplicationAdapter {
	
	private Texture cuboImage, quadradoImage, bolaImage;
	private Sound cuboSound, quadradoSound, bolaSound;
	private Music cuboMusic;


	private BitmapFont font;
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	

	private Cubo cubo;
	private Quadrado quadrado;
	private Bola bola;

	private ArrayList<Movel> lista;
	

	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		lista = new ArrayList<>();
		
		// load the images for the droplet and the bucket, 64x64 pixels each
		cuboImage = new Texture(Gdx.files.internal("assets/cubo.png"));
		cuboSound = Gdx.audio.newSound(Gdx.files.internal("assets/cubo.mp3"));
		cuboMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/cubo.mp3"));

		quadradoImage = new Texture(Gdx.files.internal("assets/quadrado.png"));
		quadradoSound = Gdx.audio.newSound(Gdx.files.internal("assets/quadrado.wav"));
		
		bolaImage = new Texture(Gdx.files.internal("assets/bola.png"));
		bolaSound = Gdx.audio.newSound(Gdx.files.internal("assets/bola.wav"));

		font = new BitmapFont();

		// create the camera and the SpriteBatch
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();

		// create a Rectangle to logically represent the bucket
		Rectangle cuboRect = new Rectangle();
		Rectangle quadradoRect = new Rectangle();
		Rectangle bolaRect = new Rectangle();
		
		cuboRect.width = cuboImage.getWidth();
		cuboRect.height = cuboImage.getHeight();

		quadradoRect.width = quadradoImage.getWidth();
		quadradoRect.height = quadradoImage.getHeight();
		
		bolaRect.width = bolaImage.getWidth();
		bolaRect.height = bolaImage.getHeight();
		
		Random random = new Random();
		
		int control;

		for(int i = 0; i < 6; i++){
		control = random.nextInt(3);

		if(control == 0){
			lista.add(new Cubo(cuboImage, null, cuboMusic, cuboRect));
		}
		if(control == 1){
			lista.add(new Quadrado(quadradoImage, quadradoSound, null, quadradoRect));
		}
		if(control == 2){
			lista.add(new Bola(bolaImage, bolaSound, null, bolaRect));
		}
		
		if(lista.get(i) instanceof Cubo){
			System.out.println("SOU O CUBO  "+ i);
		}
	}

	lista.add(new Bola(bolaImage, bolaSound, null, bolaRect));

	}

	@Override
	public void render() {
		// clear the screen with a dark blue color. The
		// arguments to glClearColor are the red, green

		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// tell the camera to update its matrices.
		camera.update();

		// tell the SpriteBatch to render in the
		// coordinate system specified by the camera.
		batch.setProjectionMatrix(camera.combined);

		// begin a new batch and draw the bucket and
		// all drops
		batch.begin();
		{
			for (Movel movel : lista) {
				movel.draw(batch);
			}		
			font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(),740,470);
		}
		batch.end();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
		}
		for (Movel movel : lista) {
			movel.update();
		}		

	}

	@Override
	public void dispose() {
		// dispose of all the native resources
		for (Movel movel : lista) {
			movel.dispose();
		}
		batch.dispose();
	}
}
