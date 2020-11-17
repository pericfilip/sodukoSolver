package com.company;

public class Main {


    public static void main(String[] args) {
        Board board = new Board();

        System.out.println(board.possible(board.getBoard(), 4, 4, 2));
        System.out.println(board.possible(board.getBoard(), 4, 4, 1));
        System.out.println(board.possible(board.getBoard(), 5, 6, 3));
        System.out.println(board.possible(board.getBoard(), 0, 0, 5));
        board.solve(board.getBoard());
    }
}
