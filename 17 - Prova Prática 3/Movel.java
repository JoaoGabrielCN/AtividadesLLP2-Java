package com.gpjecc.blogspot.chuvagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

class Movel {
    protected Texture image;
    protected Sound sound;
    protected Music music;

    protected Rectangle rect;

    Movel(Texture novoImage, Rectangle novoRect) {
        this(novoImage, null, null, novoRect);
    }

    Movel(Texture novoImage, Sound novoSound, Music novoMusic, Rectangle novoRect) {
        image = novoImage;// new Texture(Gdx.files.internal("assets/droplet.png"));
        sound = novoSound;// Gdx.audio.newSound(Gdx.files.internal("assets/drop.wav"));
        music = novoMusic;// Gdx.audio.newMusic(Gdx.files.internal("assets/rain.mp3"));

        // create the camera and the SpriteBatch
        rect = novoRect;
    }

    public void playMusic() {
        if (music == null)
            return;
        // start the playback of the background music immediately
        music.setLooping(false);
        music.play();

    }

    public void playSound() {
        if (sound == null)
            return;
        sound.play();
    }

    public void draw(SpriteBatch batch) {
        if ((image == null) || (rect == null))
            return;
        batch.draw(image, rect.x, rect.y, rect.width, rect.height);
    }

    public void dispose() {
        image.dispose();
        sound.dispose();
        music.dispose();
    }

    public float getX() {
        return rect.x;
    }

    public void setX(float x) {
        this.rect.x = x;
    }

    public float getY() {
        return rect.y;
    }

    public void setY(float y) {
        this.rect.y = y;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public void update() {
        int velocidade  = 200;
        // Mouse
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            rect.setX(touchPos.x);
            rect.setY(touchPos.y);
        }

        // Keyboard 

        if (Gdx.input.isKeyPressed(Keys.LEFT))
            rect.setX(rect.getX() - velocidade * Gdx.graphics.getDeltaTime());
        else if (Gdx.input.isKeyPressed(Keys.RIGHT))
            rect.setX(rect.getX() + velocidade * Gdx.graphics.getDeltaTime());

        if (rect.getX() < 0) {
            rect.setX(0);
            playSound();
        } else if (rect.getX() > Gdx.graphics.getWidth() - rect.getWidth()) {
            rect.setX(Gdx.graphics.getWidth() - rect.getWidth());
            playSound();
        }

        if (Gdx.input.isKeyPressed(Keys.UP))
            rect.setY(rect.getY() + 200 * Gdx.graphics.getDeltaTime());
        else if (Gdx.input.isKeyPressed(Keys.DOWN))
            rect.setY(rect.getY() - 200 * Gdx.graphics.getDeltaTime());

        if (rect.getY() < 0) {
            rect.setY(0);
        }
        if (rect.getY() > Gdx.graphics.getHeight()  - rect.getHeight()) {
            rect.setY(Gdx.graphics.getHeight() - rect.getHeight());
        }        
    }
}
