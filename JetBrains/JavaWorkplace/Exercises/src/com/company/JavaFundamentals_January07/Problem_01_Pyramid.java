package com.company.JavaFundamentals_January07;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Parapanov on 06/11/2015.
 *
 */
public class Problem_01_Pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int smallest = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().trim().split("\\s+")));

            List<Integer> listInputInts = line
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Integer toAdd = returnSmallestFromList(listInputInts, smallest);

            if(toAdd != null){
                result.add(toAdd);
                smallest = toAdd;
            }
            else {
                smallest++;
            }

        }

        System.out.print(result.get(0));
        for (int i = 1; i < result.size(); i++) {
            System.out.print(", " + result.get(i));
        }

    }

    private static Integer returnSmallestFromList(List<Integer> list, int i){

        Collections.sort(list);

        for (int j = 0; j < list.size(); j++) {
            if(list.get(j) > i){
                return list.get(j);
            }
        }

        return null;
    }


}
