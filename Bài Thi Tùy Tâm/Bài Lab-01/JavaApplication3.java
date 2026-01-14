/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Bài 6: In 1-100 ---
        System.out.println("--- Bài 6 ---");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // Xuống dòng

        // --- Bài 7: Tổng 1 đến n ---
        System.out.println("\n--- Bài 7 ---");
        System.out.print("Nhập n: ");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Tổng từ 1 đến " + n + " là: " + sum);

        // --- Bài 8: Bảng cửu chương ---
        System.out.println("\n--- Bài 8 ---");
        System.out.print("Nhập n (1-9): ");
        int cuuChuong = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", cuuChuong, i, cuuChuong * i);
        }

        // --- Bài 9: Đếm số chữ số ---
        System.out.println("\n--- Bài 9 ---");
        System.out.print("Nhập số nguyên dương: ");
        int number = scanner.nextInt();
        // Cách nhanh nhất là chuyển sang chuỗi để lấy độ dài
        String strNum = String.valueOf(number);
        System.out.println("Số chữ số: " + strNum.length());

        // --- Bài 10: Số nguyên tố ---
        System.out.println("\n--- Bài 10 ---");
        System.out.print("Nhập số cần kiểm tra nguyên tố: ");
        int p = scanner.nextInt();
        boolean isPrime = true;
        if (p < 2) isPrime = false;
        else {
            for (int i = 2; i <= Math.sqrt(p); i++) {
                if (p % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) System.out.println(p + " là số nguyên tố.");
        else System.out.println(p + " không phải số nguyên tố.");
    }
    
    
}
