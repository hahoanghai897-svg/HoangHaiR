/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab08_interface_full;

import java.util.Scanner;

public class Lab08_Interface_Full {
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 08 (INTERFACE) =========");
            System.out.println("1.  Bài 1: Drawable - Circle");
            System.out.println("2.  Bài 2: Shape - Rectangle (Constants & Abstract Methods)");
            System.out.println("3.  Bài 3: Vehicle - Car (Default Method)");
            System.out.println("4.  Bài 4: Shape - Static Method");
            System.out.println("5.  Bài 5: Duck (Multiple Inheritance - Flyable, Swimmable)");
            System.out.println("6.  Bài 6: Mammal extends Animal (Interface Inheritance)");
            System.out.println("7.  Bài 7: Calculator (Functional Interface & Lambda)");
            System.out.println("8.  Bài 8: Payable (Polymorphism)");
            System.out.println("9.  Bài 9: Human, Robot, Android (Interface Segregation)");
            System.out.println("10. Bài 10: Traffic System (Complex Implementation)");
            System.out.println("0.  Thoát");
            System.out.print("Chọn bài (0-10): ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
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
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default: System.out.println("Chọn sai!");
            }
            System.out.println("\nẤn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    // ================= BÀI 1: DRAWABLE =================
    static class Bai1 {
        interface Drawable {
            void draw(); // Mặc định là public abstract
        }
        static class Circle implements Drawable {
            @Override
            public void draw() {
                System.out.println("Drawing a circle");
            }
        }
        static void run() {
            System.out.println("--- BÀI 1 ---");
            Drawable d = new Circle();
            d.draw();
        }
    }

    // ================= BÀI 2 & 4: SHAPE (Kèm Static Method Bài 4) =================
    static class Bai2 { // Dùng chung cho Bài 2 và Bài 4
        interface Shape {
            double PI = 3.14159; // Mặc định là public static final
            double calculateArea();
            double calculatePerimeter();
            
            // Bài 4: Static method trong Interface
            static String getInfo() {
                return "This is a shape interface";
            }
        }
        static class Rectangle implements Shape {
            private double width, height;
            public Rectangle(double w, double h) { width = w; height = h; }
            @Override public double calculateArea() { return width * height; }
            @Override public double calculatePerimeter() { return 2 * (width + height); }
        }
        static void run() {
            System.out.println("--- BÀI 2 ---");
            Rectangle rect = new Rectangle(5, 10);
            System.out.println("Diện tích HCN (5x10): " + rect.calculateArea());
            System.out.println("Chu vi HCN (5x10): " + rect.calculatePerimeter());
            System.out.println("PI: " + Shape.PI);
        }
    }
    
    // ================= BÀI 3: VEHICLE (DEFAULT METHOD) =================
    static class Bai3 {
        interface Vehicle {
            void start();
            // Default method: Có thân hàm, không bắt buộc override
            default void honk() {
                System.out.println("Beep beep!");
            }
        }
        static class Car implements Vehicle {
            @Override
            public void start() {
                System.out.println("Car started.");
            }
        }
        static void run() {
            System.out.println("--- BÀI 3 ---");
            Car c = new Car();
            c.start();
            c.honk(); // Gọi default method
        }
    }

    // ================= BÀI 4: GỌI STATIC METHOD CỦA BÀI 2 =================
    static class Bai4 {
        static void run() {
            System.out.println("--- BÀI 4 ---");
            // Gọi static method trực tiếp từ Interface
            System.out.println(Bai2.Shape.getInfo());
        }
    }

    // ================= BÀI 5: ĐA KẾ THỪA INTERFACE =================
    static class Bai5 {
        interface Flyable { void fly(); }
        interface Swimmable { void swim(); }
        
        // Một class có thể implement nhiều interface
        static class Duck implements Flyable, Swimmable {
            @Override public void fly() { System.out.println("Duck is flying"); }
            @Override public void swim() { System.out.println("Duck is swimming"); }
        }
        static void run() {
            System.out.println("--- BÀI 5 ---");
            Duck d = new Duck();
            d.fly();
            d.swim();
        }
    }

    // ================= BÀI 6: KẾ THỪA GIỮA CÁC INTERFACE =================
    static class Bai6 {
        interface Animal { void eat(); }
        // Interface kế thừa Interface khác dùng từ khóa 'extends'
        interface Mammal extends Animal { void run(); }
        
        static class Dog implements Mammal {
            @Override public void eat() { System.out.println("Dog eats bones."); }
            @Override public void run() { System.out.println("Dog runs fast."); }
        }
        static void run() {
            System.out.println("--- BÀI 6 ---");
            Dog d = new Dog();
            d.eat();
            d.run();
        }
    }

    // ================= BÀI 7: FUNCTIONAL INTERFACE & LAMBDA =================
    static class Bai7 {
        @FunctionalInterface
        interface Calculator {
            int operate(int a, int b);
        }
        static void run() {
            System.out.println("--- BÀI 7 ---");
            // Sử dụng Lambda Expression
            Calculator add = (a, b) -> a + b;
            Calculator multiply = (a, b) -> a * b;
            Calculator subtract = (a, b) -> a - b;

            System.out.println("10 + 5 = " + add.operate(10, 5));
            System.out.println("10 * 5 = " + multiply.operate(10, 5));
            System.out.println("10 - 5 = " + subtract.operate(10, 5));
        }
    }

    // ================= BÀI 8: POLYMORPHISM (PAYABLE) =================
    static class Bai8 {
        interface Payable {
            double calculateSalary();
        }
        static class FullTimeEmployee implements Payable {
            @Override public double calculateSalary() { return 2000; }
        }
        static class PartTimeEmployee implements Payable {
            @Override public double calculateSalary() { return 500; }
        }
        static class Contractor implements Payable {
            @Override public double calculateSalary() { return 1000; }
        }
        // Phương thức nhận tham số đa hình
        static void paySalary(Payable p) {
            System.out.println("Thanh toán lương: " + p.calculateSalary() + "$");
        }
        static void run() {
            System.out.println("--- BÀI 8 ---");
            paySalary(new FullTimeEmployee());
            paySalary(new PartTimeEmployee());
            paySalary(new Contractor());
        }
    }

    // ================= BÀI 9: TÁCH BIỆT INTERFACE =================
    static class Bai9 {
        interface Workable { void work(); }
        interface Eatable { void eat(); }
        interface Sleepable { void sleep(); }

        static class Human implements Workable, Eatable, Sleepable {
            @Override public void work() { System.out.println("Human working..."); }
            @Override public void eat() { System.out.println("Human eating..."); }
            @Override public void sleep() { System.out.println("Human sleeping..."); }
        }
        static class Robot implements Workable {
            @Override public void work() { System.out.println("Robot working 24/7..."); }
        }
        static class Android implements Workable, Eatable, Sleepable {
            @Override public void work() { System.out.println("Android working..."); }
            @Override public void eat() { System.out.println("Android charging (eating)..."); }
            @Override public void sleep() { System.out.println("Android power saving mode (sleeping)..."); }
        }
        static void run() {
            System.out.println("--- BÀI 9 ---");
            Human h = new Human(); h.work();
            Robot r = new Robot(); r.work(); 
            // r.eat(); // Lỗi: Robot không có phương thức eat
        }
    }

    // ================= BÀI 10: HỆ THỐNG GIAO THÔNG =================
    static class Bai10 {
        interface Movable {
            void move();
            default void stop() { System.out.println("Stopping..."); }
        }
        interface FuelConsumable {
            double getFuelConsumption();
        }
        interface ElectricChargeable {
            void charge();
        }

        static class Car implements Movable, FuelConsumable {
            @Override public void move() { System.out.println("Car is moving on road."); }
            @Override public double getFuelConsumption() { return 8.5; } // lít/100km
        }
        static class Bicycle implements Movable {
            @Override public void move() { System.out.println("Bicycle is pedaling."); }
            @Override public void stop() { System.out.println("Bicycle braking: Using hand brakes."); } // Override default
        }
        static class ElectricCar implements Movable, FuelConsumable, ElectricChargeable {
            @Override public void move() { System.out.println("Electric Car is gliding silently."); }
            @Override public double getFuelConsumption() { return 0; } // Không tốn xăng
            @Override public void charge() { System.out.println("Electric Car is charging..."); }
        }

        static void run() {
            System.out.println("--- BÀI 10 ---");
            Movable[] vehicles = { new Car(), new Bicycle(), new ElectricCar() };
            
            for (Movable m : vehicles) {
                m.move();
                m.stop();
                if (m instanceof ElectricChargeable) {
                    ((ElectricChargeable) m).charge();
                }
                if (m instanceof FuelConsumable) {
                    System.out.println("Fuel: " + ((FuelConsumable) m).getFuelConsumption());
                }
                System.out.println("-");
            }
        }
    }
}