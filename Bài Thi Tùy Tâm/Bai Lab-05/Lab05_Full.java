/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab05_full; // Giữ nguyên package của bạn

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Lab05_Full {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 05 (QUAN HỆ KẾT TẬP) =========");
            System.out.println("1.  Student - Address");
            System.out.println("2.  Employee - Date");
            System.out.println("3.  Student - Department");
            System.out.println("4.  Book - Author");
            System.out.println("5.  Car - Engine");
            System.out.println("6.  House - Room");
            System.out.println("7.  Customer - Address");
            System.out.println("8.  User - Account (Login)");
            System.out.println("9.  Student - Score");
            System.out.println("10. Flight - Time");
            System.out.println("11. Subject - Teacher");
            System.out.println("12. Order - Product");
            System.out.println("13. Invoice - Customer");
            System.out.println("14. Employee - Department");
            System.out.println("15. Student - ClassRoom - Teacher (Chuỗi kết tập)");
            System.out.println("0.  Thoát");
            System.out.print("Chọn bài (0-15): ");

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
                case 11: Bai11.run(); break;
                case 12: Bai12.run(); break;
                case 13: Bai13.run(); break;
                case 14: Bai14.run(); break;
                case 15: Bai15.run(); break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Chọn sai!");
            }
            System.out.println("\nẤn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    // ================= BÀI 1: STUDENT - ADDRESS =================
    static class Bai1 {
        static class Address {
            String street, city;
            void input() {
                System.out.print("Nhập tên đường: "); street = Lab05_Full.sc.nextLine();
                System.out.print("Nhập thành phố: "); city = Lab05_Full.sc.nextLine();
            }
            void display() { System.out.print(street + ", " + city); }
        }
        static class Student {
            String id, name;
            Address address = new Address(); // HAS-A
            void input() {
                System.out.print("Nhập mã SV: "); id = Lab05_Full.sc.nextLine();
                System.out.print("Nhập tên SV: "); name = Lab05_Full.sc.nextLine();
                System.out.println("--- Nhập địa chỉ ---");
                address.input();
            }
            void display() {
                System.out.print("SV: " + name + " (" + id + ") - ĐC: ");
                address.display();
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 1 ---");
            Student s = new Student();
            s.input();
            s.display();
        }
    }

    // ================= BÀI 2: EMPLOYEE - DATE =================
    static class Bai2 {
        static class MyDate {
            int day, month, year;
            public MyDate(int d, int m, int y) { day = d; month = m; year = y; }
            void display() { System.out.print(day + "/" + month + "/" + year); }
        }
        static class Employee {
            String id, name;
            MyDate birthDate; // HAS-A
            public Employee(String id, String name, MyDate dob) {
                this.id = id; this.name = name; this.birthDate = dob;
            }
            void display() {
                System.out.print("NV: " + name + " - Ngày sinh: ");
                birthDate.display();
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 2 ---");
            MyDate dob = new MyDate(15, 5, 1995);
            Employee emp = new Employee("NV01", "Tran Van B", dob);
            emp.display();
        }
    }

    // ================= BÀI 3: STUDENT - DEPARTMENT =================
    static class Bai3 {
        static class Department {
            String deptId, deptName;
            public Department(String id, String name) { deptId = id; deptName = name; }
            void display() { System.out.print(deptName); }
        }
        static class Student {
            String id, name;
            Department department;
            public Student(String id, String name, Department dept) {
                this.id = id; this.name = name; this.department = dept;
            }
            void display() {
                System.out.print("SV: " + name + " - Khoa: ");
                department.display();
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 3 ---");
            Department dept = new Department("IT", "Cong Nghe Thong Tin");
            Student s = new Student("SV02", "Le Thi C", dept);
            s.display();
        }
    }

    // ================= BÀI 4: BOOK - AUTHOR =================
    static class Bai4 {
        static class Author {
            String name, email;
            public Author(String n, String e) { name = n; email = e; }
            void display() { System.out.print(name + " (" + email + ")"); }
        }
        static class Book {
            String title; double price;
            Author author;
            public Book(String t, double p, Author a) {
                title = t; price = p; author = a;
            }
            void display() {
                System.out.print("Sách: " + title + " - Giá: " + price + " - Tác giả: ");
                author.display();
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 4 ---");
            Author au = new Author("Nam Cao", "namcao@lit.vn");
            Book b = new Book("Chi Pheo", 50000, au);
            b.display();
        }
    }

    // ================= BÀI 5: CAR - ENGINE =================
    static class Bai5 {
        static class Engine {
            String type; int power;
            public Engine(String t, int p) { type = t; power = p; }
            void display() { System.out.print(type + " (" + power + "HP)"); }
        }
        static class Car {
            String brand, color;
            Engine engine;
            public Car(String b, String c, Engine e) {
                brand = b; color = c; engine = e;
            }
            void display() {
                System.out.print("Xe: " + brand + " - Màu: " + color + " - Động cơ: ");
                engine.display();
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 5 ---");
            Engine eng = new Engine("V8 Turbo", 450);
            Car car = new Car("BMW", "Đen", eng);
            car.display();
        }
    }

    // ================= BÀI 6: HOUSE - ROOM =================
    static class Bai6 {
        static class Room {
            String roomName; double area;
            public Room(String n, double a) { roomName = n; area = a; }
            void display() { System.out.print(roomName + " (" + area + "m2)"); }
        }
        static class House {
            String houseId;
            Room room; // Phòng chính
            public House(String id, Room r) { houseId = id; room = r; }
            void display() {
                System.out.print("Nhà số: " + houseId + " - Phòng chính: ");
                room.display();
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 6 ---");
            Room r = new Room("Phong Khach", 30.5);
            House h = new House("H001", r);
            h.display();
        }
    }

    // ================= BÀI 7: CUSTOMER - ADDRESS =================
    static class Bai7 {
        static class Address {
            String street, city;
            public Address(String s, String c) { street = s; city = c; }
            public String toString() { return street + ", " + city; }
        }
        static class Customer {
            String id, name;
            Address address;
            void input() {
                System.out.print("ID Khách: "); id = Lab05_Full.sc.nextLine();
                System.out.print("Tên Khách: "); name = Lab05_Full.sc.nextLine();
                System.out.print("Đường: "); String s = Lab05_Full.sc.nextLine();
                System.out.print("Thành phố: "); String c = Lab05_Full.sc.nextLine();
                address = new Address(s, c);
            }
            void display() {
                System.out.println("KH: " + name + " - ĐC: " + address);
            }
        }
        static void run() {
            System.out.println("--- BÀI 7 ---");
            Customer c = new Customer();
            c.input();
            c.display();
        }
    }

    // ================= BÀI 8: USER - ACCOUNT =================
    static class Bai8 {
        static class Account {
            String username, password;
            public Account(String u, String p) { username = u; password = p; }
            boolean checkLogin(String u, String p) {
                return username.equals(u) && password.equals(p);
            }
        }
        static class User {
            String name;
            Account account;
            public User(String n, Account acc) { name = n; account = acc; }
            void login() {
                System.out.print("User: "); String u = Lab05_Full.sc.nextLine();
                System.out.print("Pass: "); String p = Lab05_Full.sc.nextLine();
                if (account.checkLogin(u, p)) System.out.println("Đăng nhập thành công! Chào " + name);
                else System.out.println("Sai thông tin đăng nhập!");
            }
        }
        static void run() {
            System.out.println("--- BÀI 8 ---");
            Account acc = new Account("admin", "123");
            User u = new User("Quan tri vien", acc);
            u.login();
        }
    }

    // ================= BÀI 9: STUDENT - SCORE =================
    static class Bai9 {
        static class Score {
            double math, physics, chemistry;
            public Score(double m, double p, double c) { math = m; physics = p; chemistry = c; }
            double getAverage() { return (math + physics + chemistry) / 3; }
        }
        static class Student {
            String name;
            Score score;
            public Student(String n, Score s) { name = n; score = s; }
            void display() {
                System.out.printf("SV: %s - Điểm TB: %.2f\n", name, score.getAverage());
            }
        }
        static void run() {
            System.out.println("--- BÀI 9 ---");
            Score s = new Score(8, 7.5, 9);
            Student stu = new Student("Nguyen Van Gioi", s);
            stu.display();
        }
    }

    // ================= BÀI 10: FLIGHT - TIME =================
    static class Bai10 {
        static class Time {
            int hour, minute;
            public Time(int h, int m) { hour = h; minute = m; }
            void display() { System.out.print(hour + ":" + minute); }
        }
        static class Flight {
            String flightCode;
            Time departureTime;
            public Flight(String c, Time t) { flightCode = c; departureTime = t; }
            void display() {
                System.out.print("Chuyến bay: " + flightCode + " - Giờ bay: ");
                departureTime.display();
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 10 ---");
            Time t = new Time(14, 30);
            Flight f = new Flight("VN-202", t);
            f.display();
        }
    }

    // ================= BÀI 11: SUBJECT - TEACHER =================
    static class Bai11 {
        static class Teacher {
            String name, degree;
            public Teacher(String n, String d) { name = n; degree = d; }
            void display() { System.out.print(degree + ". " + name); }
        }
        static class Subject {
            String subjectName;
            Teacher teacher;
            public Subject(String sub, Teacher t) { subjectName = sub; teacher = t; }
            void display() {
                System.out.print("Môn: " + subjectName + " - GV: ");
                teacher.display();
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 11 ---");
            Teacher t = new Teacher("Hung", "ThS");
            Subject sub = new Subject("Lap trinh Java", t);
            sub.display();
        }
    }

    // ================= BÀI 12: ORDER - PRODUCT =================
    static class Bai12 {
        static class Product {
            String productName; double price;
            public Product(String n, double p) { productName = n; price = p; }
        }
        static class Order {
            String orderId;
            Product product; // Sản phẩm trong đơn
            public Order(String id, Product p) { orderId = id; product = p; }
            double getTotal() { return product.price; }
            void display() {
                System.out.println("Đơn: " + orderId + " - SP: " + product.productName + " - Tổng: " + getTotal());
            }
        }
        static void run() {
            System.out.println("--- BÀI 12 ---");
            Product p = new Product("Laptop Dell", 15000000);
            Order o = new Order("ORD-001", p);
            o.display();
        }
    }

    // ================= BÀI 13: INVOICE - CUSTOMER =================
    static class Bai13 {
        static class Customer {
            String name;
            public Customer(String n) { name = n; }
        }
        static class Invoice {
            String invoiceId; double amount;
            Customer customer;
            public Invoice(String id, double amt, Customer c) {
                invoiceId = id; amount = amt; customer = c;
            }
            void display() {
                System.out.println("Hóa đơn: " + invoiceId + " - Khách: " + customer.name + " - Tiền: " + amount);
            }
        }
        static void run() {
            System.out.println("--- BÀI 13 ---");
            Customer c = new Customer("Chi Lan");
            Invoice inv = new Invoice("INV-999", 500000, c);
            inv.display();
        }
    }

    // ================= BÀI 14: EMPLOYEE - DEPARTMENT =================
    static class Bai14 {
        static class Department {
            String deptName;
            public Department(String n) { deptName = n; }
        }
        static class Employee {
            String id, name;
            double salary;
            Department department;
            public Employee(String i, String n, double s, Department d) {
                id = i; name = n; salary = s; department = d;
            }
            void display() {
                System.out.println("NV: " + name + " - Lương: " + salary + " - Phòng: " + department.deptName);
            }
        }
        static void run() {
            System.out.println("--- BÀI 14 ---");
            Department d = new Department("Ke Toan");
            Employee e = new Employee("KT01", "Thu Ha", 8000000, d);
            e.display();
        }
    }

    // ================= BÀI 15: STUDENT - CLASSROOM - TEACHER =================
    static class Bai15 {
        static class Teacher {
            String name;
            public Teacher(String n) { name = n; }
            public String toString() { return name; }
        }
        static class ClassRoom {
            String className;
            Teacher teacher; // Giáo viên phụ trách
            public ClassRoom(String cn, Teacher t) { className = cn; teacher = t; }
            public String toString() { return className + " (GV: " + teacher + ")"; }
        }
        static class Student {
            String name;
            ClassRoom classRoom; // Lớp đang học
            public Student(String n, ClassRoom cr) { name = n; classRoom = cr; }
            void display() {
                System.out.println("SV: " + name + " - Thuộc: " + classRoom);
            }
        }
        static void run() {
            System.out.println("--- BÀI 15 ---");
            Teacher t = new Teacher("Thay Dung");
            ClassRoom cr = new ClassRoom("CNTT 1", t);
            Student s = new Student("Tuan Anh", cr);
            s.display();
        }
    }
}