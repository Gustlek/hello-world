import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.ArrayList; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sparkles extends PApplet {



ArrayList<Particle> particles = new ArrayList<Particle>();
String timestamp;

public void setup(){
  
  timestamp = year() + "-" + nf(month(), 2) + "-" + nf(day(), 2) + "_"  + nf(hour(), 2) + "-" + nf(minute(), 2) + "-" + nf(second(), 2);
  background(0);
  
}

public void draw(){
  background(0);
  for (int i = 0; i < particles.size(); i++){
    particles.get(i).display();
    if (particles.get(i).age > 99){
      particles.remove(i);
    }
  }
}

public void mouseDragged(){

  for(int i = 0; i < random(1,2); i++){
    Particle newParticle = new Particle(mouseX, mouseY);
    particles.add(newParticle);
  }
  printArray(particles.toArray());

}

public void keyPressed() {
  if (key == 's') saveFrame("Screen " + timestamp + " ####.png");
}
class Particle{

  PVector location;
  PVector speed;
  int age = 0;
  int flare = 5;
  int vecWidth = 0;
  final int widthCoef = 6;
  final int death = 100;
  int speedCoef = 1;



  Particle(int nX, int nY){
    location = new PVector(nX, nY);
    speed = new  PVector((random(-speedCoef, speedCoef)), (random(-speedCoef, speedCoef)));
  }

  public void display(){
    int strW = 2;
    for(int i = 0; i < flare; i++){
      strokeWeight(strW * i);
      stroke(0xffff9e09, 60 - (i * 4) - age * 2);
      line(location.x, location.y, location.x - speed.x * vecWidth / widthCoef, location.y - speed.y * vecWidth / widthCoef);
    }
    strokeWeight(strW);
    stroke(0xffffffff, 100 - age*2);
    line(location.x, location.y, location.x - speed.x * vecWidth / widthCoef, location.y - speed.y * vecWidth / widthCoef);
    location.add(speed);
    age++;
    if (age > death / 2) {
      vecWidth--;
    } else{
      vecWidth++;
    }


  }

}
  public void settings() {  size(720,480);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sparkles" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
