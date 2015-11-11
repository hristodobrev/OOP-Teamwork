package com.company.JavaBasic_Sept21;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Parapanov on 11/11/2015.
 *
 */
public class Problem_03_ValidUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] lineSplited = sc.nextLine().split("[\\s()/\\\\]+");

        Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w]{2,25}\\b");

        ArrayList<String> listStrings = new ArrayList<>();

        for (String str : lineSplited) {

            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                listStrings.add(matcher.group());
            }
        }

//        for (String s : listStrings){
//            System.out.println(s);
//        }

        int longest = 0;
        int ind = -1;

        for (int i = 0; i < listStrings.size() - 1; i++) {
            int currentLength = listStrings.get(i).length() +
                    listStrings.get(i + 1).length();

            if(currentLength > longest){
                longest = currentLength;
                ind = i;
            }
        }

        System.out.printf("%s\n%s",listStrings.get(ind), listStrings.get(ind + 1));

    }
}
