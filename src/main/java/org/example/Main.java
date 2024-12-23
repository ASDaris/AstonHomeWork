package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculateFactorial(6));
    }

    public static int calculateFactorial(int number) {
        int factorial = 1;
        if (number < 0) {
            throw new ArithmeticException("Факториал отрицательного числа неопределён");
        }
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

