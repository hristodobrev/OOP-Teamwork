package com.company.JavaFundamentals_October26;

import java.util.Scanner;

public class Problem_01_TinySporebat {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int health = 5800;
        int glowcaps = 0;

        while (!(line.equals("Sporeggar")) || health < 1){

            for (int i = 0; i < line.length() - 1; i++) {
                if(!(line.charAt(i) == 'L')) {
                    health -= line.charAt(i);
                }
                else {
                    health += 200;
                }
            }
            if (health < 1) {
                break;
            }
            String lastDigitAsString = String.format("%s",line.charAt(line.length() - 1));
            glowcaps += Integer.parseInt(lastDigitAsString);

            line = sc.nextLine();
        }

        if(health > 0 && glowcaps < 30){

            System.out.printf("Health left: %d\nSafe in Sporeggar, but another %d Glowcaps needed.",
                    health, 30 - glowcaps);

        }else if(health > 0 && glowcaps >= 30){

            System.out.printf("Health left: %d\nBought the sporebat. Glowcaps left: %d",
                    health, glowcaps - 30);
        }
        else {
            System.out.printf("Died. Glowcaps: %d", glowcaps);
        }




    }
}
