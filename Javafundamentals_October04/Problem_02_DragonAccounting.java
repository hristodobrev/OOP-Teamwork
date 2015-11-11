package com.company.Javafundamentals_October04;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Parapanov on 01/11/2015.
 *
 */
public class Problem_02_DragonAccounting {

    static BigDecimal capital;
    static ArrayList<Integer> employList = new ArrayList<>();
    static ArrayList<BigDecimal> salaries = new ArrayList<>();
    static int daysToSalary = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        capital = sc.nextBigDecimal();
        sc.nextLine();

        String line = sc.nextLine();

        boolean bankrupt = false;

        while (!(line.equals("END"))){
            String[] arrayLine = line.split(";");

            int hired = Integer.parseInt(arrayLine[0]);
            int fired = Integer.parseInt(arrayLine[1]);
            BigDecimal salary = new BigDecimal(arrayLine[2]);


            //Hire employees
            for (int e = 0; e < hired; e++) {
                salaries.add(salary);
                employList.add(0);
            }
            //Rise Salaries
            raiseSalaries();

            //Set another day for the employees
            incrementEmployDays( );

            //PayDay
            if(daysToSalary % 30 == 0){
                paySalaries();
                //System.out.println(capital);
            }

            //Fire employees
            for (int f = 0; f < fired; f++) {
                salaries.remove(0);
                employList.remove(0);
            }

            //Check for Incoming/Expense
            for (int i = 3; i < arrayLine.length; i++) {

                incomeOrExpense(arrayLine[i]);
            }

            //Check for Bankrupt
            if(capital.doubleValue() < 1){
                bankrupt = true;
                break;
            }

            //    System.out.println(capital);
            daysToSalary++;
            line = sc.nextLine();
        }

        if(!bankrupt){

            System.out.print(employList.size() + " ");
            System.out.printf("%.4f", capital.setScale(4, BigDecimal.ROUND_DOWN));
        }else {
            System.out.println("BANKRUPTCY: " + Math.abs(capital.setScale(4, BigDecimal.ROUND_DOWN).doubleValue()));
        }
    }

    private static void incomeOrExpense(String str){


        String[] subTokens = str.split(":");

        String objectName = subTokens[0];
        BigDecimal objectValue = new BigDecimal(subTokens[1]);

        switch (objectName) {
            case "Previous years deficit":
            case "Machines":
            case "Taxes":
                capital = capital.subtract(objectValue);
                break;
            default:
                capital = capital.add(objectValue);
                break;
        }
    }

    private static void incrementEmployDays(){

        int  ind = 0;
        for(Integer emp : employList){

            employList.set(ind, emp + 1);
            ind++;
        }

    }

    private static void paySalaries (){

        int ind = 0;

        for(Integer days : employList){

            int workedDays = days;
            if(workedDays > 30){
                workedDays = 30;
            }

            BigDecimal daySalary = (salaries.get(ind)
                    .divide(new BigDecimal(30), 9, BigDecimal.ROUND_UP))
                    .setScale(7, BigDecimal.ROUND_DOWN)
                    .multiply(new BigDecimal(workedDays));

            ind++;

            capital = capital.subtract(daySalary);
        }

    }

    private static void raiseSalaries() {

        if (daysToSalary >= 365) {
            int ind = 0;
            for (int employ : employList) {

                if (employ > 365) {
                    BigDecimal currentSalary = salaries.get(ind);
                    BigDecimal increasedSalary = currentSalary.multiply(new BigDecimal(1.006));
                    salaries.set(ind, increasedSalary);
                }
                ind++;
            }
        }

    }
}
