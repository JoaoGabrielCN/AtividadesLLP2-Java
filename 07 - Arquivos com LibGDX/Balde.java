package com.gpjecc.blogspot.chuvagame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.classfile.BufWriter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.audio.Sound;

public class Balde {
    private Texture bucketImage;
    private Rectangle bucket;
    private SpriteBatch batch;
    private OrthographicCamera camera;
   

    public Balde(SpriteBatch batch, OrthographicCamera camera) {
        this.batch = batch;
        this.camera = camera;
        bucketImage = new Texture(Gdx.files.internal("assets/bucket.png"));
        bucket = new Rectangle();
        bucket.width = 64;
        bucket.height = 64;
    }

    
    public void draw() {
        batch.draw(bucketImage, bucket.x, bucket.y);
    }

    public void move() {
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.x = touchPos.x - 64 / 2;
            // System.out.println("Mouse");
        }

        if (Gdx.input.isKeyPressed(Keys.LEFT))
            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            bucket.x += 200 * Gdx.graphics.getDeltaTime();

        // make sure the bucket stays within the screen bounds
        if (bucket.x < 0)
            bucket.x = 0;
        if (bucket.x > 800 - 64)
            bucket.x = 800 - 64;
    }

    public Balde(String path, SpriteBatch batch, OrthographicCamera camera) throws Exception{
        FileReader fr = new FileReader(path);
        BufferedReader in = new BufferedReader(fr);
        String line;
        Boolean found = false;
        this.batch = batch;
        this.camera = camera;
        bucketImage = new Texture(Gdx.files.internal("assets/bucket.png"));
        bucket = new Rectangle();
        bucket.width = 64;
        bucket.height = 64;
        while(( line = in.readLine()) != null){
            String[] texts = line.split(",");

            if(texts[0].equals("Balde")){
                bucket.setX(Float.parseFloat(texts[1]));
                bucket.setY(Float.parseFloat(texts[2]));
                
                found = true;
            }
        }

        if(!found){
        bucket.x = 800 / 2 - 64 / 2;
        bucket.y = 20;
        }

        
    }

    public void salvaDados() throws Exception{
        FileWriter fw = new FileWriter("assets/save.txt");
        PrintWriter out = new PrintWriter(fw);
        out.println("Balde,"+ bucket.x + "," + bucket.y);
        out.close();
        
    }

    public void colide(Gota gota){
         
      
         if(gota.getDrop().overlaps(bucket)) {
            gota.dropSound.play();
            gota.setX(100000);
         }
      
    }

    public void dispose() throws Exception{
        bucketImage.dispose();
        salvaDados();
    }
}
