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

  void display(){
    int strW = 2;
    for(int i = 0; i < flare; i++){
      strokeWeight(strW * i);
      stroke(#ff9e09, 60 - (i * 4) - age * 2);
      line(location.x, location.y, location.x - speed.x * vecWidth / widthCoef, location.y - speed.y * vecWidth / widthCoef);
    }
    strokeWeight(strW);
    stroke(#ffffff, 100 - age*2);
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
