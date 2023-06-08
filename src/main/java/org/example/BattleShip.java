package org.example;

import java.util.Scanner;

public class BattleShip {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to BattleShip!");
        System.out.println("Please enter the size of your board: ");
        int size = input.nextInt();
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
        printBoard(board);
        System.out.println("Enter the row and column of your ship: ");
        int shipRow = input.nextInt();
        int shipCol = input.nextInt();
        char[][] newBoard = placeShip(board,shipRow,shipCol);
        printBoard(newBoard);
        boolean alive = true;
        int turns = 0;
        while (alive){
            System.out.println("Enter the row and column to attack: ");
            int attackRow = input.nextInt();
            int attackCol = input.nextInt();
            turns++;
            if (newBoard[attackRow][attackCol]=='-'){
                System.out.println("You missed!");
                newBoard[attackRow][attackCol] = 'O';
            } else if (newBoard[attackRow][attackCol] == 'S') {
                System.out.println("You hit a ship!");
                newBoard[attackRow][attackCol] = 'X';
                if (!isShipAlive(newBoard)){
                    System.out.println("You sunk the ship in " + turns + "turns!");
                    alive = false;
                }
            }else {
                System.out.println("You already attacked that location!");
            }
            printBoard(newBoard);
        }
        input.close();
    }

    public static boolean isShipAlive(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'S') {
                    return true;
                }
            }
        }
        return false;
    }

    public static char[][] placeShip(char[][] board, int shipRow, int shipCol) {
        board[shipRow][shipCol] = 'S';
        return  board;
    }

    public static void printBoard(char[][] board) {
        System.out.println(" 0123456789");
        for (int i = 0; i < board.length; i++){
            System.out.println(i + "|");
            for (int j = 0; j < board[i].length; j++){
                System.out.println(board[i][j]);
            }
            System.out.println("|" + i);
        }
        System.out.println(" 0123456789");
    }
}