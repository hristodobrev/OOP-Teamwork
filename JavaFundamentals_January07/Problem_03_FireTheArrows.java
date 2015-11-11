package com.company.JavaFundamentals_January07;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Parapanov on 07/11/2015.
 *
 */
public class Problem_03_FireTheArrows {

    static ArrayList<StringBuilder> inputList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            inputList.add(new StringBuilder(sc.nextLine()));
        }

        moveTheArrows();

    }

    static void moveTheArrows (){
        int rows = inputList.size();
        int cols = inputList.get(0).length();
        boolean noMoves = true;

        while (noMoves) {

            noMoves = false;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    switch (inputList.get(r).charAt(c)) {

                        case '^':
                            if (checkForElementOrWall(r - 1, c, rows, cols)) {
                                switchCharsAtList(r, c, r - 1, c);
                                noMoves = true;
                            }
                            break;

                        case 'v':
                            if (checkForElementOrWall(r + 1, c, rows, cols)) {
                                switchCharsAtList(r, c, r + 1, c);
                                noMoves = true;
                            }
                            break;

                        case '<':
                            if (checkForElementOrWall(r, c - 1, rows, cols)) {
                                switchCharsAtList(r, c, r, c - 1);
                                noMoves = true;
                            }
                            break;

                        case '>':
                            if (checkForElementOrWall(r, c + 1, rows, cols)) {
                                switchCharsAtList(r, c, r, c + 1);
                                noMoves = true;
                            }
                            break;
                    }
                }
            }
        }
        for (StringBuilder anInputList : inputList) {
            for (int c = 0; c < cols; c++) {
                System.out.print(anInputList.charAt(c));
            }
            System.out.println();
        }
    }

    static boolean checkForElementOrWall(int row, int col, int rows, int cols){

        return 0 <= row && row <= rows - 1 && 0 <= col && col <= cols - 1 &&
                inputList.get(row).charAt(col) == 'o';

    }

    static void switchCharsAtList(int rOld, int cOld, int rNew, int cNew){
        char tempOld = inputList.get(rOld).charAt(cOld);
        char tempNew = inputList.get(rNew).charAt(cNew);

        inputList.get(rOld).replace(cOld, cOld + 1, tempNew + "");
        inputList.get(rNew).replace(cNew, cNew + 1, tempOld + "");

//        String tempString = inputList.get(rOld);

    }
}
