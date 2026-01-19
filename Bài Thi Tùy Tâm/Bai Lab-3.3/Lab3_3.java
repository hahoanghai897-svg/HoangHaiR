/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab3_3; // Giữ nguyên package này

import java.util.*; // Import thư viện phải nằm ở đây

/**
 *
 * @author admin
 */
public class Lab3_3 { // Tên class chính phải trùng tên file Lab3_3.java

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 3.3 (UML TO CODE) =========");
            System.out.println("1. Bài 1: Lớp Student (Cơ bản)");
            System.out.println("2. Bài 2: Lớp Product (Private/Public)");
            System.out.println("3. Bài 3: Lớp Employee");
            System.out.println("4. Bài 4: Quan hệ Association (Lớp học - SV)");
            System.out.println("5. Bài 5: Quan hệ Kế thừa (Person - Student/Teacher)");
            System.out.println("6. Bài 6: Quản lý Đơn hàng (1-1, 1-n)");
            System.out.println("7. Bài 7: Quan hệ Composition (Máy tính - CPU/RAM)");
            System.out.println("8. Bài 8: Quan hệ Aggregation (Thư viện - Sách)");
            System.out.println("9. Bài 9: Hệ thống Bán hàng (Tổng hợp)");
            System.out.println("10. Bài 10: Quản lý Khóa học");
            System.out.println("0. Thoát");
            System.out.print("Chọn bài (0-10): ");

            int chon = sc.nextInt();
            sc.nextLine(); // Xử lý trôi dòng

            switch (chon) {
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
                default: System.out.println("Chọn sai, vui lòng chọn lại!");
            }
            System.out.println("\nẤn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    // ================= BÀI 1: LỚP SINH VIÊN =================
    static class Bai1 {
        static class Student {
            String id, name;
            int age;

            void input() {
                System.out.print("Nhập ID: "); id = sc.nextLine();
                System.out.print("Nhập Tên: "); name = sc.nextLine();
                System.out.print("Nhập Tuổi: "); age = sc.nextInt(); sc.nextLine();
            }
            void display() {
                System.out.println("SV: " + id + " - " + name + " - " + age + " tuổi");
            }
        }
        static void run() {
            System.out.println("--- BÀI 1 ---");
            Student s = new Student();
            s.input();
            s.display();
        }
    }

    // ================= BÀI 2: LỚP SẢN PHẨM =================
    static class Bai2 {
        static class Product {
            // Phạm vi truy cập private theo yêu cầu
            private String productId;
            private String productName;
            private double price;

            public void input() {
                System.out.print("Nhập ID SP: "); productId = sc.nextLine();
                System.out.print("Nhập Tên SP: "); productName = sc.nextLine();
                System.out.print("Nhập Giá: "); price = sc.nextDouble(); sc.nextLine();
            }
            public void display() {
                System.out.println("SP: " + productName + " - Giá gốc: " + price);
            }
            // Phương thức tính giá giảm (ví dụ giảm 10%)
            public double getDiscountPrice() {
                return price * 0.9;
            }
        }
        static void run() {
            System.out.println("--- BÀI 2 ---");
            Product p = new Product();
            p.input();
            p.display();
            System.out.println("Giá sau giảm (10%): " + p.getDiscountPrice());
        }
    }

    // ================= BÀI 3: LỚP NHÂN VIÊN =================
    static class Bai3 {
        static class Employee {
            String id, name;
            double salary; // Kiểu dữ liệu salary là double

            public Employee(String id, String name, double salary) {
                this.id = id; this.name = name; this.salary = salary;
            }
            double calculateSalary() { return salary; } // Ví dụ đơn giản
            void displayInfo() {
                System.out.println("NV: " + name + " - Lương: " + calculateSalary());
            }
        }
        static void run() {
            System.out.println("--- BÀI 3 ---");
            Employee e = new Employee("NV01", "Nguyen Van A", 15000000);
            e.displayInfo();
        }
    }

    // ================= BÀI 4: ASSOCIATION (1 - n) =================
    static class Bai4 {
        static class Student {
            String id, name;
            public Student(String id, String name) { this.id = id; this.name = name; }
            @Override public String toString() { return name; }
        }
        static class ClassRoom {
            String className, room;
            // Quan hệ 1 lớp học có NHIỀU sinh viên (List)
            List<Student> students = new ArrayList<>();

            public ClassRoom(String className, String room) {
                this.className = className; this.room = room;
            }
            void addStudent(Student s) { students.add(s); }
            void showList() {
                System.out.println("Lớp " + className + " (" + room + ") có các SV: " + students);
            }
        }
        static void run() {
            System.out.println("--- BÀI 4 ---");
            ClassRoom cr = new ClassRoom("CNTT-K15", "P301");
            cr.addStudent(new Student("SV1", "Hung"));
            cr.addStudent(new Student("SV2", "Dung"));
            cr.showList();
        }
    }

    // ================= BÀI 5: KẾ THỪA (INHERITANCE) =================
    static class Bai5 {
        static class Person {
            String name; int age;
            public Person(String name, int age) { this.name = name; this.age = age; }
        }
        // Student kế thừa Person
        static class Student extends Person {
            double score;
            public Student(String name, int age, double score) {
                super(name, age);
                this.score = score;
            }
            void show() { System.out.println("Student: " + name + " - Điểm: " + score); }
        }
        // Teacher kế thừa Person
        static class Teacher extends Person {
            double salary;
            public Teacher(String name, int age, double salary) {
                super(name, age);
                this.salary = salary;
            }
            void show() { System.out.println("Teacher: " + name + " - Lương: " + salary); }
        }
        static void run() {
            System.out.println("--- BÀI 5 ---");
            new Student("An", 20, 8.5).show();
            new Teacher("Thay Ba", 40, 20000000).show();
        }
    }

    // ================= BÀI 6: QUẢN LÝ ĐƠN HÀNG =================
    static class Bai6 {
        static class Customer {
            String id, name;
            public Customer(String id, String name) { this.id = id; this.name = name; }
        }
        static class Product {
            String id; double price;
            public Product(String id, double price) { this.id = id; this.price = price; }
        }
        static class Order {
            String orderId;
            Customer customer; // 1 Đơn hàng thuộc về 1 Khách hàng
            List<Product> products = new ArrayList<>(); // 1 Đơn hàng có nhiều Sản phẩm

            public Order(String id, Customer c) { this.orderId = id; this.customer = c; }
            void addProduct(Product p) { products.add(p); }
            void show() {
                System.out.println("Đơn " + orderId + " của khách " + customer.name + " gồm " + products.size() + " SP.");
            }
        }
        static void run() {
            System.out.println("--- BÀI 6 ---");
            Customer c = new Customer("C1", "Chi Lan");
            Order o = new Order("ORD-999", c);
            o.addProduct(new Product("P1", 100));
            o.addProduct(new Product("P2", 200));
            o.show();
        }
    }

    // ================= BÀI 7: COMPOSITION (MẠNH) =================
    static class Bai7 {
        static class CPU { String type = "Intel i7"; }
        static class RAM { int size = 16; }
        
        static class Computer {
            // Composition: Computer tạo ra CPU và RAM. Nếu Computer hủy, CPU/RAM cũng mất.
            private CPU cpu;
            private RAM ram;

            public Computer() {
                this.cpu = new CPU(); // Khởi tạo bên trong
                this.ram = new RAM();
            }
            void showSpecs() {
                System.out.println("Computer có CPU: " + cpu.type + ", RAM: " + ram.size + "GB");
            }
        }
        static void run() {
            System.out.println("--- BÀI 7 (Composition) ---");
            Computer pc = new Computer();
            pc.showSpecs();
        }
    }

    // ================= BÀI 8: AGGREGATION (YẾU) =================
    static class Bai8 {
        static class Book {
            String title;
            public Book(String t) { title = t; }
        }
        static class Library {
            List<Book> books = new ArrayList<>();
            // Aggregation: Sách được tạo bên ngoài và thêm vào thư viện.
            // Nếu thư viện đóng cửa, sách vẫn còn.
            void addBook(Book b) { books.add(b); }
            void show() {
                System.out.print("Thư viện có: ");
                for(Book b : books) System.out.print("[" + b.title + "] ");
                System.out.println();
            }
        }
        static void run() {
            System.out.println("--- BÀI 8 (Aggregation) ---");
            Book b1 = new Book("Java Core");
            Book b2 = new Book("Spring Boot");
            Library lib = new Library();
            lib.addBook(b1);
            lib.addBook(b2);
            lib.show();
        }
    }

    // ================= BÀI 9: HỆ THỐNG BÁN HÀNG =================
    static class Bai9 {
        static class User { String username; }
        static class Admin extends User { void manage() { System.out.println("Admin quản lý..."); } }
        static class Customer extends User { 
            void buy() { System.out.println("Customer đang mua hàng..."); }
            // Customer tạo Order
            void createOrder() { System.out.println("-> Đã tạo 1 Order."); }
        }
        static class Product { String name = "Laptop"; }
        static class Order {
            List<Product> products = new ArrayList<>(); // Order chứa nhiều Product
        }
        static void run() {
            System.out.println("--- BÀI 9 ---");
            Customer c = new Customer();
            c.username = "khachhang123";
            c.buy();
            c.createOrder();
        }
    }

    // ================= BÀI 10: QUẢN LÝ KHÓA HỌC =================
    static class Bai10 {
        static class Course { String name; public Course(String n) { name = n; } }
        static class Student { String name; public Student(String n) { name = n; } }
        static class Teacher { String name; public Teacher(String n) { name = n; } }
        
        static class Enrollment {
            Student s; Course c;
            public Enrollment(Student s, Course c) { this.s = s; this.c = c; }
            void register() { System.out.println(s.name + " đã đăng ký khóa " + c.name); }
        }
        
        static void run() {
            System.out.println("--- BÀI 10 ---");
            Student s = new Student("Nam");
            Course c = new Course("Java Web");
            Teacher t = new Teacher("Co Hoa");
            
            // Sinh viên đăng ký khóa học thông qua Enrollment
            Enrollment e = new Enrollment(s, c);
            e.register();
            System.out.println("Giảng viên " + t.name + " dạy khóa " + c.name);
        }
    }
}