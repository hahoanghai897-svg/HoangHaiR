/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Bài 1: In ra màn hình ---
        System.out.println("--- Bài 1 ---");
        System.out.println("Xin\nchào Java!");
        System.out.println("Tôi\nđang học lập trình Java.");

        // --- Bài 2: Tổng hai số ---
        System.out.println("\n--- Bài 2 ---");
        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();
        System.out.println("Tổng: " + (a + b));

        // --- Bài 3: Chẵn lẻ ---
        System.out.println("\n--- Bài 3 ---");
        System.out.print("Nhập số cần kiểm tra: ");
        int n = scanner.nextInt();
        if (n % 2 == 0) {
            System.out.println(n + " là số chẵn.");
        } else {
            System.out.println(n + " là số lẻ.");
        }

        // --- Bài 4: HCN ---
        System.out.println("\n--- Bài 4 ---");
        System.out.print("Nhập chiều dài: ");
        double dai = scanner.nextDouble();
        System.out.print("Nhập chiều rộng: ");
        double rong = scanner.nextDouble();
        System.out.println("Chu vi: " + (dai + rong) * 2);
        System.out.println("Diện tích: " + (dai * rong));

        // --- Bài 5: So sánh ---
        System.out.println("\n--- Bài 5 ---");
        System.out.print("Nhập số x: ");
        double x = scanner.nextDouble();
        System.out.print("Nhập số y: ");
        double y = scanner.nextDouble();
        if (x > y) {
            System.out.println("Số lớn hơn là: " + x);
        } else if (y > x) {
            System.out.println("Số lớn hơn là: " + y);
        } else {
            System.out.println("Hai số bằng nhau.");
        }
    }
    }
    

