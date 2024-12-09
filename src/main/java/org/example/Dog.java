package org.example;

public class Dog extends Animal {
    private static int numberOfDogs;
    Dog(String name) {
        super(name);
        numberOfDogs++;
    }
    @Override
    public void run(int length){
        if(length <= 500)
            System.out.println(name + " runs " + length + " meters");
        else System.out.println("Dog can not run " + length + " meters");
    }
    @Override
    public void swim(int length){
        if(length <= 10)
            System.out.println(name +" swims " + length + " meters");
        else System.out.println("Dog can not swim " + length + " meters");
    }
    static void getNumberOfDogs() {
        System.out.println(numberOfDogs + " dogs");
    }
}

