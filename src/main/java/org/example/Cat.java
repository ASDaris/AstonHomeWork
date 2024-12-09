package org.example;

import static org.example.Bowl.numberOfFood;

public class Cat extends Animal{
    boolean hunger = false;
    private static int numberOfCats = 0;
    Cat(String name) {
        super(name);
        numberOfCats++;
    }
    @Override
    public void run(int length){
        if(length <= 200)
            System.out.println(name + " runs " + length + " meters");
        else System.out.println("Cat can not run " + length + " meters");
    }
    @Override
    public void swim(int length){
        System.out.println("Cat can not swim");
    }

    public static void getNumberOfCats(){
        System.out.println(numberOfCats + " Cats");
    }

    public void eat(int toEat){
        if (toEat < numberOfFood){
            numberOfFood -= toEat;
            hunger = true;
        }
        else hunger = false;
    }

    public void checkHunger(){
        if (!hunger){
            System.out.println(name + " is hungry");
        }
        else {System.out.println(name + " is not hungry");}
    }


}
