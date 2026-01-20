/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab04_full;
import java.util.Scanner;

public class Lab04_Full {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 04 (OOP CORE) =========");
            System.out.println("1. Bài 1: Đóng gói (Student - Getter/Setter)");
            System.out.println("2. Bài 2: Đóng gói & Logic (BankAccount)");
            System.out.println("3. Bài 3: Constructor (Book)");
            System.out.println("4. Bài 4: Constructor Logic (Employee)");
            System.out.println("5. Bài 5: Nạp chồng phương thức (Calculator)");
            System.out.println("6. Bài 6: Nạp chồng Constructor (Rectangle)");
            System.out.println("7. Bài 7: Kết tập (Address - Student)");
            System.out.println("8. Bài 8: Kết tập (Employee - Department)");
            System.out.println("9. Bài 9: Kết tập (CPU - Computer)");
            System.out.println("10. Bài 10: Tổng hợp (Teacher - ClassRoom)");
            System.out.println("0. Thoát");
            System.out.print("Chọn bài (0-10): ");

            int choice = sc.nextInt();
            sc.nextLine(); // Xử lý trôi dòng

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

    // =========================================================
    // BÀI 1: ĐÓNG GÓI (Encapsulation)
    // =========================================================
    static class Bai1 {
        static class Student {
            // Thuộc tính private để bảo vệ dữ liệu
            private String id;
            private String name;
            private double score;

            // Getter và Setter
            public String getId() { return id; }
            public void setId(String id) { this.id = id; }
            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
            public double getScore() { return score; }
            public void setScore(double score) { this.score = score; }

            public boolean isPass() { return score >= 5; }

            public void display() {
                System.out.println("SV: " + name + " (" + id + ") - Điểm: " + score);
            }
        }
        static void run() {
            System.out.println("--- BÀI 1 ---");
            Student s = new Student();
            // Gán dữ liệu thông qua Setter
            s.setId("SV001");
            s.setName("Nguyen Van A");
            s.setScore(8.5);
            
            s.display();
            System.out.println("Kết quả: " + (s.isPass() ? "Đạt" : "Trượt"));
        }
    }

    // =========================================================
    // BÀI 2: BANK ACCOUNT (Logic trong Encapsulation)
    // =========================================================
    static class Bai2 {
        static class BankAccount {
            private String accountNumber;
            private String ownerName;
            private double balance;

            public BankAccount(String acc, String owner, double bal) {
                this.accountNumber = acc; this.ownerName = owner; this.balance = bal;
            }

            void deposit(double amount) {
                if (amount > 0) {
                    balance += amount;
                    System.out.println("-> Nạp thành công: " + amount);
                } else {
                    System.out.println("-> Lỗi: Số tiền nạp phải > 0");
                }
            }

            void withdraw(double amount) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("-> Rút thành công: " + amount);
                } else {
                    System.out.println("-> Lỗi: Số dư không đủ!");
                }
            }

            void displayInfo() {
                System.out.printf("TK: %s | Chủ: %s | Số dư: %.0f\n", accountNumber, ownerName, balance);
            }
        }
        static void run() {
            System.out.println("--- BÀI 2 ---");
            BankAccount tk = new BankAccount("123456", "Tran Van B", 5000000);
            tk.displayInfo();
            tk.deposit(1000000);
            tk.displayInfo();
            tk.withdraw(7000000); // Rút quá số dư
            tk.displayInfo();
        }
    }

    // =========================================================
    // BÀI 3: CONSTRUCTOR OVERLOADING (Sách)
    // =========================================================
    static class Bai3 {
        static class Book {
            String id, title;
            double price;

            // Constructor 1: Không tham số
            public Book() {
                this.id = "UNKNOWN"; this.title = "No Title"; this.price = 0;
            }
            // Constructor 2: Đầy đủ tham số
            public Book(String id, String title, double price) {
                this.id = id; this.title = title; this.price = price;
            }

            void display() {
                System.out.printf("Book: [%s] %s - %.0f VNĐ\n", id, title, price);
            }
        }
        static void run() {
            System.out.println("--- BÀI 3 ---");
            Book b1 = new Book(); // Gọi Constructor 1
            Book b2 = new Book("B01", "Lap Trinh Java", 150000); // Gọi Constructor 2
            
            System.out.print("Sách 1: "); b1.display();
            System.out.print("Sách 2: "); b2.display();
        }
    }

    // =========================================================
    // BÀI 4: LOGIC TRONG CONSTRUCTOR (Employee)
    // =========================================================
    static class Bai4 {
        static class Employee {
            String id, name;
            double salary;

            public Employee(String name) {
                this.name = name;
                this.id = "TEMP"; this.salary = 0;
            }
            public Employee(String id, String name, double salary) {
                this.id = id;
                this.name = name;
                // Logic kiểm tra lương
                if (salary < 0) this.salary = 0;
                else this.salary = salary;
            }

            void display() {
                System.out.println(name + " (" + id + ") - Salary: " + salary);
            }
        }
        static void run() {
            System.out.println("--- BÀI 4 ---");
            Employee e1 = new Employee("Nguyen Van C");
            Employee e2 = new Employee("NV02", "Le Thi D", -5000); // Lương âm
            
            e1.display();
            e2.display(); // Sẽ hiển thị lương = 0
        }
    }

    // =========================================================
    // BÀI 5: METHOD OVERLOADING (Calculator)
    // =========================================================
    static class Bai5 {
        static class Calculator {
            // Nạp chồng phương thức add
            int add(int a, int b) { return a + b; }
            double add(double a, double b) { return a + b; }
            int add(int a, int b, int c) { return a + b + c; }
        }
        static void run() {
            System.out.println("--- BÀI 5 ---");
            Calculator calc = new Calculator();
            System.out.println("2 số nguyên (5 + 10): " + calc.add(5, 10));
            System.out.println("2 số thực (2.5 + 3.1): " + calc.add(2.5, 3.1));
            System.out.println("3 số nguyên (1 + 2 + 3): " + calc.add(1, 2, 3));
        }
    }

    // =========================================================
    // BÀI 6: RECTANGLE CONSTRUCTORS
    // =========================================================
    static class Bai6 {
        static class Rectangle {
            double width, height;

            public Rectangle() { width = 1; height = 1; } // 1x1
            public Rectangle(double side) { width = height = side; } // Hình vuông
            public Rectangle(double w, double h) { width = w; height = h; } // HCN thường

            double getArea() { return width * height; }
        }
        static void run() {
            System.out.println("--- BÀI 6 ---");
            System.out.println("HCN 1 (Mặc định): Diện tích = " + new Rectangle().getArea());
            System.out.println("HCN 2 (Vuông cạnh 5): Diện tích = " + new Rectangle(5).getArea());
            System.out.println("HCN 3 (4 x 6): Diện tích = " + new Rectangle(4, 6).getArea());
        }
    }

    // =========================================================
    // BÀI 7: KẾT TẬP (Address - Student)
    // =========================================================
    static class Bai7 {
        static class Address {
            String street, city;
            public Address(String s, String c) { street = s; city = c; }
            @Override public String toString() { return street + ", " + city; }
        }
        static class Student {
            String id, name;
            Address address; // Kết tập: Student CÓ 1 Address

            public Student(String id, String name, Address addr) {
                this.id = id; this.name = name; this.address = addr;
            }
            void display() {
                System.out.println("SV: " + name + " - ĐC: " + address.toString());
            }
        }
        static void run() {
            System.out.println("--- BÀI 7 ---");
            Address addr = new Address("123 Xuan Thuy", "Ha Noi");
            Student s = new Student("SV99", "Hoang Long", addr);
            s.display();
        }
    }

    // =========================================================
    // BÀI 8: KẾT TẬP (Department - Employee)
    // =========================================================
    static class Bai8 {
        static class Employee {
            String id, name;
            public Employee(String id, String name) { this.id = id; this.name = name; }
            @Override public String toString() { return name + " (" + id + ")"; }
        }
        static class Department {
            String deptName;
            Employee employee; // Trưởng phòng (hoặc nhân viên đại diện)

            public Department(String deptName, Employee emp) {
                this.deptName = deptName; this.employee = emp;
            }
            void display() {
                System.out.println("Phòng: " + deptName + " - Trưởng phòng: " + employee.toString());
            }
        }
        static void run() {
            System.out.println("--- BÀI 8 ---");
            Employee manager = new Employee("NV_BOSS", "Nguyen Sep");
            Department dept = new Department("IT", manager);
            dept.display();
        }
    }

    // =========================================================
    // BÀI 9: COMPOSITION (Computer - CPU)
    // =========================================================
    static class Bai9 {
        static class CPU {
            String brand; double speed;
            public CPU(String brand, double speed) { this.brand = brand; this.speed = speed; }
            @Override public String toString() { return brand + " " + speed + "GHz"; }
        }
        static class Computer {
            String model;
            CPU cpu; // Computer CÓ CPU

            public Computer(String model, CPU cpu) {
                this.model = model; this.cpu = cpu;
            }
            void displayInfo() {
                System.out.println("PC Model: " + model + " | CPU: " + cpu.toString());
            }
        }
        static void run() {
            System.out.println("--- BÀI 9 ---");
            CPU corei9 = new CPU("Intel Core i9", 5.0);
            Computer pc = new Computer("Gaming Beast", corei9);
            pc.displayInfo();
        }
    }

    // =========================================================
    // BÀI 10: TỔNG HỢP (Teacher - ClassRoom)
    // =========================================================
    static class Bai10 {
        static class Teacher {
            private String name, specialization;

            public Teacher(String name, String spec) {
                this.name = name; this.specialization = spec;
            }
            // Getter/Setter nếu cần (ở đây dùng toString cho nhanh)
            @Override public String toString() { return name + " (Chuyên môn: " + specialization + ")"; }
        }
        static class ClassRoom {
            private String className;
            private Teacher teacher;

            public ClassRoom(String className, Teacher teacher) {
                this.className = className;
                this.teacher = teacher;
            }
            void display() {
                System.out.println("Lớp: " + className + " - GVCN: " + teacher.toString());
            }
        }
        static void run() {
            System.out.println("--- BÀI 10 ---");
            Teacher gv = new Teacher("Co Mai", "Tieng Anh");
            ClassRoom lop = new ClassRoom("12A1", gv);
            lop.display();
        }
    }
}