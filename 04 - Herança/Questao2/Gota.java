package com.gpjecc.blogspot.chuvagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;;;

public class Gota {
    private Texture dropImage;
    public Sound dropSound;
    private Rectangle drop;
    private SpriteBatch batch;

    public Gota(SpriteBatch batch) {
        drop = new Rectangle();

        this.batch = batch;
        dropImage = new Texture(Gdx.files.internal("assets/droplet.png"));
        dropSound = Gdx.audio.newSound(Gdx.files.internal("assets/drop.wav"));
        drop.x = MathUtils.random(0, 800 - 64);
        drop.y = 480;
        drop.width = 64;
        drop.height = 64;
    }



    public void draw(){
    
         batch.draw(dropImage, drop.x, drop.y);
         
    }

    public Rectangle getDrop() {
        return drop;
    }

    public void update(){
        drop.y -= 200 * Gdx.graphics.getDeltaTime();
    }

    public void dispose(){
        dropImage.dispose();
        dropSound.dispose();
    }
    
    public void setX(float x){
        drop.x = x;
    }
}
