import java.util.ArrayList;

ArrayList<Particle> particles = new ArrayList<Particle>();
String timestamp;

void setup(){
  size(720,480);
  timestamp = year() + "-" + nf(month(), 2) + "-" + nf(day(), 2) + "_"  + nf(hour(), 2) + "-" + nf(minute(), 2) + "-" + nf(second(), 2);
  background(0);
  smooth();
}

void draw(){
  background(0);
  for (int i = 0; i < particles.size(); i++){
    particles.get(i).display();
    if (particles.get(i).age > 99){
      particles.remove(i);
    }
  }
}

void mouseDragged(){

  for(int i = 0; i < random(1,2); i++){
    Particle newParticle = new Particle(mouseX, mouseY);
    particles.add(newParticle);
  }
  printArray(particles.toArray());

}

void keyPressed() {
  if (key == 's') saveFrame("Screen " + timestamp + " ####.png");
}
