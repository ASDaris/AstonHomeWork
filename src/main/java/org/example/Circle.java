package org.example;

public class Circle implements InterfaceCircle{
    String fillColor;
    String borderColor;
    double perimeter;
    double area;

    public int calculatePerimeter(int radius) {
        perimeter = (3.14 * radius * 2);
        return (int) perimeter;
    }

    public int calculateArea(int radius) {
        area = 3.14 * radius * radius;
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
