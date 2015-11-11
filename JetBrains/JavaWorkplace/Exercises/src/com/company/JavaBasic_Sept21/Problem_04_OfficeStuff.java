package com.company.JavaBasic_Sept21;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Parapanov on 11/11/2015.
 *
 */
public class Problem_04_OfficeStuff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        TreeMap<String, LinkedHashMap<String, Integer>> officeList = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().replaceAll("\\|", "");

            String[] splitedLine = line.trim().split("[\\s+\\-]+");

            String company = splitedLine[0];
            String product = splitedLine[2];
            int amount = Integer.parseInt(splitedLine[1]);

            if(!(officeList.containsKey(company))){
                officeList.put(company, new LinkedHashMap<>());
            }

            if(!(officeList.get(company).containsKey(product))){
                officeList.get(company).put(product, 0);
            }
            int currentAmount = officeList.get(company).get(product);

            officeList.get(company).put(product, currentAmount + amount);
        }

        for(String key : officeList.keySet()){
            System.out.print(key + ": ");
            String products = "";
            for (String product : officeList.get(key).keySet()){
                products += String.format("%s-%d, ", product, officeList.get(key).get(product));
            }
            System.out.println(products.substring(0, products.length() - 2));
        }

    }
}
