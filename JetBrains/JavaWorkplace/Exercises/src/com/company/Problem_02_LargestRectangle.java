package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Parapanov on 04/11/2015.
 *
 */
public class Problem_02_LargestRectangle {

       static ArrayList<Integer> longest = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> inputList = new ArrayList<>();
        String input;

//put all input to list
        while (!(input = sc.nextLine().replaceAll(","," ").trim()).equals("END") ){
            inputList.add(input);
        }
//get rows and cols
        int rows = inputList.size();
        int cols = inputList.get(0).split(" ").length;

//make matrix with the rows and cols params
        String[][] mat = new String[rows][cols];

//loop the matrix and the list and write the Strings
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                mat[row][col] = inputList.get(row).split(" ")[col];
            }
        }

//take all posibel rectangles sides and check for suggests
        for (int row = 0; row < mat.length - 1; row++) {
            for (int col = 0; col < mat[0].length - 1; col++) {
                for (int rowEnd = row + 1; rowEnd < mat.length; rowEnd++) {
                    for (int colEnd = col + 1; colEnd < mat[0].length; colEnd++) {

                        checkForRec(mat, row, col, rowEnd, colEnd);
                    }
                }
            }
        }
// put [] around the string from the list with coordinates
        for (int i = 0; i < longest.size(); i += 2) {
            int row = longest.get(i);
            int col = longest.get(i + 1);

            String toChange =  mat[row][col];
            mat[row][col] = String.format("[%s]", toChange);
        }


        for (String[] aMat : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%5s", aMat[j]);
            }
            System.out.println();
        }

    }

    static void checkForRec(String[][] table, int up, int left, int down, int right){

        String current = table[up][left];

        ArrayList<Integer> coordinates = new ArrayList<>();

        boolean rect = true;

        for (int rUp = up; rUp <= down; rUp++) {
            if(current.equals(table[rUp][left]) && current.equals(table[rUp][right])){

//                System.out.println(current + "| " + table[rUp][left] + " " + table[rUp][right]);
//                System.out.println(rUp+"," + left + "  " + rUp+ "," + right);
                coordinates.add(rUp);
                coordinates.add(left);
                coordinates.add(rUp);
                coordinates.add(right);
            }
            else {
                rect = false;
            }
        }

        for (int cLeft = left + 1; cLeft < right; cLeft++){
            if(current.equals(table[up][cLeft]) && current.equals(table[down][cLeft])){
//                System.out.println(current  +"- " +table[up][cLeft] + " " + table[down][cLeft] );
//                System.out.println(up+","+cLeft + "  "+ down+ "," + cLeft);

                coordinates.add(up);
                coordinates.add(cLeft);
                coordinates.add(down);
                coordinates.add(cLeft);
            }
            else {
                rect = false;
            }
        }
       // System.out.println(rect);

        if(rect && longest.size() < coordinates.size()){
            longest.clear();
            longest = coordinates;
        }

    }
}
