package com.company;

public class Board {
    private final int [][] board = {
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


    int[][] getBoard(){ return board; }

    boolean possible(int[][] board, int x, int y, int value){
        for(int i = 0; i < 9; i++){
            if(board[y][i] == value || board[i][x] == value){
                return false;
            }
        }

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
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[y].length; x++)  {
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

    void printBoard(){
        for (int[] element : board) {
            for (int i : element) {
                System.out.print("  " + i);
            }
            System.out.println();
        }
        System.out.println();
    }
}
