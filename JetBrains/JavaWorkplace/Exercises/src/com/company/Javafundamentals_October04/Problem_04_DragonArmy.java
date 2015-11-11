package com.company.Javafundamentals_October04;

import java.util.LinkedHashMap;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Parapanov on 03/11/2015.
 *
 */
public class Problem_04_DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, TreeMap<String, Dragon>> dragonsData = new LinkedHashMap<>();


        //Red Bazgargal 100 2500 25

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String type = input[0];
            String name = input[1];

            if(input[2].equals("null")){
                input[2] = "45";
            }
            int damage = Integer.parseInt(input[2]);

            if(input[3].equals("null")) {
                input[3] = "250";
            }
            int health = Integer.parseInt(input[3]);

            if(input[4].equals("null")) {
                input[4] = "10";
            }
            int armor = Integer.parseInt((input[4]));

            if(!(dragonsData.containsKey(type))){
                dragonsData.put(type, new TreeMap<>());
            }

            dragonsData.get(type).put(name, new Dragon(damage, health, armor));

        }

        for(String keyType : dragonsData.keySet()){
           // System.out.println(keyType);

            int totalDamage = 0;
            int totalHealth = 0;
            int totalArmor = 0;

            for (String dragonName : dragonsData.get(keyType).keySet()){

               // System.out.println("  " + dragonName);
               // System.out.println( dragonsData.get(keyType).get(dragonName).getName());

                totalDamage += dragonsData.get(keyType).get(dragonName).getDamage();
                totalHealth += dragonsData.get(keyType).get(dragonName).getHealth();
                totalArmor += dragonsData.get(keyType).get(dragonName).getArmor();
            }

            double avrDamage = (double)totalDamage / dragonsData.get(keyType).size();
            double avrHealth = (double)totalHealth / dragonsData.get(keyType).size();
            double avrArmor = (double)totalArmor / dragonsData.get(keyType).size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", keyType, avrDamage, avrHealth, avrArmor);

            for (String dragonName : dragonsData.get(keyType).keySet()){

                totalDamage += dragonsData.get(keyType).get(dragonName).getDamage();
                totalHealth += dragonsData.get(keyType).get(dragonName).getHealth();
                totalArmor += dragonsData.get(keyType).get(dragonName).getArmor();

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n"
                        ,dragonName
                        ,dragonsData.get(keyType).get(dragonName).getDamage()
                        ,dragonsData.get(keyType).get(dragonName).getHealth()
                        ,dragonsData.get(keyType).get(dragonName).getArmor());
            }
        }
    }
}

class Dragon{
   private int damage;
   private int health;
   private int armor;

    public Dragon(int damage, int health, int armor) {
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }


    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

}
