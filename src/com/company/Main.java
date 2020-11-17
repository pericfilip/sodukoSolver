package com.company;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        //board.randomStart();
        System.out.println("  ---- unsolved sudoku ----");
        board.printBoard();

        System.out.println("  ----- solved sudoku -----");
        board.solve(board.getBoard());

        board.printBoard();
    }
}
