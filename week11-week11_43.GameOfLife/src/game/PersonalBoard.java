/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author mdala
 */
public class PersonalBoard extends GameOfLifeBoard {
    
    public PersonalBoard(int width, int height){
        super(width,height);
    }

    @Override
    public void initiateRandomCells(double d) {
        Random r = new Random(); 
        int boardArea = super.getHeight() * super.getWidth();
       if(d < 0 || d > 1){
           throw new IllegalArgumentException("Probability has to be between 0 and 1");
         }
       int cellsToBeFilled = (int) (boardArea * d); 
       
       for(int i = 0; i < cellsToBeFilled; i++){
           while(true){
          int randomRow = r.nextInt(super.getHeight());
          int randomColumn = r.nextInt(super.getWidth());
          if(!isAlive(randomColumn,randomRow)){
              turnToLiving(randomColumn,randomRow);
              break;
          }
          }
       }
    }

    @Override
    public boolean isAlive(int x, int y) {
        boolean[][] board = super.getBoard();
        boolean a = false;  
        try{
        if(board[x][y] == true){
            a = true;
       }
        }catch(Exception ArrayIndexOutOfBoundsException){
            return a; 
        }
       return a;  
    }

    @Override
    public void turnToLiving(int x, int y) {
       int width = super.getWidth()-1;
       int height = super.getHeight()-1; 
       if(x>=0 && x<=width && y>=0 && y<=height){
        boolean[][] board = super.getBoard();
        board[x][y] = true; 
       }
    }

    @Override
    public void turnToDead(int x, int y) {
         int width = super.getWidth()-1;
       int height = super.getHeight()-1; 
       if(x>=0 && x<=width && y>=0 && y<=height){
        boolean[][] board = super.getBoard();
        board[x][y] = false; 
       }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
       int alive = 0; 
        if(x == 0  && y == 0){
            if(isAlive(x+1,y)){
                alive++;
            }
            if(isAlive(x,y+1)){
                alive++;
            }
            if(isAlive(x+1,y+1)){
                alive++;
            }
        }else if(x == super.getWidth()-1 && y == 0){
            if(isAlive(x-1,y)){
                alive++;
            }
            if(isAlive(x,y+1)){
                alive++;
            }
            if(isAlive(x-1,y+1)){
                alive++;
            }
        }else if(x == 0 && y == super.getHeight()-1){
            if(isAlive(x,y-1)){
                alive++;
            }
            if(isAlive(x+1,y-1)){
                alive++;
            }
            if(isAlive(x+1,y)){
                alive++;
            }
        }else if(x == super.getWidth()-1 && y == super.getHeight()-1){
            if(isAlive(x,y-1)){
                alive++;
            }
            if(isAlive(x-1,y)){
                alive++;
            }
            if(isAlive(x-1,y-1)){
                alive++;
            }
        }else if(x == 0 && y > 0 || y<super.getHeight()-1){
            if(isAlive(x,y-1)){
                alive++;
            }
            if(isAlive(x,y+1)){
                alive++;
            }
            if(isAlive(x+1,y-1)){
                alive++;
            }
            if(isAlive(x+1,y)){
                alive++;
            }
            if(isAlive(x+1,y+1)){
                alive++;
            }
        }else if(x == super.getWidth()-1 && y>0 || y<super.getHeight()-1){
            if(isAlive(x,y-1)){
                alive++;
            }
            if(isAlive(x,y+1)){
                alive++;
            }
            if(isAlive(x-1,y-1)){
                alive++;
            }
            if(isAlive(x-1,y)){
                alive++;
            }
            if(isAlive(x-1,y+1)){
                alive++;
            }
        }else if(x>0 || x<super.getWidth()-1 && y == 0){
            if(isAlive(x-1,y)){
                alive++;
            }
            if(isAlive(x+1,y)){
                alive++;
            }
            if(isAlive(x-1,y+1)){
                alive++;
            }
            if(isAlive(x+1,y+1)){
                alive++;
            }
            if(isAlive(x,y+1)){
                alive++;
            }
        }else if(x>0 || x<super.getWidth()-1 && y == super.getHeight()-1){
            if(isAlive(x+1,y)){
                alive++;
            }
            if(isAlive(x-1,y)){
                alive++;
            }
            if(isAlive(x,y-1)){
                alive++;
            }
            if(isAlive(x+1,y-1)){
                alive++;
            }
            if(isAlive(x-1,y-1)){
                alive++;
            }
        }else{
            if(isAlive(x,y-1)){
                alive++;
            }
            if(isAlive(x-1,y-1)){
                alive++;
            }
            if(isAlive(x+1,y-1)){
                alive++;
            }
            if(isAlive(x+1,y)){
                alive++;
            }
            if(isAlive(x-1,y)){
                alive++;
            }
            if(isAlive(x,y+1)){
                alive++;
            }
            if(isAlive(x+1,y+1)){
                alive++;
            }
            if(isAlive(x-1,y+1)){
                alive++;
            }
        }    
        return alive; 
        
    }

    @Override
    public void manageCell(int i, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
