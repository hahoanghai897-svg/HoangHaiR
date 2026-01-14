/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5; // Giữ nguyên package của bạn

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class JavaApplication5 { // Class chính trùng tên file

    // --- Bài 14: Hàm kiểm tra số nguyên tố ---
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Class Sinh Viên cho Bài 15 (Class tĩnh bên trong)
    static class SinhVien {
        String ten;
        double diem;

        public SinhVien(String ten, double diem) {
            this.ten = ten;
            this.diem = diem;
        }

        public String xepLoai() {
            if (diem >= 8.0) return "Giỏi";
            if (diem >= 6.5) return "Khá";
            if (diem >= 5.0) return "Trung bình";
            return "Yếu";
        }
    }

    // Hàm Main chính để chạy chương trình
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ================= CHẠY BÀI 14 =================
        System.out.println("--- Bài 14: Số nguyên tố 1-100 ---");
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        // ================= CHẠY BÀI 15 =================
        System.out.println("--- Bài 15: Quản lý sinh viên ---");
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Xử lý trôi dòng (nuốt phím Enter thừa)

        ArrayList<SinhVien> danhSach = new ArrayList<>();

        // Nhập danh sách
        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhập thông tin SV thứ " + (i + 1) + " ---");
            System.out.print("Tên: ");
            String ten = scanner.nextLine();
            
            System.out.print("Điểm: ");
            double diem = scanner.nextDouble();
            scanner.nextLine(); // Xử lý trôi dòng sau khi nhập số
            
            danhSach.add(new SinhVien(ten, diem));
        }

        // Xử lý thống kê (Chỉ làm khi danh sách có sinh viên)
        if (danhSach.isEmpty()) {
            System.out.println("\nChưa có dữ liệu sinh viên nào!");
        } else {
            double tongDiem = 0;
            SinhVien svMax = danhSach.get(0); // Giả sử người đầu tiên cao nhất

            System.out.println("\n--- KẾT QUẢ ---");
            // In tiêu đề dạng bảng cho đẹp
            System.out.printf("%-20s %-10s %-10s\n", "Tên", "Điểm", "Xếp loại");
            
            for (SinhVien sv : danhSach) {
                System.out.printf("%-20s %-10.1f %-10s\n", sv.ten, sv.diem, sv.xepLoai());
                tongDiem += sv.diem;
                
                // Tìm max
                if (sv.diem > svMax.diem) {
                    svMax = sv;
                }
            }

            System.out.println("----------------------------------------");
            System.out.printf("Điểm trung bình cả lớp: %.2f\n", (tongDiem / n));
            System.out.println("Sinh viên điểm cao nhất: " + svMax.ten + " (" + svMax.diem + ")");
        }
    }
}