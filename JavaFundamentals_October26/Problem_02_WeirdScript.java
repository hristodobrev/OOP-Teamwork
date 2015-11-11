package com.company.JavaFundamentals_October26;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Parapanov on 30/10/2015.
 *
 */
public class Problem_02_WeirdScript {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        char[] chars = new char[2];
        Arrays.fill(chars, checkLetter(n));
        String key = new String(chars);
      //  System.out.println(key);

        StringBuilder text = new StringBuilder();
        String line =  sc.nextLine();

        while (!(line.equals("End"))){
            text.append(line);
            line = sc.nextLine();
        }

       int start = text.indexOf(key);
       int end = text.indexOf(key, start + 2);
       // System.out.println(start + "  " + end);

        while ((start != -1) || (end != -1 )){
            //System.out.println(text);
            //System.out.println(start + "  " + end);
            System.out.println(text.substring(start + 2, end));
            //System.out.println();

            start = text.indexOf(key , end + 2);
            end = text.indexOf(key, start + 2);
            if(start == -1)break;
            if(end == -1)break;
        }
    }

    static char checkLetter(int n){

        int lowStart = 1;
        int lowBuffer = 26;
        int upStart = 27;
        int upBuffer = 52;

        boolean upper = false;

        while (true){

            if(lowStart <= n && n <= lowBuffer){
                while (n > 26){
                    n -= 26;
                }
                break;
            }
            if(upStart <= n && n <= upBuffer){
                while ( n > 52){
                    n -= 26;
                }
                upper = true;
                break;
            }

            lowStart += 52;
            lowBuffer += 52;
            upStart += 52;
            upBuffer +=52;
        }

        if (upper){
            return (char)(n + 38);
        }
        return (char)(n + 96);
    }



}
