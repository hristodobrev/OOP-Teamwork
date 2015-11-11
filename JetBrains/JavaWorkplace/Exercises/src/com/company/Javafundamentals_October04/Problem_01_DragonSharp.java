package com.company.Javafundamentals_October04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Parapanov on 01/11/2015.
 *
 */
public class Problem_01_DragonSharp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int turn = 0;

        String line ;

        StringBuilder result = new StringBuilder();
        boolean elseCase = false;

        try {

            for (; turn < n; turn++) {

                line = sc.nextLine();
                String[] arrayLine = line.split(" ");

                int start = line.indexOf("\"") + 1;

                //Check for wrong input - no "text", no ':'
                if( start == 0 || !(line.charAt(line.length() - 1) == ';')) {
                    start = Integer.parseInt(arrayLine[0]);
                }

                String text = line.substring(start, line.length() - 2);

                //check the first argument
                if (arrayLine[0].equals("if")) {
                    elseCase = false;

                    //split the argument text in the line
                    Pattern pattern = Pattern.compile("\\((\\d+?)(\\D+?)(\\d*?)\\)");
                    Matcher matcher = pattern.matcher(arrayLine[1]);

                    int a = 0;
                    int b = 0;
                    String operator = "";

                    while (matcher.find()) {

                        a = Integer.parseInt(matcher.group(1));
                        b = Integer.parseInt(matcher.group(3));
                        operator = matcher.group(2);
                    }

                    // the if - true or false
                    if (compareIntegers(a, b, operator)) {

                        //print loop or ones
                        if (arrayLine[2].equals("loop")) {
                            int loops = Integer.parseInt(arrayLine[3]);

                            for (int i = 0; i < loops; i++) {
                                //System.out.println(text);
                                result.append(text).append("\n");
                            }

                        } else {
                            result.append(text).append("\n");
                        }
                    } else {
                        elseCase = true;
                    }

                // if line start with else and the privious "if" is false
                } else if (elseCase) {

                    //print loop or ones
                    if (arrayLine[1].equals("loop")) {
                        int loops = Integer.parseInt(arrayLine[2]);

                        for (int i = 0; i < loops; i++) {
                            result.append(text).append("\n");
                        }
                    } else {
                        result.append(text).append("\n");
                    }
                }

            }
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println("Compile time error @ line " + (turn + 1));
        }
    }

    private static boolean compareIntegers(int x, int y, String operator){
        // < > == <= >=

        switch (operator){
            case "<" : return x < y;
            case ">" : return x > y;
            case "==" : return x == y;
            case "<=" : return x <= y;
            case ">=" : return x >= y;
        }

        System.out.println("What are you doing here?");
        return false;
    }




}
