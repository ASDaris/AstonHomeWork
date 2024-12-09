package org.example;

import static org.example.Animal.GetNumberOfAnimals;
import static org.example.Cat.getNumberOfCats;
import static org.example.Dog.getNumberOfDogs;


public class Main {
    public static void main(String[] args) {
        /////Задание 1////
        Cat catMurz = new Cat("Murz");
        Cat catFik = new Cat("Fik");
        catMurz.run(200);
        catFik.swim(2);

        Dog dogNurz = new Dog("Nurz");
        dogNurz.run(420);
        dogNurz.swim(7);
        dogNurz.swim(11);

        getNumberOfDogs();
        getNumberOfCats();
        GetNumberOfAnimals();

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Sigi");
        cats[1] = new Cat("Kivi");
        cats[2] = new Cat("Digi");
        cats[3] = new Cat("Vivi");
        Bowl catFood = new Bowl(200);

        cats[0].eat(32);
        cats[1].eat(132);
        cats[2].eat(32);
        cats[3].eat(100);

        cats[0].checkHunger();
        cats[1].checkHunger();
        cats[2].checkHunger();
        cats[3].checkHunger();

        catFood.addFood(500);

        ///Задание 2///
        Square square = new Square();
        square.calculateArea(2);
        square.calculatePerimeter(2);
        square.borderColor("black");
        square.fillColor("white");
        square.showInfo();

        Triangle triangle = new Triangle();
        triangle.calculateArea(2, 4, 6);
        triangle.calculatePerimeter(2, 4, 6);
        triangle.borderColor("black");
        triangle.fillColor("white");
        triangle.showInfo();

        Circle circle = new Circle();
        circle.calculateArea(2);
        circle.calculatePerimeter(2);
        circle.borderColor("black");
        circle.fillColor("white");
        circle.showInfo();






    }
}

