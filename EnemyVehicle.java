package labs.lab3;
import java.awt.*;
import java.util.Random;

abstract class EnemyVehicle implements Movable, Destructible {
    Random rand = new Random();
    final int BASE_SPEED = 3;
    protected double health = 100;
    protected  int CoordinateX;
    protected  int CoordinateY;
    protected int maximumX;
    protected Point p;
    EnemyVehicle(int minX, int maxX, int y){
        CoordinateX = rand.nextInt(minX, maxX);
        CoordinateY = y;
        p = new Point(CoordinateX, CoordinateY);
        maximumX = maxX;
    }
    public int getDistanceToBorder(){
        return maximumX - CoordinateX;
    }
    abstract String getType();
    public void move(){
        p.move(CoordinateX,  CoordinateY - BASE_SPEED);
    }
    public Point getLocation(){
        return p;
    }
    public boolean isDestroyed(){
        if(health == 0){
            return true;
        }
        return false;
    }
    public void takeDamage(double damage){
        health -= damage;
    }
}
