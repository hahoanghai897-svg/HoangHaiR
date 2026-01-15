/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bailab3.pkg1;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class BaiLAB31 {

    /**
     * @param args the command line arguments
     */

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 3.1 =========");
            System.out.println("1. Bài 1: Lớp Student");
            System.out.println("2. Bài 2: Lớp Rectangle (HCN)");
            System.out.println("3. Bài 3: Lớp Employee");
            System.out.println("4. Bài 4: Lớp Circle (Tròn)");
            System.out.println("5. Bài 5: Lớp BankAccount");
            System.out.println("6. Bài 6: Lớp Product");
            System.out.println("7. Bài 7: Lớp Car");
            System.out.println("8. Bài 8: Lớp Book");
            System.out.println("0. Thoát");
            System.out.print("Chọn bài (0-8): ");

            int choice = sc.nextInt();
            sc.nextLine(); // Xử lý trôi dòng

            switch (choice) {
                case 1: testStudent(); break;
                case 2: testRectangle(); break;
                case 3: testEmployee(); break;
                case 4: testCircle(); break;
                case 5: testBankAccount(); break;
                case 6: testProduct(); break;
                case 7: testCar(); break;
                case 8: testBook(); break;
                case 0: 
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                default: System.out.println("Chọn sai, vui lòng chọn lại!");
            }
            System.out.println("\nẤn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    // ================= BÀI 1: STUDENT =================
    static class Student {
        String id, name;
        double score;

        void input() {
            System.out.print("Nhập ID: "); id = sc.nextLine();
            System.out.print("Nhập Tên: "); name = sc.nextLine();
            System.out.print("Nhập Điểm: "); score = sc.nextDouble();
        }

        void display() {
            System.out.println("SV: " + name + " (ID: " + id + ") - Điểm: " + score);
        }

        boolean isPass() {
            return score >= 5.0;
        }
    }

    static void testStudent() {
        System.out.println("--- BÀI 1: STUDENT ---");
        Student s = new Student();
        s.input();
        s.display();
        System.out.println("Trạng thái: " + (s.isPass() ? "Đạt (Pass)" : "Trượt (Fail)"));
    }

    // ================= BÀI 2: RECTANGLE =================
    static class Rectangle {
        double length, width;

        void input() {
            System.out.print("Nhập chiều dài: "); length = sc.nextDouble();
            System.out.print("Nhập chiều rộng: "); width = sc.nextDouble();
        }

        double getArea() { return length * width; }
        double getPerimeter() { return (length + width) * 2; }

        void display() {
            System.out.println("Length: " + length + " - Width: " + width);
            System.out.println("Diện tích: " + getArea() + " - Chu vi: " + getPerimeter());
        }
    }

    static void testRectangle() {
        System.out.println("--- BÀI 2: RECTANGLE ---");
        Rectangle r = new Rectangle();
        r.input();
        r.display();
    }

    // ================= BÀI 3: EMPLOYEE =================
    static class Employee {
        String id, name;
        double salary;

        void input() {
            System.out.print("Nhập ID: "); id = sc.nextLine();
            System.out.print("Nhập Tên: "); name = sc.nextLine();
            System.out.print("Nhập Lương: "); salary = sc.nextDouble();
        }

        void display() {
            System.out.printf("ID: %s – Name: %s – Salary: %.0f\n", id, name, salary);
        }

        double calculateTax() {
            if (salary > 10000000) return salary * 0.1; // 10% nếu > 10 triệu
            return 0;
        }
    }

    static void testEmployee() {
        System.out.println("--- BÀI 3: EMPLOYEE ---");
        Employee e = new Employee();
        e.input();
        e.display();
        System.out.printf("Thuế thu nhập: %.0f VNĐ\n", e.calculateTax());
    }

    // ================= BÀI 4: CIRCLE =================
    static class Circle {
        double radius;

        void input() {
            System.out.print("Nhập bán kính: "); radius = sc.nextDouble();
        }

        double getArea() { return Math.PI * radius * radius; }
        double getPerimeter() { return 2 * Math.PI * radius; }
        boolean isBigCircle() { return getArea() > 100; }
    }

    static void testCircle() {
        System.out.println("--- BÀI 4: CIRCLE ---");
        Circle c = new Circle();
        c.input();
        System.out.printf("Diện tích: %.2f - Chu vi: %.2f\n", c.getArea(), c.getPerimeter());
        System.out.println("Là hình tròn lớn (>100): " + c.isBigCircle());
    }

    // ================= BÀI 5: BANK ACCOUNT =================
    static class BankAccount {
        String accountNumber, ownerName;
        double balance;

        // Constructor để tạo nhanh (tùy chọn)
        public BankAccount(String acc, String owner) {
            this.accountNumber = acc;
            this.ownerName = owner;
            this.balance = 0;
        }

        void deposit(double amount) {
            if(amount > 0) {
                balance += amount;
                System.out.println("Đã nạp: " + amount);
            }
        }

        void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Đã rút: " + amount);
            } else {
                System.out.println("Số dư không đủ để rút!");
            }
        }

        double checkBalance() { return balance; }

        void display() {
            System.out.printf("STK: %s – Chủ tài khoản: %s – Số dư: %.0f\n", accountNumber, ownerName, balance);
        }
    }

    static void testBankAccount() {
        System.out.println("--- BÀI 5: BANK ACCOUNT ---");
        // Nhập cứng hoặc nhập từ bàn phím tùy ý
        System.out.print("Nhập số TK: "); String acc = sc.nextLine();
        System.out.print("Nhập tên chủ TK: "); String owner = sc.nextLine();
        BankAccount tk = new BankAccount(acc, owner);
        
        tk.deposit(500000); // Nạp 500k
        tk.withdraw(200000); // Rút 200k
        tk.display();
    }

    // ================= BÀI 6: PRODUCT =================
    static class Product {
        String id, name;
        double price;
        int quantity;

        void input() {
            System.out.print("Nhập ID SP: "); id = sc.nextLine();
            System.out.print("Nhập Tên SP: "); name = sc.nextLine();
            System.out.print("Nhập Giá: "); price = sc.nextDouble();
            System.out.print("Nhập Số lượng: "); quantity = sc.nextInt();
        }

        double getTotalPrice() { return price * quantity; }
        
        void discount(double percent) {
            price = price * (1 - percent/100);
            System.out.println("Đã giảm giá " + percent + "%. Giá mới: " + price);
        }

        void display() {
            System.out.printf("ID: %s – Name: %s – Price: %.0f – Quantity: %d\n", id, name, price, quantity);
        }
    }

    static void testProduct() {
        System.out.println("--- BÀI 6: PRODUCT ---");
        Product p = new Product();
        p.input();
        p.display();
        System.out.println("Tổng tiền kho: " + p.getTotalPrice());
        p.discount(10); // Thử giảm giá 10%
    }

    // ================= BÀI 7: CAR =================
    static class Car {
        String brand, model;
        double speed;

        // Constructor
        public Car() { speed = 0; } // Mặc định tốc độ 0

        void input() {
            System.out.print("Nhập Hãng xe: "); brand = sc.nextLine();
            System.out.print("Nhập Dòng xe (Model): "); model = sc.nextLine();
        }

        void accelerate(int value) {
            speed += value;
            System.out.println("Đạp ga " + value + "km/h.");
        }

        void brake(int value) {
            if (speed - value < 0) speed = 0;
            else speed -= value;
            System.out.println("Đạp phanh " + value + "km/h.");
        }

        void displayStatus() {
            System.out.println("Model: " + model + " – Speed: " + speed + " km/h");
        }

        boolean isOverSpeed() { return speed > 100; }
    }

    static void testCar() {
        System.out.println("--- BÀI 7: CAR ---");
        Car c = new Car();
        c.input();
        c.accelerate(60);
        c.accelerate(50); // Tổng 110
        c.displayStatus();
        if (c.isOverSpeed()) System.out.println("Cảnh báo: Đang chạy quá tốc độ!");
        c.brake(20);
        c.displayStatus();
    }

    // ================= BÀI 8: BOOK =================
    static class Book {
        String title, author;
        double price;
        int year;

        void input() {
            System.out.print("Nhập tên sách: "); title = sc.nextLine();
            System.out.print("Nhập tác giả: "); author = sc.nextLine();
            System.out.print("Nhập giá: "); price = sc.nextDouble();
            System.out.print("Nhập năm XB: "); year = sc.nextInt();
        }

        void display() {
            System.out.printf("Title: %s – Author: %s – Price: %.0f – Year: %d\n", title, author, price, year);
        }

        boolean isExpensive() { return price > 200000; }
        boolean isOldBook() { return year < 2015; }
    }

    static void testBook() {
        System.out.println("--- BÀI 8: BOOK ---");
        Book b = new Book();
        b.input();
        b.display();
        if (b.isExpensive()) System.out.println("-> Sách đắt tiền (>200k)");
        if (b.isOldBook()) System.out.println("-> Sách cũ (<2015)");
    }
}
    

