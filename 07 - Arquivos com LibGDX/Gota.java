package com.gpjecc.blogspot.chuvagame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

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

    public Gota(SpriteBatch batch, int i) throws Exception {
        drop = new Rectangle();
        int cont = 0;
        boolean found = false;
        this.batch = batch;
        dropImage = new Texture(Gdx.files.internal("assets/droplet.png"));
        dropSound = Gdx.audio.newSound(Gdx.files.internal("assets/drop.wav"));
       
        drop.width = 64;
        drop.height = 64;
        
        FileReader fr = new FileReader("assets/save.txt");
        BufferedReader in = new BufferedReader(fr);
        String line;

     while((line = in.readLine()) != null){
        if(cont == i){
           String[] texts =  line.split(",");
           if(texts[0].equals("Gota")){
            drop.setX(Float.parseFloat(texts[1]));
            drop.setY(Float.parseFloat(texts[2]));
            found = true;
           }
        }
     }

     if(!found){
 drop.x = MathUtils.random(0, 800 - 64);
        drop.y = 480;
     }
    }

    public static int qtLinhas() throws Exception{
        int cont = 0;
        FileReader fr = new FileReader("assets/save.txt");
        BufferedReader in = new BufferedReader(fr);
        String line;

        if((line = in.readLine()) != null){
            String[] texts = line.split(",");

            if(texts[0].equals("Gota")){
                cont++;
                
            }
        }

        return cont;
    }

      public void salvaDados() throws Exception{
        FileWriter fw = new FileWriter("assets/save.txt", true);
        PrintWriter out = new PrintWriter(fw);
        out.println("Gota,"+ drop.x + "," + drop.y);
        out.close();
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

    public void dispose() throws Exception{
        dropImage.dispose();
        dropSound.dispose();
        salvaDados();
    }
    
    public void setX(float x){
        drop.x = x;
    }
}
