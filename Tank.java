package labs.lab3;

public class Tank extends EnemyVehicle {
    public Tank(int minX, int maxX, int y){
        super(minX, maxX, y);
    }
    public void takeDamage(double damage){
        //take less damage
        health -= damage / 2;
    }
    public String toString(){
        return getType();
    }
    public String getType(){
        return "tank";
    }
}
