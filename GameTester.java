package labs.lab3;

import java.util.Scanner;

public class GameTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter difficulty(1:easy, 2:medium, 3:hard): ");
        int difficulty = sc.nextInt();
        Game game = new Game(difficulty);
        GamePlotter gPlotter = new GamePlotter(game);
        gPlotter.plot();
        game.play();
        gPlotter.plot();
        sc.close();
    }
}
