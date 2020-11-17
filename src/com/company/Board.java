package com.company;

import java.util.Random;

public class Board {
    private int [][] board = new int[9][9];
            /*{
            {0, 0, 0, 8, 0, 4, 9, 3, 7},
            {0, 7, 4, 1, 0, 0, 0, 8, 0},
            {8, 3, 2, 0, 0, 0, 4, 0, 0},
            {2, 0, 5, 3, 0, 0, 7, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 6},
            {1, 4, 3, 0, 0, 0, 2, 0, 0},
            {0, 0, 7, 0, 9, 0, 6, 0, 0},
            {0, 2, 1, 7, 5, 6, 8, 9, 0},
            {6, 5, 9, 2, 3, 0, 0, 7, 4}
    };

             */

    public Board(){

    }
    boolean possible(int[][] board, int x, int y, int value){
        //kontrollera rad och kolumn
        for(int i = 0; i < 9; i++){
            if(board[y][i] == value || board[i][x] == value){
                return false;
            }
        }
        //kontrollera rutan
        int x0 = (int)Math.floor(x/3) * 3;
        int y0 = (int)Math.floor(y/3) * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (board[y0+i][x0+j] == value){
                    return false;
                }
            }
        }
        return true;
    }
    boolean solve(int[][] board) {
        //Loopa igenom alla rader och kolumner
        //  Kolla om det är en nolla på aktuell pos
        //      Loopa igenom alla värden från 1 till 9
        //          Kolla om man kan placera aktuellt värd på aktuell position
        //              Om ja, placera aktuellt värde
        //                  anropa solve
        //                      Ta bort aktuellt värde
        //      Gör return
        // Skriv ut lösning

        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board.length; x++)  {
                if (board[y][x] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (possible(board, x, y, i)) {
                            board[y][x] = i;
                            if(solve(board)){
                                return true;
                            }
                            board[y][x] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    int[][] getBoard(){
        return board;
    }

    void visaBrada(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print("  " +  board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    int[] RandomizeArray(int[] array){
        Random regenerate = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = regenerate.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    void randomStart() {
        //int[] start = new int[9];
        int[] start = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        start = RandomizeArray(start);

        for (int e : start) {
            System.out.println(e);
        }

        int i = 0;
        for (int x = 1; x <= 9; x += 3) {
            for (int y = 1; y <= 9; y += 3){
                board[y][x] = start[i];
                i++;
            }
        }
    }


}
