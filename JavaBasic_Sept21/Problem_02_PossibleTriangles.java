package com.company.JavaBasic_Sept21;

import java.util.Scanner;

/**
 * Created by Parapanov on 10/11/2015.
 *
 */
public class Problem_02_PossibleTriangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        boolean nothing = true;

        while (!line.equals("End")){

            String[] splitedLine = line.split(" ");
            double a = 0.0;
            double b = 0.0;
            double c = 0.0;

            for (int i = 0; i < splitedLine.length; i++) {
                for (int j = 0; j < splitedLine.length; j++) {
                    for (int k = 0; k < splitedLine.length; k++) {

                        a = Double.parseDouble(splitedLine[i]);
                        b = Double.parseDouble(splitedLine[j]);
                        c = Double.parseDouble(splitedLine[k]);

                        if(a < b && b < c && (a + b > c)){
                            System.out.printf("%.2f+%.2f>%.2f\n", a, b, c);
                            nothing = false;
                        }
                    }
                }
            }

            line = sc.nextLine();
        }

        if(nothing){
            System.out.printf("No");
        }
    }
}
