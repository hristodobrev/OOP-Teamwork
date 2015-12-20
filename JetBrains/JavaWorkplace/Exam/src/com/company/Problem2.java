package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+L)");
                                         //([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+L)
        Scanner sc = new Scanner(System.in);

        double totalLiters = 0;

        String line = sc.nextLine();
        while (!line.equals("OK KoftiShans")){

            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                String name = (matcher.group(1));
                String alcohol = (matcher.group(2)).toLowerCase();
                String litt = matcher.group(3);
                int litters = Integer.parseInt(litt.substring(0, litt.length() - 1));
                //{Guest} brought {quantity} liters of {drink}!

                System.out.printf("%s brought %d liters of %s!\n", name, litters, alcohol);
                totalLiters += litters;
            }

            line = sc.nextLine();
        }

        System.out.printf("%.3f %s", totalLiters / (double)1000, "softuni liters");

    }
}
