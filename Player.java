package labs.lab3;
import java.util.ArrayList;

public class Player {
    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;
    private int point = 0;
    public Player(){
        
    }
    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies){
            //this method should check if there are any EnemyVehicle
//objects in a circular area whose center is (x, y) and radius is
//BOMB_RADIUS, and if so, call their takeDamage() methods.
        int enemySize = enemies.size();
        while(enemySize > 0){
            if(Math.pow( (Math.pow(Math.abs(enemies.get(enemySize - 1).CoordinateX - x), 2) + Math.pow(Math.abs(enemies.get(enemySize - 1).CoordinateY - y), 2)), 1/2) < BOMB_RADIUS){
                enemies.get(enemySize - 1).takeDamage(DAMAGE);
            }
            enemySize--;
        }
    }
    public void increment(){
        point++;
    }
    public int getPoint(){
        return point;
    }
}
