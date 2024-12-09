package org.example;

public class Bowl {
    static int numberOfFood = 0;
    Bowl(int numberOfFood){
        Bowl.numberOfFood = numberOfFood;
    }
    public void addFood(int amount){
        numberOfFood += amount;
    }
}
