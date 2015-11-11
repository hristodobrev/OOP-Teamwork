package com.company.JavaBasic_Sept21;

import java.util.Scanner;

/**
 * Created by Parapanov on 10/11/2015.
 *
 */
public class Problem_01_MirrorNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =  Integer.parseInt(sc.nextLine());
        boolean noocurence = true;


        StringBuilder[] numbers = new StringBuilder[n];
        String[] line = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = new StringBuilder(line[i]);
        }


        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i != j){
                    //System.out.println(String.join(", ", numbers));
                    String current = numbers[i].toString();

                    StringBuilder sb = new StringBuilder(numbers[j]);

                    String reversed = sb.reverse().toString();

                    if(current.equals(reversed)){
                        System.out.printf("%s<!>%s\n", current, numbers[j]);
                        noocurence = false;
                    }
                }
            }
        }
            if(noocurence){
                System.out.println("No");
            }
    }
}
