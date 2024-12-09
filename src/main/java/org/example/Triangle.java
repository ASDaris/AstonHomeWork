package org.example;

import static java.lang.Math.sqrt;

public class Triangle {
    String fillColor;
    String borderColor;
    int perimeter;
    double area;
    double p;
    public int calculatePerimeter(int a, int b, int c) {
        return perimeter = a + b + c;
    }

    public int calculateArea(int a, int b, int c) {
        p = (double) (a + b + c) / 2;
        area = sqrt(p * (p - a) * (p - b) * (p - c));
        return (int) area;
    }

    public void fillColor(String color) {
        fillColor = color;
    }

    public void borderColor(String color) {
        borderColor = color;
    }

    public void showInfo() {
        System.out.println("Perimeter = "+ perimeter + "; "+ "Area = " + area + "; "+ "Border color = " + borderColor + "; " + "Fill color =" + fillColor);
    }
}
