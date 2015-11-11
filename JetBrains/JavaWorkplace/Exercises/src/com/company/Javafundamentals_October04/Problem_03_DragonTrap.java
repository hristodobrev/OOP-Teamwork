package com.company.Javafundamentals_October04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Parapanov on 02/11/2015.
 *
 */
public class Problem_03_DragonTrap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String line;

        ArrayList<String> input = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            input.add(sc.nextLine());
        }

        int cols = input.get(0).length();
        char[][] city = new char[n][cols];
        char[][] primMatrix = new char[n][cols];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < cols; col++) {
                city[row][col] = input.get(row).charAt(col);
            }
        }

        while (!((line = sc.nextLine()).equals("End"))) {
            String[] splitedLine = line.split("[\\s\\(\\)]+");

            int dragonRow = Integer.parseInt(splitedLine[1]);
            int dragonCol = Integer.parseInt(splitedLine[2]);
            int radius = Integer.parseInt(splitedLine[3]);
            int rotations = Integer.parseInt(splitedLine[4]);



            for (int i = 0; i < n; i++) {
                for (int j = 0; j < cols; j++) {
                    primMatrix[i][j] = city[i][j];
                }
            }
            city = (rotateMatrix(city, dragonRow, dragonCol, radius, rotations));
            printResults(primMatrix, city);
        }
    }


    private static void printResults(char[][] city, char[][] result) {

        int count = 0;

        for (int row = 0; row < city.length; row++) {
            for (int col = 0; col < city[0].length; col++) {

                if(city[row][col] != result[row][col]){
                    count++;
                }
                System.out.print(result[row][col]);
            }
            System.out.println();
        }
        System.out.println("Symbols changed: " + count);


    }

    private static char[][] rotateMatrix(char[][] city, int drRow, int drCol, int radius, int rotations){

        int rowUp = drRow - radius;
        int rowDown = drRow + radius;
        int colLeft = drCol - radius;
        int colRight = drCol + radius;

        for (int i = 0; i < rotations; i++) {


            char last = ' ';
            char oldChar = ' ';
            char newChar;

            int fr = 0;
            int fc = 0;

// go left
            for (int col = colLeft; col <= colRight; col++) {
                if (isInsideTheMatrix(city, rowUp, col)) {
                    //System.out.println("LEFT");
                    newChar = city[rowUp][col];
                    if (last == ' ') {
                        last = newChar;
                        fr = rowUp;
                        fc = col;
                    }
                    city[rowUp][col] = oldChar;
                    oldChar = newChar;
                }
            }
            //go down
            for (int row = rowUp + 1; row <= rowDown; row++) {
                if (isInsideTheMatrix(city, row, colRight)) {
                    // System.out.println("DOWN");
                    newChar = city[row][colRight];
                    if (last == ' ') {
                        last = newChar;
                        fr = row;
                        fc = colRight;
                    }
                    city[row][colRight] = oldChar;
                    oldChar = newChar;
                }
            }
// go right
            for (int col = colRight - 1; col > colLeft; col--) {
                if (isInsideTheMatrix(city, rowDown, col)) {
                    // System.out.println("RIGHT");
                    newChar = city[rowDown][col];
                    if (last == ' ') {
                        last = newChar;
                        fr = rowDown;
                        fc = col;
                    }
                    city[rowDown][col] = oldChar;
                    oldChar = newChar;
                }
            }
//go up
            for (int row = rowDown; row > rowUp; row--) {
                if (isInsideTheMatrix(city, row, colLeft)) {
                    newChar = city[row][colLeft];
                    if (last == ' ') {
                        last = newChar;
                        fr = row;
                        fc = colLeft;
                    }
                    city[row][colLeft] = oldChar;
                    oldChar = newChar;
                }
            }

            // System.out.println(oldChar + " Old");

            if (last != ' ') {
                city[fr][fc] = oldChar;
            }
            // System.out.println(oldChar);
        }
        return city;
    }

    private static boolean isInsideTheMatrix(char[][] matrix, int x, int y){

        return x >= 0 && x < matrix[0].length && y >= 0 && y < matrix[0].length;
    }
}
