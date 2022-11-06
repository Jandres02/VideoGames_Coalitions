package game;

import processing.core.PApplet;

public class Rect_circle extends PApplet{


    @Override
    public void settings() {
        size(500, 500);
    }

    rectL r1;
    circleL c1;
    circleL c2;
    @Override
    public void setup() {

    }

    @Override
    public void draw() {
        background(0,0,0);
        r1 = new rectL(168,205,165,90);
        c1 = new circleL(mouseX,mouseY,50);
        c2 = new circleL(c1.x,c1.y,5);
        r1.display();
        c1.display();
        c2.display();

        
        if(c2.x < r1.x){
            c2.x = r1.x;
        }
        if(c2.x > r1.x+r1.w){
            c2.x = r1.x+r1.w;
        }
        if(c2.y < r1.y){
            c2.y = r1.y;
        }
        if(c2.y > r1.y+r1.h){
            c2.y = r1.y+r1.h;
        }
        float distance = dist(c1.x,c1.y,c2.x,c2.y);
		float offset = 2;
        
        if((distance + offset) < ((c1.r+c2.r)/2)){
            fill(223,14,14);
            stroke(255,255,255);
            textSize(20);
            text("COLLISION!", 205, 415);
        } else {
            noFill();
            stroke(74,223,14);
        }
		line(c1.x, c1.y, c2.x, c2.y);

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

