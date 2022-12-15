package labs.lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Difficulty{
    private int difficulty;
    final int STARTING_DISTANCE = 20;
    Player p1;
    ArrayList<EnemyVehicle> enemies = new ArrayList<>();
    final int MAX_NO_OF_PASSING_ENEMIES;
    int passingNoOfEnemies = 0;

    public Game(int difficulty){
        this.setDifficulty(difficulty);
        p1 = new Player();
        if(getDifficulty() == 1){
            MAX_NO_OF_PASSING_ENEMIES = 2;
            for(byte a = 0; a < 2; a++){
                getRandomVehicle();
            } 
        }
        else if(getDifficulty() == 2){
            MAX_NO_OF_PASSING_ENEMIES = 4;
            for(byte a = 0; a < 4; a++){
                getRandomVehicle();
            } 
        }
        else{
            MAX_NO_OF_PASSING_ENEMIES = 6;
            for(byte a = 0; a < 6; a++){
                getRandomVehicle();
            } 
        }
    }
    private EnemyVehicle getRandomVehicle(){
        Random rand = new Random();
        int randomNum = rand.nextInt(1,3); // vehicle
        EnemyVehicle vehicle;
        if(randomNum == 1){
            if (getDifficulty() == 1){
                vehicle = new Tank(0, 6, STARTING_DISTANCE);
                enemies.add(vehicle);
            }
            else if(getDifficulty() == 2){
                vehicle = new Tank(0, 11, STARTING_DISTANCE);
                enemies.add(vehicle);
            }
            else{
                vehicle = new Tank(0, 16, STARTING_DISTANCE);
                enemies.add(vehicle);
            }
        }
        else{
            if (getDifficulty() == 1){
                vehicle = new Helicopter(0, 5, STARTING_DISTANCE);
                enemies.add(vehicle);
            }
            else if(getDifficulty() == 2){
                vehicle = new Helicopter(0, 10, STARTING_DISTANCE);
                enemies.add(vehicle);
            }
            else{
                vehicle = new Helicopter(0, 15, STARTING_DISTANCE);       
                enemies.add(vehicle); 
            }
        }
        return vehicle;
    }
    public void setDifficulty(int diff){
        this.difficulty = diff;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public ArrayList<EnemyVehicle> getEnemies(){
        return enemies;
    }
    public void printGameState(){
        System.out.println("the players point : " + p1.getPoint());
        System.out.println("number of passing enemies: " + this.passingNoOfEnemies);
    }
    public void play(){
        Scanner sc = new Scanner(System.in);
        while(passingNoOfEnemies != MAX_NO_OF_PASSING_ENEMIES){
            System.out.println("enter x and y coordinate to bomb separetaly : ");
            p1.attack(sc.nextInt(), sc.nextInt(), enemies);
            for(int a = 0; a < enemies.size(); a++){
                if(enemies.get(a).isDestroyed()){
                    enemies.set(a, getRandomVehicle());
                    p1.increment();
                }
                if(enemies.get(a).CoordinateY <= 0){
                    enemies.get(a).CoordinateY = STARTING_DISTANCE;
                    passingNoOfEnemies++;
                }
            }
            this.printGameState();
        }
        sc.close();   
    }
}
