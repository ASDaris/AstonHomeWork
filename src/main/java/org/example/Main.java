package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int a = 5;
        int b = 6;
        int len = a;
        int initialValue = b;
        String s = "String";
        System.out.println("///////////////////////  Задание 1 ///////////////////////");
        printTreeWords();
        System.out.println("///////////////////////  Задание 2 ///////////////////////");
        checkSumSign();
        System.out.println("///////////////////////  Задание 3 ///////////////////////");
        printColor();
        System.out.println("///////////////////////  Задание 4 ///////////////////////");
        compareNumbers();
        System.out.println("///////////////////////  Задание 5 ///////////////////////");
        System.out.println(Boolean.toString(checkSumInRange(a, b)));
        System.out.println("///////////////////////  Задание 6 ///////////////////////");
        checkIfPositive(a);
        System.out.println("///////////////////////  Задание 7 ///////////////////////");
        System.out.println(Boolean.toString(checkNumPosNeg(a)));
        System.out.println("///////////////////////  Задание 8 ///////////////////////");
        stringNTimes(s, a);
        System.out.println("///////////////////////  Задание 9 ///////////////////////");
        System.out.println(Boolean.toString(checkIfLeapYear(a)));
        System.out.println("///////////////////////  Задание 10 ///////////////////////");
        int[] ten = new int[] {1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        for (int i = 0; i < ten.length; i++) {
            if (ten[i] == 0) {
                ten[i] = 1;
            }
            else{
                ten[i] = 0;
            }
        }
        System.out.println(Arrays.toString(ten));

        System.out.println("///////////////////////  Задание 11 ///////////////////////");
        int increment = 1;
        int[] eleven = new int[100];
        for (int i = 0; i < eleven.length; i++) {
            eleven[i] = increment++;
        }
        System.out.println(Arrays.toString(eleven));

        System.out.println("///////////////////////  Задание 12 ///////////////////////");
        int[] twelve = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < twelve.length; i++) {
            if (twelve[i] < 6) {
                twelve[i] = twelve[i] * 2;
            }
        }
        System.out.println(Arrays.toString(twelve));

        System.out.println("///////////////////////  Задание 13 ///////////////////////");
        int[][] thirteen = new int[10][10];
        for (int i = 0; i < thirteen.length; i++) {
            for (int j = 0; j < thirteen[i].length; j++) {
                if (i == j) {
                    thirteen[i][j] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(thirteen));;

        System.out.println("///////////////////////  Задание 14 ///////////////////////");
        System.out.println(Arrays.toString(createOneDimensArray(len, initialValue)));

    }

    static int[] createOneDimensArray(int len, int initialValue) {
        int[] createdArray = new int[len];
        Arrays.fill(createdArray, initialValue);
        return createdArray;
    }

    static boolean checkIfLeapYear(int a) {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

    static void stringNTimes(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    static boolean checkNumPosNeg(int a) {
        if (a >= 0) {
            return false;
        }
        else return true;
    }

    static void checkIfPositive(int a) {
        if (a >= 0) {
            System.out.println("Число положительно");
        }
        else System.out.println("Число отрицательно");
    }

    static boolean checkSumInRange(int a, int b){
        if (a + b >= 10 && b + a <= 20){
            return true;
        }
        else{
            return false;
        }
    }

    static void compareNumbers() {
        int a = 32;
        int b = 12;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else System.out.println("a < b");
    }

    static void printColor() {
        int value = 54;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <=100) {
            System.out.println("Жёлтый");
        }
        else {
            System.out.println("Зелёный");
        }
    }

    static void checkSumSign() {
        int a = 10;
        int b = 20;
        if (a + b >= 0) {
            System.out.println("Сумма положительна");
        } else {
            System.out.println("Сумма отрицательна");
        }
    }

    static void printTreeWords() {
        System.out.println("Orange \nBanana \nApple");
    }

}