package game;

import processing.core.PApplet;

public class Circle_circle extends PApplet{


    @Override
    public void settings() {
        size(500, 500);
    }
    circleL c1, c2;
    @Override
    public void setup() {

    }

    @Override
    public void draw() {
        background(0,0,0);
        c1 = new circleL(mouseX,mouseY,50);
        c2 = new circleL(250,250,120);
        c2.display();
        c1.display();

        float distance = dist(c1.x,c1.y,c2.x,c2.y);
        if((distance) < ((c1.r+c2.r)/2)){
            fill(223,14,14);
            stroke(255,255,255);
            textSize(20);
            text("COLLISION!", 205, 415);
        } else {
            noFill();
            stroke(74,223,14);
        }
    }

    class circleL{
        float x, y, r;
        circleL(float x, float y, float r){
            this.x = x;
            this.y = y;
            this.r = r;
        }
        void display(){
            circle(x,y,r);
        }
    }
    public void run() {
        String[] processingArgs = { this.getClass().getName() };
        PApplet.runSketch(processingArgs, this);
    }
}
