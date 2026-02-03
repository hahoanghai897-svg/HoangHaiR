/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab09_polymorphism_full; // Giữ nguyên hoặc xóa dòng này nếu bạn không tạo package

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab09_Polymorphism_Full {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 09 (ĐA HÌNH - POLYMORPHISM) =========");
            System.out.println("1.  Bài 1: Account (Admin, Student, Guest)");
            System.out.println("2.  Bài 2: Report (PDF, Excel, Word)");
            System.out.println("3.  Bài 3: Login (Password, Google, Facebook)");
            System.out.println("4.  Bài 4: Shipping (Standard, Express, SameDay)");
            System.out.println("5.  Bài 5: Printer (Laser, Ink, PDF)");
            System.out.println("6.  Bài 6: Alert (Warning, Error, Success)");
            System.out.println("7.  Bài 7: Nhân viên (FullTime, PartTime)");
            System.out.println("8.  Bài 8: Thanh toán (Tiền mặt, Thẻ)");
            System.out.println("10. Bài 10: Động vật (Chó, Chim - Interface CoTheBay)");
            System.out.println("0.  Thoát");
            System.out.print("Chọn bài: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên!");
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
                case 10: Bai10.run(); break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Chọn sai, vui lòng chọn lại!");
            }
            System.out.println("\nẤn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    // ================= BÀI 1: ACCOUNT SYSTEM =================
    static class Bai1 {
        static abstract class Account {
            String username;
            public Account(String u) { username = u; }
            abstract String getRole();
        }
        static class AdminAccount extends Account {
            public AdminAccount(String u) { super(u); }
            @Override String getRole() { return "ADMIN"; }
        }
        static class StudentAccount extends Account {
            public StudentAccount(String u) { super(u); }
            @Override String getRole() { return "STUDENT"; }
        }
        static class GuestAccount extends Account {
            public GuestAccount(String u) { super(u); }
            @Override String getRole() { return "GUEST"; }
        }
        static void run() {
            System.out.println("--- BÀI 1 ---");
            List<Account> accounts = new ArrayList<>();
            accounts.add(new AdminAccount("admin_user"));
            accounts.add(new StudentAccount("student_123"));
            accounts.add(new GuestAccount("guest_01"));

            for (Account acc : accounts) {
                System.out.println("User: " + acc.username + " - Role: " + acc.getRole());
            }
        }
    }

    // ================= BÀI 2: REPORT SYSTEM =================
    static class Bai2 {
        static abstract class Report {
            String title;
            public Report(String t) { title = t; }
            abstract void generate();
        }
        static class PDFReport extends Report {
            public PDFReport(String t) { super(t); }
            @Override void generate() { System.out.println("Generating PDF: " + title + ".pdf"); }
        }
        static class ExcelReport extends Report {
            public ExcelReport(String t) { super(t); }
            @Override void generate() { System.out.println("Generating Excel: " + title + ".xlsx"); }
        }
        static class WordReport extends Report {
            public WordReport(String t) { super(t); }
            @Override void generate() { System.out.println("Generating Word: " + title + ".docx"); }
        }
        static void run() {
            System.out.println("--- BÀI 2 ---");
            List<Report> reports = new ArrayList<>();
            reports.add(new PDFReport("BaoCaoThang"));
            reports.add(new ExcelReport("BangLuong"));
            for (Report r : reports) r.generate();
        }
    }

    // ================= BÀI 3: LOGIN METHOD =================
    static class Bai3 {
        static abstract class LoginMethod {
            String userId;
            public LoginMethod(String id) { userId = id; }
            abstract void login();
        }
        static class PasswordLogin extends LoginMethod {
            public PasswordLogin(String id) { super(id); }
            @Override void login() { System.out.println("User " + userId + " logged in with Password."); }
        }
        static class GoogleLogin extends LoginMethod {
            public GoogleLogin(String id) { super(id); }
            @Override void login() { System.out.println("User " + userId + " logged in with Google OAuth."); }
        }
        static class FacebookLogin extends LoginMethod {
            public FacebookLogin(String id) { super(id); }
            @Override void login() { System.out.println("User " + userId + " logged in with Facebook."); }
        }
        static void run() {
            System.out.println("--- BÀI 3 ---");
            new PasswordLogin("user01").login();
            new GoogleLogin("user02@gmail.com").login();
        }
    }

    // ================= BÀI 4: SHIPPING SERVICE =================
    static class Bai4 {
        static abstract class ShippingService {
            double distance;
            double weight;
            public ShippingService(double d, double w) { distance = d; weight = w; }
            abstract double calculateFee();
        }
        static class StandardShipping extends ShippingService {
            public StandardShipping(double d, double w) { super(d, w); }
            @Override double calculateFee() { return distance * 1000 + weight * 500; }
        }
        static class ExpressShipping extends ShippingService {
            public ExpressShipping(double d, double w) { super(d, w); }
            @Override double calculateFee() { return distance * 2000 + weight * 1000; }
        }
        static class SameDayShipping extends ShippingService {
            public SameDayShipping(double d, double w) { super(d, w); }
            @Override double calculateFee() { return distance * 5000 + weight * 2000; }
        }
        static void run() {
            System.out.println("--- BÀI 4 ---");
            ShippingService s1 = new StandardShipping(10, 2);
            ShippingService s2 = new SameDayShipping(10, 2);
            System.out.printf("Standard Fee: %.0f\n", s1.calculateFee());
            System.out.printf("SameDay Fee: %.0f\n", s2.calculateFee());
        }
    }

    // ================= BÀI 5: PRINTER =================
    static class Bai5 {
        static abstract class Printer {
            String name;
            public Printer(String n) { name = n; }
            abstract void print();
        }
        static class LaserPrinter extends Printer {
            public LaserPrinter(String n) { super(n); }
            @Override void print() { System.out.println(name + ": Printing with laser beam..."); }
        }
        static class InkPrinter extends Printer {
            public InkPrinter(String n) { super(n); }
            @Override void print() { System.out.println(name + ": Spraying ink..."); }
        }
        static class PDFPrinter extends Printer {
            public PDFPrinter(String n) { super(n); }
            @Override void print() { System.out.println(name + ": Saving to PDF file..."); }
        }
        static void run() {
            System.out.println("--- BÀI 5 ---");
            new LaserPrinter("HP LaserJet").print();
            new PDFPrinter("Adobe PDF").print();
        }
    }

    // ================= BÀI 6: SYSTEM ALERT =================
    static class Bai6 {
        static abstract class SystemAlert {
            String message;
            public SystemAlert(String m) { message = m; }
            abstract void show();
        }
        static class WarningAlert extends SystemAlert {
            public WarningAlert(String m) { super(m); }
            @Override void show() { System.out.println("[WARNING] " + message); }
        }
        static class ErrorAlert extends SystemAlert {
            public ErrorAlert(String m) { super(m); }
            @Override void show() { System.err.println("[ERROR] " + message); }
        }
        static class SuccessAlert extends SystemAlert {
            public SuccessAlert(String m) { super(m); }
            @Override void show() { System.out.println("[SUCCESS] " + message); }
        }
        static void run() {
            System.out.println("--- BÀI 6 ---");
            new SuccessAlert("Operation completed").show();
            new ErrorAlert("Connection failed").show();
        }
    }

    // ================= BÀI 7: NHÂN VIÊN (ABSTRACT) =================
    static class Bai7 {
        static abstract class NhanVien {
            protected String maNV, tenNV;
            public NhanVien(String ma, String ten) { maNV = ma; tenNV = ten; }
            public abstract double tinhLuong();
            public void hienThi() {
                System.out.printf("%s - %s - Lương: %.0f\n", maNV, tenNV, tinhLuong());
            }
        }
        static class NhanVienFullTime extends NhanVien {
            private double luongCoBan, thuong;
            public NhanVienFullTime(String ma, String ten, double luong, double thuong) {
                super(ma, ten); this.luongCoBan = luong; this.thuong = thuong;
            }
            @Override public double tinhLuong() { return luongCoBan + thuong; }
        }
        static class NhanVienPartTime extends NhanVien {
            private int soGioLam;
            private double luongGio;
            public NhanVienPartTime(String ma, String ten, int gio, double luong) {
                super(ma, ten); this.soGioLam = gio; this.luongGio = luong;
            }
            @Override public double tinhLuong() { return soGioLam * luongGio; }
        }
        static void run() {
            System.out.println("--- BÀI 7 ---");
            List<NhanVien> list = new ArrayList<>();
            list.add(new NhanVienFullTime("NV01", "Nguyen Van A", 10000000, 2000000));
            list.add(new NhanVienPartTime("NV02", "Tran Thi B", 50, 30000));
            for (NhanVien nv : list) nv.hienThi();
        }
    }

    // ================= BÀI 8: THANH TOÁN (INTERFACE + ABSTRACT) =================
    static class Bai8 {
        interface ThanhToan {
            double thanhToan(double soTien);
        }
        static abstract class PhuongThucThanhToan {
            protected String tenPhuongThuc;
            public PhuongThucThanhToan(String ten) { tenPhuongThuc = ten; }
            public abstract double phiGiaoDich(double soTien);
            public void hienThi() { System.out.print("Phương thức: " + tenPhuongThuc + " | "); }
        }
        static class ThanhToanTienMat extends PhuongThucThanhToan implements ThanhToan {
            public ThanhToanTienMat() { super("Tiền mặt"); }
            @Override public double phiGiaoDich(double soTien) { return 0; }
            @Override public double thanhToan(double soTien) { return soTien + phiGiaoDich(soTien); }
        }
        static class ThanhToanThe extends PhuongThucThanhToan implements ThanhToan {
            public ThanhToanThe() { super("Thẻ tín dụng"); }
            @Override public double phiGiaoDich(double soTien) { return soTien * 0.02; } // Phí 2%
            @Override public double thanhToan(double soTien) { return soTien + phiGiaoDich(soTien); }
        }
        static void run() {
            System.out.println("--- BÀI 8 ---");
            ThanhToan[] methods = { new ThanhToanTienMat(), new ThanhToanThe() };
            double tienHang = 500000;
            System.out.printf("Tiền hàng: %.0f\n", tienHang);

            for (ThanhToan tt : methods) {
                if (tt instanceof PhuongThucThanhToan) ((PhuongThucThanhToan) tt).hienThi();
                System.out.printf("Tổng trả: %.0f\n", tt.thanhToan(tienHang));
            }
        }
    }

    // ================= BÀI 10: ĐỘNG VẬT (INSTANCEOF) =================
    static class Bai10 {
        interface CoTheBay { void bay(); }
        static abstract class DongVat {
            protected String ten;
            public DongVat(String t) { ten = t; }
            public abstract void keu();
        }
        static class Cho extends DongVat {
            public Cho(String t) { super(t); }
            @Override public void keu() { System.out.println(ten + ": Gâu gâu"); }
        }
        static class Chim extends DongVat implements CoTheBay {
            public Chim(String t) { super(t); }
            @Override public void keu() { System.out.println(ten + ": Chíp chíp"); }
            @Override public void bay() { System.out.println(ten + " đang bay lượn..."); }
        }
        static void run() {
            System.out.println("--- BÀI 10 ---");
            List<DongVat> ds = new ArrayList<>();
            ds.add(new Cho("Lu"));
            ds.add(new Chim("Vàng Anh"));

            for (DongVat dv : ds) {
                dv.keu();
                if (dv instanceof CoTheBay) {
                    ((CoTheBay) dv).bay();
                }
            }
        }
    }
}