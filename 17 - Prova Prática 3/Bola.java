package com.gpjecc.blogspot.chuvagame;

import java.util.Random;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bola extends Movel{

    int velocidadeX, velocidadeY;

    Bola(Texture novoImage, Sound novoSound, Music novoMusic, Rectangle novoRect) {
        super(novoImage, novoSound, novoMusic, novoRect);
        
        int controlX, controlY;
        Random random =  new Random();

        rect.setX(random.nextInt(800));
        rect.setY(random.nextInt(600));
        
        velocidadeX =  100 + random.nextInt(200);
        velocidadeY = 100 +  random.nextInt(200);

        controlX = random.nextInt(2);
        controlY = random.nextInt(2);

        if(controlX == 1){
            velocidadeX = velocidadeX * -1;
        }
        if(controlY == 1){
            velocidadeY = velocidadeY * -1;
        }
        
    }

    
    public void update() {
        rect.setX(rect.getX() + velocidadeX * Gdx.graphics.getDeltaTime());
        rect.setY(rect.getY() + velocidadeY * Gdx.graphics.getDeltaTime());


        if (rect.getX() < 0) {
            rect.setX(0);
            velocidadeX = velocidadeX * -1;
            playSound();
        } else if (rect.getX() > Gdx.graphics.getWidth() - rect.getWidth()) {
            rect.setX(Gdx.graphics.getWidth() - rect.getWidth());
            velocidadeX = velocidadeX * -1;
            playSound();
        }



        if (rect.getY() < 0) {
            velocidadeY = velocidadeY * -1;
            rect.setY(0);
            playSound();
        }
        if (rect.getY() > Gdx.graphics.getHeight()  - rect.getHeight()) {
            velocidadeY = velocidadeY * -1;
            playSound();
            rect.setY(Gdx.graphics.getHeight() - rect.getHeight());
        }           
    }

    
    
}