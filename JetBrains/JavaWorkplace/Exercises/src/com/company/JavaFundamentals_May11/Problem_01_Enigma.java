package com.company.JavaFundamentals_May11;

import java.util.Scanner;

/**
 * Created by Parapanov on 04/11/2015.
 *
 */
public class Problem_01_Enigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            char[] splitedLine = line.toCharArray();

            char[] withoutWhiteSpaces = line.replaceAll("\\s*\\d*", "").toCharArray();

            int middle = withoutWhiteSpaces.length / 2;

            for (char aSplitedLine : splitedLine) {
                if (!(Character.isDigit(aSplitedLine)) && aSplitedLine != ' ') {
                    int charNum = aSplitedLine + middle;
                    System.out.print((char) charNum);
                } else {
                    System.out.print(aSplitedLine);
                }
            }
            System.out.println();

        }
    }
}
