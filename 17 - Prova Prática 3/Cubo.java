package com.gpjecc.blogspot.chuvagame;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Cubo extends Movel {

    int velocidadeY = 50;
    boolean musicPlayed;

    Cubo(Texture novoImage, Sound novoSound, Music novoMusic, Rectangle novoRect) {
        super(novoImage, novoSound, novoMusic, novoRect);

        Random random = new Random();

        rect.setX(random.nextInt(800 - 64));
        rect.setY(random.nextInt(600 - 64));
    }

    public void update() {

        rect.setY(rect.getY() + velocidadeY * Gdx.graphics.getDeltaTime());

        if (rect.getY() < 0) {

            playMusic();
        }
        if (rect.getY() > Gdx.graphics.getHeight() - rect.getHeight()) {
            if (!music.isPlaying() && !musicPlayed) {
                playMusic();
                musicPlayed = true;
            }
        }
    }
}