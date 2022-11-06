package game;

import processing.core.PApplet;
import processing.core.PImage;

public class Rect_rect extends PApplet{
    
    
    @Override
    public void settings() {
        size(500, 500);
    }
    
    rectL r1;
    rectL r2;
    PImage casa, bus;
    @Override
    public void setup() { 
        
    }
    
    @Override
    public void draw() {    
        background(30,27,32);
        r2 = new rectL(168,205,165,90);
        r1 = new rectL(mouseX,mouseY,135,60);
        casa = loadImage("src/images/casa.png");
        bus = loadImage("src/images/bus.png");
        casa.resize(165,90);
        bus.resize(135,60);
        r2.display();
        image(casa,168,205);
        r1.display();
        image(bus,mouseX,mouseY);
        
        if(r1.x > r2.x+r2.w || r1.x+r1.w < r2.x || r1.y > r2.y+r2.h || r1.y+r1.h < r2.y){
            noFill();
            stroke(255,255,255);
            strokeWeight(5);
        } else {
            fill(223,14,14);
            stroke(255,255,255);
            strokeWeight(5);
            textSize(20);
            text("COLLISION!", 200, 415);

        }

    }

    class rectL {
        float x,y,w,h;
        rectL(float x, float y, float w, float h){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
        void display(){
            rect(x,y,w,h);
        }
    }


    public void run() {
        String[] processingArgs = { this.getClass().getName() };
        PApplet.runSketch(processingArgs, this);
    }
}
