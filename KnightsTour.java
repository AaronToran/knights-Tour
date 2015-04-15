/*
Aaron Toran
KnightsTour
CIS 260
David Klick
program that finds a solution to the knight's tour problem of having a knight visit every square of a chess board only once.
*/
import java.lang.System;

public class KnightsTour {
    //creating the board and making -1 the default value
    public static void main(String[] args){
        int[][] chessBoard = new int[8][8];
        for(int r = 0; r < 8; r++) {
            for(int c= 0; c< 8; c++) {
                chessBoard[r][c] = -1;
            }
        }
        move(chessBoard, 3, 4 ,0 );//where the knight starts
    }
    //move method can only be accessed inside of class, algorithm to find the knights path.
    private static void move(int[][] chessBoard,int row,int col,int level){
        if (row > 7|| row < 0 || col > 7|| col< 0){//makeing sure the knight stays on the board
            return;
        }else if(chessBoard[row][col] != -1){
            return;
        }else{
           chessBoard[row][col] = level;
        }
        if(level ==  63){ //Prints chess board with the knights moves also exits the program with success
            for(int r = 0; r < 8; r++) {
                for(int c= 0; c< 8; c++) {
                    System.out.printf("%2d ", chessBoard[r][c]);
                }
                System.out.println();
            }
            System.exit(0);
        }else{
        //moves the knight peice
        move(chessBoard, row-2, col-1, level+1 );
        move(chessBoard, row-2 , col +1, level+1 );
        move(chessBoard, row-1 , col -2,level+1 );
        move(chessBoard, row+1, col -2,level+1 );
        move(chessBoard, row-1, col +2,level+1 );
        move(chessBoard, row+1 , col +2,level+1 );
        move(chessBoard, row+2 , col -1,level+1 );
        move(chessBoard, row+2 , col +1,level+1 );
        chessBoard[row][col]= -1;//allows the algorithm to backup in case of a mistake
            return;
        }
    
    }
}