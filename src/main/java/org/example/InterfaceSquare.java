package org.example;

public interface InterfaceSquare {
    default int calculatePerimeter(int a){
        return a*4;
    }
    default int calculateArea(int a){
        return a*a;
    }
    void fillColor(String fillColor);
    void borderColor(String borderColor);
    void showInfo();
}
