package com.company.JavaFundamentals_October26;

import java.util.*;

/**
 * Created by Parapanov on 31/10/2015.
 */



//•	Shadowmourne – requires 250 Shards;
//•	Valanyr – requires 250 Fragments;
//•	Dragonwrath – requires 250 Motes;
//Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as
//2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race.
// At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes,
// ordered by quantity in descending order, each on a new line. Finally, print the collected junk items,
// in alphabetical order.

public class Problem_04_LegendaryFarming {

    static LinkedHashMap<String, Integer> materials = new LinkedHashMap<String, Integer>(){{
                put("fragments", 0);
                put("motes", 0);
                put("shards", 0);

    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> junk = new TreeMap<>();

        String[] line;
        String obtMaterial = "";

        while (true) {
            line = sc.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < line.length - 1; i += 2) {
                String key = line[i + 1];
                int value = Integer.parseInt(line[i]);

                if (materials.containsKey(key)) {
                    materials.put(key, materials.get(key) + value);
                } else {
                    if (!(junk.containsKey(key))) {
                        junk.put(key, 0);
                    }
                    junk.put(key, junk.get(key) + value);
                }

                obtMaterial = checkTheMaterials();
                if (!(obtMaterial.equals(""))) {
                    break;
                }
            }
            if (!(obtMaterial.equals(""))) {
                break;
            }
        }

        if(obtMaterial.equals("shards")){
            obtMaterial = "Shadowmourne";
        }else if(obtMaterial.equals("fragments")){
            obtMaterial = "Valanyr";
        }else {
            obtMaterial = "Dragonwrath";
        }

        System.out.printf("%s obtained!\n", obtMaterial);

        materials.entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
                .forEach(key -> System.out.println(key.getKey() + ": " + key.getValue()));

        junk.entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    }

    private static String checkTheMaterials(){
        String obtained = "";

        for(String key : materials.keySet()){

            if(materials.get(key) >= 250){
                materials.put(key, materials.get(key) - 250);
                obtained = key;
            }
        }

        return obtained;
    }



    static class ValueComparator implements Comparator {

        Map map;

        public ValueComparator() {

        }
        public int compare(Object keyA, Object keyB) {

            return ((String) keyA).compareTo((String) keyB);
        }
    }
}
