package com.company.JavaFundamentals_January07;

import java.util.Scanner;

/**
 * Created by Parapanov on 06/11/2015.
 *
 */
public class Problem_02_TerroristsWin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int start;
        int end;

        int ind = 0;
        char[] result = input.toCharArray();

        while (ind < input.length() - 1){
            start = input.indexOf("|", ind);
            end = input.indexOf("|", start + 1);

            if(start == -1){
                break;
            }

            int range = calculateRangeFromString(input.substring(start + 1, end));

            int left = start - range;
            int right = end + range;

            if(left < 0){
                left = 0;
            }
            if(right > input.length() - 1){
                right = input.length() - 1;
            }

            for (int i = left; i <= right; i++) {
                result[i] = '.';
            }

            ind = end + 1;
        }
        System.out.println(result);
    }

    private static int calculateRangeFromString (String bomb){
        int intRange = 0;

        for (char ch : bomb.toCharArray()){
            intRange += ch;
        }
        return intRange % 10;
    }
}
