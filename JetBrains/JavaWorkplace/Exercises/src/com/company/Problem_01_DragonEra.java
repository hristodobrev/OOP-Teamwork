package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Parapanov on 04/11/2015.
 *
 */
public class Problem_01_DragonEra {

    public static int dragonsCount = 0;
    enum YearType {
        Bad,
        Normal,
        Good
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dragonsStart = Integer.parseInt(sc.nextLine());
        List<Dragon> dragons = new ArrayList<>();

        for (int i = 1; i <= dragonsStart ; i++) {
            Dragon dragon = new Dragon("Dragon_" + i, 0);

            int eggs = Integer.parseInt(sc.nextLine());

            for (int eggCount = 0; eggCount < eggs; eggCount++) {
                Egg egg = new Egg(0, dragon);
                dragon.lay();
            }

            dragons.add(dragon);

        }
        dragonsCount = dragonsStart + 1;

        int years = Integer.parseInt(sc.nextLine());

        for (int year = 1; year <= years; year++) {
            String yearType = sc.nextLine();
            YearType yearFactor = YearType.valueOf(yearType);

            for (Dragon dragon : dragons) {
                passAge(dragon, yearFactor);
//                dragon.age();
//                dragon.lay();

//                for(Egg egg : dragon.getEggs()){
//                    egg.setYearFactor(yearFactor);
//                    egg.age();
//                    egg.hatch();
//                }
            }
        }
    }

    public static void passAge(Dragon dragon, YearType factor){
        dragon.age();
        dragon.lay();

        if(dragon.isAlive()) {

            for (Egg egg : dragon.getEggs()) {
                egg.setYearFactor(factor);

                egg.age();
                egg.hatch();
            }
        }
        for(Dragon child : dragon.getChildren()){
            passAge(child, factor);
        }
    }
}

class Dragon{
    private String name;
    private int age;
    private List<Egg> eggs;
    private List<Dragon> children;
    private boolean alive = true;
    private final int AGE_DEATH = 6;
    private final int AGE_LAY_EGGS_START = 3;
    private final int AGE_LAY_EGGS_END = 4;

    public Dragon(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void lay (){
        if(this.age >= AGE_LAY_EGGS_START && this.age <= AGE_LAY_EGGS_END) {

            Egg egg = new Egg(-1, this);
            this.eggs.add(egg);
        }
    }

    public void instanceOffspring(Dragon baby) {
        this.children.add(baby);
    }

    public void age(){
        if(this.alive){
            this.age++;
        }
        if(this.age == AGE_DEATH){
            this.alive = false;
        }
    }

    public String getName() {
        return name;
    }

    public Iterable<Egg> getEggs() {
        return this.eggs;
    }

    public List<Dragon> getChildren() {
        return children;
    }

    public boolean isAlive() {
        return alive;
    }
}

class Egg{
    private int age;
    private Dragon parent;
    private final int AGE_HATCH = 2;
    private Problem_01_DragonEra.YearType yearFactor;


    public Egg(int age, Dragon parent) {
        this.age = age;
        this.parent = parent;
    }
    public void age(){
        this.age++;
    }
    public void setYearFactor(Problem_01_DragonEra.YearType yearFactor) {
        this.yearFactor = yearFactor;
    }

    public void hatch(){
        if(this.age == AGE_HATCH){
            int yearFactor = this.yearFactor.ordinal();
            Dragon baby = new Dragon(
                    this.parent.getName() + "/" + "Dragon_" + Problem_01_DragonEra.dragonsCount, -1);
            this.parent.instanceOffspring(baby);
        }
    }


}