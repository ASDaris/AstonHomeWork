package org.example;

public interface InterfaceTriangle {
    default int calculatePerimeter(int a, int b, int c) {
        return a + b + c;
    }
    int calculateArea(int a, int b, int c);
    void fillColor(String fillColor);
    void borderColor(String borderColor);
    void showInfo();
}
