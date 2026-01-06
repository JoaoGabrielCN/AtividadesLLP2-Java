package com.gpjecc.blogspot.chuvagame;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.TimeUtils;

public class SimpleGame extends ApplicationAdapter {

   private Gota gota;
   private Music rainMusic;
   private SpriteBatch batch;
   private OrthographicCamera camera;

   private ArrayList<Gota> raindrops;
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

      try {
         balde = new Balde("assets/save.txt", batch, camera);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      raindrops = new ArrayList<Gota>();

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
         Gota tempGota;
         try {
            tempGota = new Gota(batch, Gota.qtLinhas());
            raindrops.add(tempGota);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         lastDropTime = TimeUtils.nanoTime();

      }
      ;

      for (Gota gota : raindrops) {
         balde.colide(gota);
      }

   }

   @Override
   public void dispose()  {

      try {
         balde.dispose();
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      for (Gota gota : raindrops) {
         try {
            gota.dispose();
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      rainMusic.dispose();
      batch.dispose();
      
   }
}