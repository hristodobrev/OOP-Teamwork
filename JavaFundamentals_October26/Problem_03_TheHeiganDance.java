package com.company.JavaFundamentals_October26;

import java.util.Scanner;

/**
 * Created by Parapanov on 30/10/2015.
 *
 */

public class Problem_03_TheHeiganDance {

    private static final int CLOUD = 3500;
    private static final int ERUPTION = 6000;
    private static int[]playerPosition = {7,7};
    private static int player = 18500;

    private static boolean[][]chamber = new boolean[15][15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double playerDamage = Double.parseDouble(sc.nextLine());

        double heigan = 3_000_000;
        String killSpell ;
        boolean playerDead = false;
        boolean cloudHit = false;
        boolean heiganDead = false;

        while (true){

            String[] line = sc.nextLine().split(" ");
            int row = Integer.parseInt(line[1]);
            int col = Integer.parseInt(line[2]);

            heigan -= playerDamage;
            killSpell = line[0];

            if (cloudHit){
                player -= CLOUD;
                cloudHit = false;
                killSpell = "Cloud";
            }
            if(heigan < 0){
                heiganDead = true;
                break;
            }

            if(player < 1){
                playerDead = true;
                break;
            }

           // System.out.println(String.join("|",line));

            int damage;

            if(line[0].equals("Cloud")){
                damage = CLOUD;
            }
            else {
                damage = ERUPTION;
            }

            chamber = new boolean[15][15];
            killSpell = line[0];

            if(checkPlayerPositionForHit(row, col)){
                if(movePlayerOrTakeDamage(damage) && killSpell.equals("Cloud")){
                    cloudHit = true;
                }
            }

            if(player < 1){
                playerDead = true;
                break;
            }
        }

        killSpell = killSpell.equals("Eruption") ? "Eruption" : "Plague Cloud";

        if(playerDead){
            System.out.printf("Heigan: %.2f\n" , heigan);
            System.out.printf("Player: Killed by %s\n", killSpell );
            System.out.printf("Final position: %d, %d\n",  playerPosition[0], playerPosition[1]);
        }
        if(heiganDead){
            System.out.printf("Heigan: Defeated!\n");
            System.out.printf("Player: %s\n", (player > 0) ? player : "Killed by " + killSpell);
            System.out.printf("Final position: %d, %d\n",  playerPosition[0], playerPosition[1]);
        }
    }

    private static boolean checkPlayerPositionForHit(int row, int col){
        int plRow = playerPosition[0];
        int plCol = playerPosition[1];

        int rowStart = row - 1;
        if (rowStart < 0) rowStart = 0;
        int rowEnd = row + 1;
        if (rowEnd > 14) rowEnd = 14;
        int colStart = col - 1;
        if(colStart < 0) colStart = 0;
        int colEnd = col + 1;
        if(colEnd > 14) colEnd = 14;

        boolean hitPlayer = false;

        //mark the damage on the matrix and check if the player is hited
        for (int r = rowStart; r <= rowEnd; r++) {
            for (int c = colStart; c <= colEnd; c++) {
                chamber[r][c] = true;
                if (r == plRow && c == plCol){
                   // System.out.println("Playar is Hit");
                    hitPlayer = true;
                }
            }
        }
      return hitPlayer;
    }

    private static boolean movePlayerOrTakeDamage(int damage){
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        //System.out.println(playerRow + " --- " + playerCol);

        boolean playerDamaged = false;

        if(playerRow - 1 >= 0 && !(chamber[playerRow - 1][playerCol])){
           //System.out.println("player escape up");
            playerPosition[0] = playerRow - 1;

        }else if(playerCol < 14 && !(chamber[playerRow][playerCol + 1])){
           // System.out.println("player escape right");
            playerPosition[1] = playerCol + 1;

        }else if(playerRow < 14 && !(chamber[playerRow + 1][playerCol])){
          // System.out.println("player escape down");
            playerPosition[0] = playerRow + 1;

        }else if(playerCol - 1 >= 0 && !(chamber[playerRow][playerCol - 1])){
            playerPosition[1] = playerCol - 1;
           // System.out.println("player escape left");

        }else {
             player -= damage;
            playerDamaged = true;
        }


        return playerDamaged;
    }

}

