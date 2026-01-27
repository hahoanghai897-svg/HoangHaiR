/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07_full; // Bạn có thể đổi tên package này tùy ý hoặc xóa nếu không dùng

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab07_Full {
    // Khai báo Scanner là public static để các class con truy cập dễ dàng
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 07 (ABSTRACT CLASS) =========");
            System.out.println("1.  Bài 1: Quản lý hình học (Shape)");
            System.out.println("2.  Bài 2: Nhân viên cơ bản (Lương)");
            System.out.println("3.  Bài 3: Phương tiện giao thông (Vehicle)");
            System.out.println("4.  Bài 4: Động vật (Animal Sound/Move)");
            System.out.println("5.  Bài 5: Tài khoản ngân hàng (Lãi suất)");
            System.out.println("6.  Bài 6: Thiết bị điện (Công suất)");
            System.out.println("7.  Bài 7: Nhân viên công ty (Thu nhập)");
            System.out.println("8.  Bài 8: Hình học nâng cao (Chu vi & Diện tích)");
            System.out.println("9.  Bài 9: Dịch vụ vận chuyển (Chi phí)");
            System.out.println("10. Bài 10: Hệ thống thanh toán");
            System.out.println("0.  Thoát");
            System.out.print("Chọn bài (0-10): ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine()); // Nhập chuỗi rồi ép kiểu để tránh trôi lệnh
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
                default: System.out.println("Chọn sai, vui lòng chọn lại!");
            }
            System.out.println("\nẤn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    // ================= BÀI 1: QUẢN LÝ HÌNH HỌC =================
    static class Bai1 {
        static abstract class Shape {
            String name;
            public Shape(String name) { this.name = name; }
            abstract double area(); 
            void display() {
                System.out.printf("Hình: %s - Diện tích: %.2f\n", name, area());
            }
        }
        static class Rectangle extends Shape {
            double width, height;
            public Rectangle(double w, double h) {
                super("Chữ nhật"); this.width = w; this.height = h;
            }
            @Override double area() { return width * height; }
        }
        static class Circle extends Shape {
            double radius;
            public Circle(double r) {
                super("Tròn"); this.radius = r;
            }
            @Override double area() { return Math.PI * radius * radius; }
        }
        static void run() {
            System.out.println("--- BÀI 1 ---");
            List<Shape> list = new ArrayList<>();
            list.add(new Rectangle(4, 5));
            list.add(new Circle(3.5));
            for (Shape s : list) s.display();
        }
    }

    // ================= BÀI 2: NHÂN VIÊN CƠ BẢN =================
    static class Bai2 {
        static abstract class Employee {
            String id, name;
            public Employee(String id, String name) { this.id = id; this.name = name; }
            abstract double calculateSalary();
            void showInfo() {
                System.out.printf("NV: %s - %s - Lương: %.0f VND\n", id, name, calculateSalary());
            }
        }
        static class FullTimeEmployee extends Employee {
            double monthlySalary;
            public FullTimeEmployee(String id, String name, double salary) {
                super(id, name); this.monthlySalary = salary;
            }
            @Override double calculateSalary() { return monthlySalary; }
        }
        static class PartTimeEmployee extends Employee {
            int workingHours; double hourlyRate;
            public PartTimeEmployee(String id, String name, int hours, double rate) {
                super(id, name); this.workingHours = hours; this.hourlyRate = rate;
            }
            @Override double calculateSalary() { return workingHours * hourlyRate; }
        }
        static void run() {
            System.out.println("--- BÀI 2 ---");
            new FullTimeEmployee("FT01", "Nguyen A", 15000000).showInfo();
            new PartTimeEmployee("PT01", "Tran B", 50, 30000).showInfo();
        }
    }

    // ================= BÀI 3: PHƯƠNG TIỆN GIAO THÔNG =================
    static class Bai3 {
        static abstract class Vehicle {
            String brand;
            public Vehicle(String brand) { this.brand = brand; }
            abstract int getMaxSpeed();
            void showInfo() {
                System.out.println("Xe " + brand + " - Tốc độ tối đa: " + getMaxSpeed() + " km/h");
            }
        }
        static class Car extends Vehicle {
            public Car(String brand) { super(brand); }
            @Override int getMaxSpeed() { return 180; }
        }
        static class Motorbike extends Vehicle {
            public Motorbike(String brand) { super(brand); }
            @Override int getMaxSpeed() { return 120; }
        }
        static void run() {
            System.out.println("--- BÀI 3 ---");
            new Car("Toyota").showInfo();
            new Motorbike("Honda").showInfo();
        }
    }

    // ================= BÀI 4: ĐỘNG VẬT =================
    static class Bai4 {
        static abstract class Animal {
            String name;
            public Animal(String name) { this.name = name; }
            abstract void makeSound();
            abstract void move();
            void show() {
                System.out.print(name + ": "); makeSound(); System.out.print(", "); move(); System.out.println();
            }
        }
        static class Dog extends Animal {
            public Dog() { super("Chó"); }
            @Override void makeSound() { System.out.print("Gâu gâu"); }
            @Override void move() { System.out.print("Chạy 4 chân"); }
        }
        static class Cat extends Animal {
            public Cat() { super("Mèo"); }
            @Override void makeSound() { System.out.print("Meow meow"); }
            @Override void move() { System.out.print("Đi nhẹ nhàng"); }
        }
        static class Bird extends Animal {
            public Bird() { super("Chim"); }
            @Override void makeSound() { System.out.print("Chíp chíp"); }
            @Override void move() { System.out.print("Bay"); }
        }
        static void run() {
            System.out.println("--- BÀI 4 ---");
            new Dog().show(); new Cat().show(); new Bird().show();
        }
    }

    // ================= BÀI 5: TÀI KHOẢN NGÂN HÀNG =================
    static class Bai5 {
        static abstract class BankAccount {
            String accountNumber; double balance;
            public BankAccount(String acc, double bal) { accountNumber = acc; balance = bal; }
            abstract double calculateInterest();
            void deposit(double amount) { balance += amount; System.out.println("Nạp " + amount); }
            void withdraw(double amount) {
                if(balance >= amount) { balance -= amount; System.out.println("Rút " + amount); }
                else System.out.println("Số dư không đủ!");
            }
            void showInfo() {
                System.out.printf("TK: %s - Dư: %.0f - Lãi: %.0f\n", accountNumber, balance, calculateInterest());
            }
        }
        static class SavingAccount extends BankAccount {
            public SavingAccount(String acc, double bal) { super(acc, bal); }
            @Override double calculateInterest() { return balance * 0.05; } // Lãi 5%
        }
        static class CheckingAccount extends BankAccount {
            public CheckingAccount(String acc, double bal) { super(acc, bal); }
            @Override double calculateInterest() { return 0; } // Không lãi
        }
        static void run() {
            System.out.println("--- BÀI 5 ---");
            BankAccount a1 = new SavingAccount("SAV01", 5000000);
            a1.deposit(500000); a1.showInfo();
            BankAccount a2 = new CheckingAccount("CHK01", 2000000);
            a2.withdraw(100000); a2.showInfo();
        }
    }

    // ================= BÀI 6: THIẾT BỊ ĐIỆN =================
    static class Bai6 {
        static abstract class Device {
            String name;
            public Device(String name) { this.name = name; }
            abstract double powerConsumption();
            void show() { System.out.println(name + ": " + powerConsumption() + "W"); }
        }
        static class Laptop extends Device {
            public Laptop() { super("Laptop"); }
            @Override double powerConsumption() { return 65; }
        }
        static class AC extends Device {
            public AC() { super("Điều hòa"); }
            @Override double powerConsumption() { return 1500; }
        }
        static class TV extends Device {
            public TV() { super("TV"); }
            @Override double powerConsumption() { return 150; }
        }
        static void run() {
            System.out.println("--- BÀI 6 ---");
            List<Device> ds = new ArrayList<>();
            ds.add(new Laptop()); ds.add(new AC()); ds.add(new TV());
            Device max = ds.get(0);
            for(Device d : ds) {
                d.show();
                if(d.powerConsumption() > max.powerConsumption()) max = d;
            }
            System.out.println("-> Tốn điện nhất: " + max.name);
        }
    }

    // ================= BÀI 7: NHÂN VIÊN CÔNG TY =================
    static class Bai7 {
        static abstract class Staff {
            String name;
            public Staff(String n) { name = n; }
            abstract double getIncome();
            void show() { System.out.printf("NV: %s - Thu nhập: %.0f\n", name, getIncome()); }
        }
        static class OfficeStaff extends Staff {
            double salary;
            public OfficeStaff(String n, double s) { super(n); salary = s; }
            @Override double getIncome() { return salary; }
        }
        static class SalesStaff extends Staff {
            double base, sales, rate;
            public SalesStaff(String n, double b, double s, double r) {
                super(n); base = b; sales = s; rate = r;
            }
            @Override double getIncome() { return base + (sales * rate); }
        }
        static void run() {
            System.out.println("--- BÀI 7 ---");
            List<Staff> list = new ArrayList<>();
            list.add(new OfficeStaff("HCNS", 8000000));
            list.add(new SalesStaff("Sale", 5000000, 100000000, 0.05));
            double total = 0;
            for(Staff s : list) { s.show(); total += s.getIncome(); }
            System.out.printf("-> Tổng lương công ty trả: %.0f\n", total);
        }
    }

    // ================= BÀI 8: HÌNH HỌC NÂNG CAO =================
    static class Bai8 {
        static abstract class GeometricObject {
            abstract double getArea();
            abstract double getPerimeter();
            void show() { System.out.printf("DT: %.2f | Chu vi: %.2f\n", getArea(), getPerimeter()); }
        }
        static class Rectangle extends GeometricObject {
            double w, h;
            public Rectangle(double w, double h) { this.w = w; this.h = h; }
            @Override double getArea() { return w * h; }
            @Override double getPerimeter() { return (w + h) * 2; }
        }
        static class Square extends Rectangle {
            public Square(double s) { super(s, s); }
        }
        static class Circle extends GeometricObject {
            double r;
            public Circle(double r) { this.r = r; }
            @Override double getArea() { return Math.PI * r * r; }
            @Override double getPerimeter() { return 2 * Math.PI * r; }
        }
        static void run() {
            System.out.println("--- BÀI 8 ---");
            System.out.print("HCN (4x5): "); new Rectangle(4, 5).show();
            System.out.print("Vuông (4): "); new Square(4).show();
            System.out.print("Tròn (3): "); new Circle(3).show();
        }
    }

    // ================= BÀI 9: DỊCH VỤ VẬN CHUYỂN =================
    static class Bai9 {
        static abstract class Transport {
            String name;
            public Transport(String n) { name = n; }
            abstract double cost(double km);
            abstract int capacity();
            void show(double km) {
                System.out.printf("%s: %.0f VND (Chở %d người)\n", name, cost(km), capacity());
            }
        }
        static class Bus extends Transport {
            public Bus() { super("Bus"); }
            @Override double cost(double km) { return km * 5000; }
            @Override int capacity() { return 45; }
        }
        static class Taxi extends Transport {
            public Taxi() { super("Taxi"); }
            @Override double cost(double km) { return km * 15000; }
            @Override int capacity() { return 4; }
        }
        static class Train extends Transport {
            public Train() { super("Tàu hỏa"); }
            @Override double cost(double km) { return km * 8000; }
            @Override int capacity() { return 200; }
        }
        static void run() {
            System.out.println("--- BÀI 9 ---");
            System.out.print("Nhập quãng đường (km): ");
            // Sửa lỗi: dùng Lab07_Full.sc để truy cập Scanner static
            double km = 0;
            try {
                km = Double.parseDouble(Lab07_Full.sc.nextLine());
            } catch (Exception e) {
                System.out.println("Lỗi nhập số, mặc định 10km.");
                km = 10;
            }
            
            System.out.println("Quãng đường: " + km + " km");
            List<Transport> t = new ArrayList<>();
            t.add(new Bus()); t.add(new Taxi()); t.add(new Train());
            Transport cheap = t.get(0);
            for(Transport i : t) {
                i.show(km);
                if(i.cost(km) < cheap.cost(km)) cheap = i;
            }
            System.out.println("-> Rẻ nhất: " + cheap.name);
        }
    }

    // ================= BÀI 10: THANH TOÁN =================
    static class Bai10 {
        static abstract class PaymentMethod {
            String name;
            public PaymentMethod(String n) { name = n; }
            abstract boolean pay(double amount);
            void receipt(double amount) { System.out.println("[Biên lai] Đã trả " + amount + " qua " + name); }
        }
        static class Cash extends PaymentMethod {
            public Cash() { super("Tiền mặt"); }
            @Override boolean pay(double amt) { return true; }
        }
        static class Card extends PaymentMethod {
            public Card() { super("Thẻ tín dụng"); }
            @Override boolean pay(double amt) { return amt <= 5000000; } // Giới hạn 5tr
        }
        static class Ewallet extends PaymentMethod {
            public Ewallet() { super("Ví điện tử"); }
            @Override boolean pay(double amt) { return true; }
        }
        static void run() {
            System.out.println("--- BÀI 10 ---");
            List<PaymentMethod> list = new ArrayList<>();
            list.add(new Cash()); list.add(new Card()); list.add(new Ewallet());
            double amt = 6000000;
            System.out.println("Thanh toán: " + amt);
            for(PaymentMethod p : list) {
                if(p.pay(amt)) p.receipt(amt);
                else System.out.println("Lỗi: " + p.name + " từ chối giao dịch (Hạn mức 5tr).");
            }
        }
    }
}