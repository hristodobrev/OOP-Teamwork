package com.company.JavaBasics_February08;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Parapanov on 09/11/2015.
 *
 */
public class Problem_03_LegoBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<ArrayList<String>> blockOne = new ArrayList<>();
        ArrayList<ArrayList<String>> blockTwo = new ArrayList<>();


        for (int i = 0; i < n; i++) {
           // String line = sc.nextLine().trim().replaceAll("[\\s\t]+", " ");
            //System.out.println(line);
           blockOne.add(new ArrayList<>(Arrays.asList(sc.nextLine().trim().split("[\\s\t]+"))));
        }
        for (int i = 0; i < n; i++) {
            blockTwo.add(new ArrayList<>(Arrays.asList(sc.nextLine().trim().split("[\\s\t]+"))));
        }

        if (checkCompatibility(blockOne, blockTwo)){
            combineBlocks(blockOne, blockTwo);
        }

        else {
            System.out.println("The total number of cells is: " + countTheBlocks(blockOne, blockTwo));
        }

    }

    static boolean checkCompatibility(ArrayList<ArrayList<String>> one,
                                      ArrayList<ArrayList<String>> two){
        int defaultLength = one.get(0).size() + two.get(0).size();

        for (int i = 1; i < one.size(); i++) {
            int currentSize = one.get(i).size() + two.get(i).size();
            if(currentSize != defaultLength){
                return false;
            }
        }
        return true;
    }

    static int countTheBlocks(ArrayList<ArrayList<String>> one, ArrayList<ArrayList<String>> two){

        int total = 0;
        for (ArrayList<String> s : one){
            total += s.size();
        }
        for (ArrayList<String> s : two){
            total += s.size();
        }
        return total;
    }

    static void combineBlocks(ArrayList<ArrayList<String>> one, ArrayList<ArrayList<String>> two){

        for (int i = 0; i < one.size(); i++) {
            ArrayList<String> reversed = (two.get(i));
            Collections.reverse(reversed);

            one.get(i).addAll(one.get(i).size(), reversed);
        }

        for(ArrayList<String> list : one) {

            System.out.println(list);

        }

    }
}
