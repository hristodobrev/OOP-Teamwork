package com.company.JavaFundamentals_May11;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Parapanov on 08/11/2015.
 *
 */
public class Problem_04_Weightlifting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        TreeMap<String, TreeMap<String, Long>> playerData = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] lineSplited = sc.nextLine().split(" ");

            String name = lineSplited[0];
            String exercise = lineSplited[1];
            long weight = Integer.parseInt(lineSplited[2]);

            if(!(playerData.containsKey(name))){
                playerData.put(name, new TreeMap<>());
            }

            if(!(playerData.get(name).containsKey(exercise))){
                playerData.get(name).put(exercise, (long)0);
            }

            long currentWeight = playerData.get(name).get(exercise);
            playerData.get(name).put(exercise, currentWeight + weight);
        }

        for(String name : playerData.keySet()){

            //<player> : <exercise> - <weight> kg, <exercise> - <weight> kg,…
            System.out.print(name + " : ");

            String tempLine = "";

            for( Map.Entry exer : playerData.get(name).entrySet()){

                tempLine += exer.getKey() + " - " + exer.getValue() + " kg, ";
            }

            System.out.println(tempLine.substring(0, tempLine.length() - 2));
        }

    }
}
