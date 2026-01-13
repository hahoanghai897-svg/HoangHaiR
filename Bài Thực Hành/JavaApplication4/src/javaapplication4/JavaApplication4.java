/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Bài 11 & 12: Mảng ---
        System.out.println("--- Bài 11 & 12 ---");
        System.out.print("Nhập số phần tử mảng n: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Tính toán
        int sum = 0;
        int max = arr[0];
        int min = arr[0];

        for (int x : arr) {
            sum += x;
            if (x > max) max = x;
            if (x < min) min = x;
        }
        System.out.println("Tổng mảng: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        // --- Bài 13: Đảo ngược chuỗi ---
        System.out.println("\n--- Bài 13 ---");
        scanner.nextLine(); // Xử lý trôi lệnh (do dùng nextInt ở trên)
        System.out.print("Nhập chuỗi cần đảo: ");
        String text = scanner.nextLine();
        
        // Sử dụng StringBuilder để đảo ngược
        StringBuilder sb = new StringBuilder(text);
        System.out.println("Chuỗi đảo ngược: " + sb.reverse().toString());
    }
    
    
}
