package com.company.JavaFundamentals_May11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Parapanov on 08/11/2015.
 *
 */
public class Problem_02_MagicCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //2 -> 20, 3 -> 30, 4 -> 40, 5 -> 50,
        // 6 -> 60, 7 -> 70, 8 -> 80, 9 -> 90,
        // 10 -> 100, J -> 120, Q -> 130, K -> 140, A -> 150

        ArrayList<String> cards = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));

        String oddEven = sc.nextLine();
        String magicCard = sc.nextLine();

        int magicValue = getValueOfCard(magicCard);
        char magicSuit = magicCard.charAt(magicCard.length() - 1);

        int loopStart = 1;
        if(oddEven.equals("even")){
            loopStart = 0;
        }

        int total = 0;
        for (int i = loopStart; i < cards.size(); i += 2) {

            String card = cards.get(i);

            int cardValue = getValueOfCard(card);
            char cardSuit = card.charAt(card.length() - 1);

            if(cardValue == magicValue){
                total += (cardValue * 3);
            }
            else if (cardSuit == magicSuit){
                total += (cardValue * 2);
            }else {
                total += cardValue;
            }
        }
        System.out.println(total);

    }

    static int getValueOfCard(String card){

        int result = 0;

        if(Character.isDigit( card.charAt(0))){
            result = Integer.parseInt( card.substring(0, card.length() - 1)) * 10;
        }
        else {
            switch (card.charAt(0)){
                case 'J' : result = 120;
                    break;
                case 'Q' : result = 130;
                    break;
                case 'K' : result = 140;
                    break;
                case 'A' : result = 150;
                    break;
                default:
                    System.out.println("ERROR");
            }
        }

        return result;
    }
}
