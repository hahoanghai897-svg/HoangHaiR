/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab06_inheritance_full; // Bạn có thể đổi tên package này hoặc xóa đi nếu không dùng

import java.util.ArrayList;
import java.util.Scanner;

public class Lab06_Inheritance_Full {
    
    // Khai báo Scanner static để dùng chung cho toàn bộ chương trình
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 06 (KẾ THỪA - INHERITANCE) =========");
            System.out.println("1.  Bài 1: Person - Student (Kế thừa cơ bản)");
            System.out.println("2.  Bài 2: Person - Employee (Constructor & super)");
            System.out.println("3.  Bài 3: Animal - Dog (Override phương thức)");
            System.out.println("4.  Bài 4: Shape - Rectangle (Tính diện tích)");
            System.out.println("5.  Bài 5: Vehicle - Car - ElectricCar (Đa cấp)");
            System.out.println("6.  Bài 6: Employee - FullTime/PartTime (Tính lương)");
            System.out.println("7.  Bài 7: Abstract Shape - Circle/Rectangle");
            System.out.println("8.  Bài 8: Person - Teacher (Gọi super.method)");
            System.out.println("9.  Bài 9: Animal - Dog/Cat (Đa hình)");
            System.out.println("10. Bài 10: Abstract Employee - Office/Sales");
            System.out.println("0.  Thoát");
            System.out.print("Chọn bài (0-10): ");

            int choice = 0;
            try {
                // Sử dụng parseInt để tránh lỗi trôi lệnh khi nhập số
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên!");
                continue;
            }

            switch (choice) {
                case 1: Bai1.run(); break;
                case 2: Bai2.run(); break;
                case 3: Bai3.run(); break;
                case 4: Bai4.run(); break;
                case 5: Bai5.run(); break;
                case 6: Bai6.run(); break;
                case 7: Bai7.run(); break;
                case 8: Bai8.run(); break;
                case 9: Bai9.run(); break;
                case 10: Bai10.run(); break;
                case 0: 
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                default: System.out.println("Chọn sai, vui lòng nhập lại!");
            }
            
            System.out.println("\nẤn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    // ========================================================
    // BÀI 1: Person - Student
    // ========================================================
    static class Bai1 {
        static class Person {
            String name;
            int age;
            void displayInfo() {
                System.out.println("Person: " + name + ", " + age + " tuổi");
            }
        }
        static class Student extends Person {
            String studentId;
            @Override
            void displayInfo() {
                System.out.println("Student: " + name + " (" + studentId + "), " + age + " tuổi");
            }
        }
        static void run() {
            System.out.println("--- BÀI 1 ---");
            Student s = new Student();
            s.name = "Nguyen Van A";
            s.age = 20;
            s.studentId = "SV001";
            s.displayInfo();
        }
    }

    // ========================================================
    // BÀI 2: Constructor & super
    // ========================================================
    static class Bai2 {
        static class Person {
            String name;
            int age;
            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }
        static class Employee extends Person {
            double salary;
            public Employee(String name, int age, double salary) {
                super(name, age); // Gọi constructor lớp cha
                this.salary = salary;
            }
            void display() {
                System.out.println("Employee: " + name + ", " + age + " tuổi, Lương: " + salary);
            }
        }
        static void run() {
            System.out.println("--- BÀI 2 ---");
            Employee e = new Employee("Tran Thi B", 25, 10000000);
            e.display();
        }
    }

    // ========================================================
    // BÀI 3: Animal - Dog (Override)
    // ========================================================
    static class Bai3 {
        static class Animal {
            protected String name;
            void sound() { System.out.println("Động vật phát ra âm thanh..."); }
        }
        static class Dog extends Animal {
            public Dog(String name) { this.name = name; }
            @Override
            void sound() {
                System.out.println(name + " sủa: Gâu gâu!");
            }
        }
        static void run() {
            System.out.println("--- BÀI 3 ---");
            Dog d = new Dog("Milu");
            d.sound();
        }
    }

    // ========================================================
    // BÀI 4: Shape - Rectangle (Ghi đè tính toán)
    // ========================================================
    static class Bai4 {
        static class Shape {
            double getArea() { return 0; }
        }
        static class Rectangle extends Shape {
            double width, height;
            public Rectangle(double w, double h) { this.width = w; this.height = h; }
            @Override
            double getArea() { return width * height; }
        }
        static void run() {
            System.out.println("--- BÀI 4 ---");
            Rectangle r = new Rectangle(5, 10);
            System.out.println("Diện tích HCN (5x10): " + r.getArea());
        }
    }

    // ========================================================
    // BÀI 5: Kế thừa đa cấp (Vehicle -> Car -> ElectricCar)
    // ========================================================
    static class Bai5 {
        static class Vehicle {
            String brand;
            void start() { System.out.println("Xe đang khởi động..."); }
        }
        static class Car extends Vehicle {
            int seatCount;
        }
        static class ElectricCar extends Car {
            double batteryCapacity;
            void showInfo() {
                System.out.println("Xe điện " + brand + " - " + seatCount + " chỗ - Pin: " + batteryCapacity + "kWh");
            }
        }
        static void run() {
            System.out.println("--- BÀI 5 ---");
            ElectricCar ec = new ElectricCar();
            ec.brand = "Tesla Model S";
            ec.seatCount = 5;
            ec.batteryCapacity = 100;
            ec.start(); // Kế thừa từ Vehicle
            ec.showInfo();
        }
    }

    // ========================================================
    // BÀI 6: Tính lương (Polymorphism with Array)
    // ========================================================
    static class Bai6 {
        static class Employee {
            double getSalary() { return 0; }
        }
        static class FullTimeEmployee extends Employee {
            @Override double getSalary() { return 20000000; } // Lương cứng
        }
        static class PartTimeEmployee extends Employee {
            int hours;
            public PartTimeEmployee(int h) { hours = h; }
            @Override double getSalary() { return hours * 50000; } // 50k/giờ
        }
        static void run() {
            System.out.println("--- BÀI 6 ---");
            Employee[] list = new Employee[2];
            list[0] = new FullTimeEmployee();
            list[1] = new PartTimeEmployee(40); // 40 giờ

            for (Employee e : list) {
                System.out.println("Lương: " + e.getSalary());
            }
        }
    }

    // ========================================================
    // BÀI 7: Abstract Class Shape
    // ========================================================
    static class Bai7 {
        static abstract class Shape {
            public abstract double getArea();
        }
        static class Circle extends Shape {
            double radius;
            public Circle(double r) { radius = r; }
            @Override public double getArea() { return Math.PI * radius * radius; }
        }
        static class Rectangle extends Shape {
            double width, height;
            public Rectangle(double w, double h) { width = w; height = h; }
            @Override public double getArea() { return width * height; }
        }
        static void run() {
            System.out.println("--- BÀI 7 ---");
            ArrayList<Shape> shapes = new ArrayList<>();
            shapes.add(new Circle(5));
            shapes.add(new Rectangle(4, 6));

            for (Shape s : shapes) {
                System.out.printf("Diện tích: %.2f\n", s.getArea());
            }
        }
    }

    // ========================================================
    // BÀI 8: Gọi super.method()
    // ========================================================
    static class Bai8 {
        static class Person {
            String name;
            public Person(String n) { name = n; }
            public void introduce() { System.out.println("Xin chào, tôi tên là " + name); }
        }
        static class Teacher extends Person {
            String subject;
            public Teacher(String n, String s) {
                super(n);
                subject = s;
            }
            @Override
            public void introduce() {
                super.introduce(); // Gọi phương thức cha
                System.out.println("Tôi dạy môn " + subject);
            }
        }
        static void run() {
            System.out.println("--- BÀI 8 ---");
            Teacher t = new Teacher("Co Mai", "Tieng Anh");
            t.introduce();
        }
    }

    // ========================================================
    // BÀI 9: Đa hình với biến tham chiếu
    // ========================================================
    static class Bai9 {
        static class Animal {
            public void makeSound() { System.out.println("Động vật phát ra âm thanh"); }
        }
        static class Dog extends Animal {
            @Override public void makeSound() { System.out.println("Chó sủa: Gâu gâu"); }
        }
        static class Cat extends Animal {
            @Override public void makeSound() { System.out.println("Mèo kêu: Meo meo"); }
        }
        static void run() {
            System.out.println("--- BÀI 9 ---");
            Animal animal; // Khai báo 1 biến duy nhất theo yêu cầu

            animal = new Dog();
            animal.makeSound();

            animal = new Cat();
            animal.makeSound();
        }
    }

    // ========================================================
    // BÀI 10: Abstract Employee (Office & Sales)
    // ========================================================
    static class Bai10 {
        static abstract class Employee {
            String id, name;
            public Employee(String id, String name) { this.id = id; this.name = name; }
            public abstract double calculateSalary();
        }
        static class OfficeEmployee extends Employee {
            double fixedSalary;
            public OfficeEmployee(String id, String name, double salary) {
                super(id, name); fixedSalary = salary;
            }
            @Override public double calculateSalary() { return fixedSalary; }
        }
        static class SalesEmployee extends Employee {
            double baseSalary, commission;
            public SalesEmployee(String id, String name, double base, double comm) {
                super(id, name); baseSalary = base; commission = comm;
            }
            @Override public double calculateSalary() { return baseSalary + commission; }
        }
        static void run() {
            System.out.println("--- BÀI 10 ---");
            ArrayList<Employee> staff = new ArrayList<>();
            staff.add(new OfficeEmployee("NV01", "An", 10000000));
            staff.add(new SalesEmployee("NV02", "Binh", 5000000, 7000000)); // Lương cơ bản + hoa hồng

            double totalSalary = 0;
            for (Employee e : staff) {
                double sal = e.calculateSalary();
                System.out.println("NV " + e.name + ": " + sal);
                totalSalary += sal;
            }
            System.out.println("Tổng lương công ty: " + totalSalary);
        }
    }
}