package org.example;

public class Square implements InterfaceSquare {
    String fillColor;
    String borderColor;
    int perimeter;
    int area;
    public int calculateArea(int a) {
        return area = a*a;
    }

    public int calculatePerimeter(int a) {
        return perimeter = a*4;
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
