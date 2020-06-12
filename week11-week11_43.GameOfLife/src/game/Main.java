package game;

import gameoflife.Simulator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
         PersonalBoard board = new PersonalBoard(7, 5);

        board.turnToLiving(2, 0);
        board.turnToLiving(4, 0);

        board.turnToLiving(3, 3);
        board.turnToLiving(3, 3);

        board.turnToLiving(0, 2);
        board.turnToLiving(1, 3);
        board.turnToLiving(2, 3);
        board.turnToLiving(3, 3);
        board.turnToLiving(4, 3);
        board.turnToLiving(5, 3);
        board.turnToLiving(6, 2);
        System.out.println(board.isAlive(0, 2));
                

        GameOfLifeTester tester = new GameOfLifeTester(board);
        tester.play();
    }
}
