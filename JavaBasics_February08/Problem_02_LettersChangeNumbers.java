package com.company.JavaBasics_February08;

import java.util.Scanner;

/**
 * Created by Parapanov on 09/11/2015.
 *
 */
public class Problem_02_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            // A-'/', a - '*';  A - '-', a - '+'

        String[] splitedLine = sc.nextLine().trim().split("\\s+");
        double total = 0;

        for(String element : splitedLine){
            total += calculateString(element);
        }
        System.out.printf("%.2f\n", total);

    }

    static double calculateString(String str){
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        double number = Integer.parseInt(str.substring(1, str.length() - 1));

        if(Character.isUpperCase(first)){
            double firstValue = first - 64;
            number /= firstValue;
        }else {
            double firstValue = first - 96;
            number *= firstValue;
        }

        if(Character.isUpperCase(last)){
            double firstValue = last - 64;
            number -= firstValue;
        }else {
            double firstValue = last - 96;
            number += firstValue;
        }
        return number;
    }

}
