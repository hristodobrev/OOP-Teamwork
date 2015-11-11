package com.company.JavaBasics_February08;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Parapanov on 08/11/2015.
 *
 */
public class Problem_01_GandalfsStash {

    static int gandalfMode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        gandalfMode = Integer.parseInt(sc.nextLine());

        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher(sc.nextLine().toLowerCase());

        while (matcher.find()){
            calculateFoodPoints(matcher.group());
        }

        System.out.println(gandalfMode);

        if(gandalfMode < -5){
            System.out.println("Angry");
        }
        if(gandalfMode > -6 && gandalfMode < 0){
            System.out.println("Sad");
        }
        if(gandalfMode > -1 && gandalfMode < 15){
            System.out.println("Happy");
        }
        if(gandalfMode > 14){
            System.out.println("Special JavaScript mood");
        }
    }

    static void calculateFoodPoints(String food){

        switch (food){
            case "cram" : gandalfMode += 2;
                break;
            case "lembas" : gandalfMode += 3;
                break;
            case "apple" : gandalfMode += 1;
                break;
            case "melon" : gandalfMode += 1;
                break;
            case "honeycake" : gandalfMode += 5;
                break;
            case "mushrooms" : gandalfMode -= 10;
                break;
            default: gandalfMode -= 1;
                break;
        }
    }
}

//        Gandalf moods are:
//        •	Angry - below -5 points of happiness;
//        •	Sad - from -5 to 0 points of happiness;
//        •	Happy - from 0 to 15 points of happiness;
//        •	Special JavaScript mood - when happiness points are more than 15;
