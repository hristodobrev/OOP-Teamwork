package com.company.JavaFundamentals_May11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Parapanov on 08/11/2015.
 *
 */
public class Problem_03_LabyrinthDash {

    static ArrayList<StringBuilder> table = new ArrayList<>();
    static String walls = "_|";
    static String obstacles = "@#*";

    static int playerRow = 0;
    static int playerCol = 0;
    static int lives = 3;
    static boolean outOfCage = false;
    static int movesCounter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            table.add(new StringBuilder(sc.nextLine()));
        }

        char[] moves = sc.nextLine().toCharArray();

// “_”, “|”,
// “@”, “#”, “*”,
// “$”,
// “ “,
// “.”

        for (char move : moves) {

            switch (move) {
                case '^':

                    if (!dropOutFromTheLabyrinth(playerRow - 1, playerCol)) {
                        checkTheSymbol(playerRow - 1, playerCol);
                    }
                    break;

                case 'v':
                    if (!dropOutFromTheLabyrinth(playerRow + 1, playerCol)) {
                        checkTheSymbol(playerRow + 1, playerCol);
                    }
                    break;

                case '<':
                    if (!dropOutFromTheLabyrinth(playerRow, playerCol - 1)) {
                        checkTheSymbol(playerRow, playerCol - 1);
                    }
                    break;

                case '>':
                    if (!dropOutFromTheLabyrinth(playerRow, playerCol + 1)) {
                        checkTheSymbol(playerRow, playerCol + 1);
                    }
                    break;
            }


            if (outOfCage) {
                movesCounter++;
                System.out.println("Fell off a cliff! Game Over!");
                break;
            }

            if (lives < 1) {
                System.out.println("No lives left! Game Over!");
                break;
            }
        }

        System.out.println("Total moves made: " + movesCounter);
    }

    static boolean dropOutFromTheLabyrinth(int row, int col){

        boolean outOfRows = 0 > row || row > table.size() - 1;   // if out of row TRUE
        boolean outOfCols = false;                           // default inside the columns

        if(!outOfRows){                                      //if outOfRows == False -> inside the table

            outOfCols = 0 > col || col > table.get(row).length() - 1;    //if out of col TRUE

            if(!outOfCols){                                          //if outOfCol == false -> inside the table
                outOfCage = table.get(row).charAt(col) == ' ';
                return table.get(row).charAt(col) == ' ';            //take the char on row,col and check if its space
            }
        }

     outOfCage = outOfCols || outOfRows;
     return outOfRows || outOfCols;                            //if out of table return true
    }

    static void checkTheSymbol(int row, int col){
        String toCheck = table.get(row).charAt(col) +"";

        if(toCheck.equals(".")){
            System.out.println("Made a move!");
            playerRow = row;
            playerCol = col;
            movesCounter++;

        }else if(walls.contains(toCheck)) {
            System.out.println("Bumped a wall.");

        }else if(obstacles.contains(toCheck)){
            lives--;
            System.out.println("Ouch! That hurt! Lives left: " + lives);
            playerRow = row;
            playerCol = col;
            movesCounter++;

        }else if(toCheck.equals("$")){
            lives++;
            System.out.println("Awesome! Lives left: " + lives);
            playerRow = row;
            playerCol = col;
            movesCounter++;

            table.get(row).setCharAt(col, '.');
        }
    }
}
