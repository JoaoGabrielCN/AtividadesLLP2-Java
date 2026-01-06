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



public class Quadrado extends Movel{

    int velocidadeX, control, lifes;
    boolean morto;

    Quadrado(Texture novoImage, Sound novoSound, Music novoMusic, Rectangle novoRect) {
        super(novoImage, novoSound, novoMusic, novoRect);
        

        Random random = new Random();
        
        rect.setX(random.nextInt(400 - 64));
        rect.setY(random.nextInt(600 - 64));

        control = random.nextInt(2);

        if(control == 1){
            velocidadeX = 150;
        }else{
            velocidadeX = -150; 
        }

        lifes = 4;
        morto = false;
        }

    public void update() {
        // Mouse

        // Keyboard 

        rect.setX(rect.getX() + velocidadeX * Gdx.graphics.getDeltaTime());

        if(!morto){if (rect.getX() < 0) {
            setX(800 - 64);
            lifes--;
        } else if (rect.getX() > Gdx.graphics.getWidth() - rect.getWidth()) {
            setX(0);
            lifes--;
        }
    }
        if(lifes <= 0){
            morto = true;
            playSound();
            setX(10000);
            
        }

    }
    

}
