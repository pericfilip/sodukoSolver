package com.company;

public class Main {


    public static void main(String[] args) {
        Board board = new Board();

        board.randomStart();
        System.out.println("  ---- unsolved sudoku ----");
        board.visaBrada();

        System.out.println("  ----- solved sudoku -----");
        board.solve(board.getBoard());

        board.visaBrada();

    }


}
