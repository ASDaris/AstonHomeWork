package org.example;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan Ivanovich", "Engineer", "default@gmail.com", "89001112233", 50000, 30);
        employees[1] = new Employee("Evanov Evan Evanovich", "Janitor", "href@gmail.com", "88002221133", 100000, 20);
        employees[2] = new Employee("Avanov Avan Avanovich", "HR-Manager", "asdfgh@gmail.com", "89990002211", 25000, 40);
        employees[3] = new Employee("Ovanov Ovan Ovanovich", "PR-Manager", "ovanOvanich@gmail.com", "81110001100", 35000, 25);
        employees[4] = new Employee("Uvanov Uvan Uvanovich", "Janitor Assistant", "ieaoUvan@gmail.com", "80001110011", 75000, 35);

        for (int i = 0; i < employees.length; i++) {
            Employee.ShowInfo(employees[i]);
        }
    }
}

class Employee {
    String lastFirstMiddleName;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    Employee(String lastFirstMiddleName, String position, String email, String phone, int salary, int age) {
        this.lastFirstMiddleName = lastFirstMiddleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    static void ShowInfo(Employee emp) {
        System.out.println();
        System.out.println("Last First Middle Name: " + emp.lastFirstMiddleName );
        System.out.println("Dplznost: " + emp.position);
        System.out.println("Email: " + emp.email );
        System.out.println("Phone: " + emp.phone );
        System.out.println("Salary: " + emp.salary );
        System.out.println("Age: " + emp.age );
    }
}

class Park{

    class Attraction{
        String name;
        String workHours;
        int price;
    }
}
