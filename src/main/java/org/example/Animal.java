package org.example;

public class Animal {
    private static int numberOfAnimals = 0;
    String name;
    Animal(String name) {
        this.name = name;
        this.numberOfAnimals++;
    }
    public void run(int length){
        System.out.println(name + " runs " + length + " meters");
    }
    public void swim(int length){
        System.out.println(name + " swims " + length + " meters");
    }
    public static void GetNumberOfAnimals(){
        System.out.println(numberOfAnimals + " animals");
    }
}
