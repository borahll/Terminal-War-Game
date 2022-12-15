package labs.lab3;

public class Helicopter extends EnemyVehicle {
    private int speed = BASE_SPEED;
    public Helicopter(int minX, int maxX, int y){
        super(minX, maxX, y);
    }
    public void move(){
        p.move(CoordinateX + speed, CoordinateY);
        speed++;
    }
    public String getType(){
        return "helicopter";
    }
}
