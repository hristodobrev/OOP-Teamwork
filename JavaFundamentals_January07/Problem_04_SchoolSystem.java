package com.company.JavaFundamentals_January07;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Parapanov on 08/11/2015.
 *
 */
public class Problem_04_SchoolSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        TreeMap<String, TreeMap<String, ArrayList<Integer>>> studentData = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] splitedLine = sc.nextLine().split(" ");

            String name = String.format("%s %s", splitedLine[0], splitedLine[1]);
            String subject = splitedLine[2];
            int score = Integer.parseInt(splitedLine[3]);


            if(!(studentData.containsKey(name))){
                studentData.put(name, new TreeMap<>());
            }

            if(!(studentData.get(name).containsKey(subject))){
                studentData.get(name).put(subject, new ArrayList<>());
            }

            studentData.get(name).get(subject).add(score);
        }
//  <First name> <Last name>: [<subject> - <average score>, <subject> - <average score>, …]
        for(String name : studentData.keySet()){

            System.out.print(name + ": [");

            String subjectsToPrint = "";

            for (String subject : studentData.get(name).keySet()){

                String avr = getAverageFromList(studentData.get(name).get(subject));
                subjectsToPrint += subject + " - " + avr + ", ";
            }
            System.out.println(subjectsToPrint.substring(0, subjectsToPrint.length() - 2) + "]");

        }



    }

    static String getAverageFromList(ArrayList<Integer> list){
        double total = 0;

        for(Integer integer : list){
            total += integer;
        }

        return String.format("%.2f", total / (double)list.size());
    }
}
