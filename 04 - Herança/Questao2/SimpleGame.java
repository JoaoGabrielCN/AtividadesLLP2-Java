package com.gpjecc.blogspot.chuvagame;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class SimpleGame extends ApplicationAdapter {

   private Gota gota;
   private Music rainMusic;
   private SpriteBatch batch;
   private OrthographicCamera camera;

   private Array<Gota> raindrops;
   private Balde balde;

   private long lastDropTime;

   @Override
   public void create() {

      rainMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/rain.mp3"));

      rainMusic.setLooping(true);
      rainMusic.play();

      camera = new OrthographicCamera();
      camera.setToOrtho(false, 800, 480);
      batch = new SpriteBatch();

      balde = new Balde(batch, camera);

      raindrops = new Array<Gota>();

   }

   @Override
   public void render() {

      Gdx.gl.glClearColor(0, 0, 0.2f, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      camera.update();

      batch.setProjectionMatrix(camera.combined);

      batch.begin();
      balde.draw();
      for (Gota gota : raindrops) {
         gota.update();
         gota.draw();
      }
      batch.end();

      balde.move();

      if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
         Gota tempGota = new Gota(batch);
         raindrops.add(tempGota);
         lastDropTime = TimeUtils.nanoTime();

      }
      ;

      for (Gota gota : raindrops) {
         balde.colide(gota);
      }

   }

   @Override
   public void dispose() {

      balde.dispose();
      for (Gota gota : raindrops) {
         gota.dispose();
      }
      rainMusic.dispose();
      batch.dispose();
   }
}