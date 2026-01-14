/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai1.pkg20;
import java.util.*;
/**
 *
 * @author admin
 */
public class Bai120 {

    /**
     * @param args the command line arguments
     */
static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU LAB 2.2 =========");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Đếm tần suất ký tự");
            System.out.println("3. Số Armstrong");
            System.out.println("4. Mảng con có tổng lớn nhất");
            System.out.println("5. Chuỗi Palindrome");
            System.out.println("6. Tìm phần tử xuất hiện nhiều nhất");
            System.out.println("7. Gộp 2 mảng và loại trùng");
            System.out.println("8. Kiểm tra mật khẩu mạnh");
            System.out.println("9. Sắp xếp mảng (không dùng sort)");
            System.out.println("10. Tìm số lớn thứ hai");
            System.out.println("11. Đếm số nguyên tố trong mảng");
            System.out.println("12. Tính tổng chữ số từng phần tử");
            System.out.println("13. Chuẩn hoá chuỗi");
            System.out.println("14. Đếm số từ trong chuỗi");
            System.out.println("15. Đảo ngược từng từ");
            System.out.println("16. Tìm cặp số tổng bằng K");
            System.out.println("17. Tách số chẵn – lẻ");
            System.out.println("18. Ma trận: Tổng đường chéo");
            System.out.println("19. Ma trận chuyển vị");
            System.out.println("20. Trò chơi đoán số");
            System.out.println("0. Thoát");
            System.out.print("Chọn bài (0-20): ");

            int choice = sc.nextInt();
            sc.nextLine(); // Xử lý trôi dòng

            switch (choice) {
                case 1: bai1(); break;
                case 2: bai2(); break;
                case 3: bai3(); break;
                case 4: bai4(); break;
                case 5: bai5(); break;
                case 6: bai6(); break;
                case 7: bai7(); break;
                case 8: bai8(); break;
                case 9: bai9(); break;
                case 10: bai10(); break;
                case 11: bai11(); break;
                case 12: bai12(); break;
                case 13: bai13(); break;
                case 14: bai14(); break;
                case 15: bai15(); break;
                case 16: bai16(); break;
                case 17: bai17(); break;
                case 18: bai18(); break;
                case 19: bai19(); break;
                case 20: bai20(); break;
                case 0: System.exit(0);
                default: System.out.println("Chọn sai, vui lòng chọn lại!");
            }
            System.out.println("\n---------------------------------");
            System.out.println("Ấn Enter để tiếp tục...");
            sc.nextLine();
        }
    }

    // --- Bài 1: Quản lý sinh viên ---
    static class SinhVien {
        String ma, ten;
        double diem;
        public SinhVien(String ma, String ten, double diem) {
            this.ma = ma; this.ten = ten; this.diem = diem;
        }
    }
    static void bai1() {
        System.out.print("Nhập số lượng SV: ");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<SinhVien> list = new ArrayList<>();
        double tongDiem = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("SV thứ " + (i+1));
            System.out.print("Mã: "); String ma = sc.nextLine();
            System.out.print("Tên: "); String ten = sc.nextLine();
            System.out.print("Điểm: "); double diem = sc.nextDouble();
            sc.nextLine();
            list.add(new SinhVien(ma, ten, diem));
            tongDiem += diem;
        }

        System.out.println("Điểm TB lớp: " + (tongDiem/n));
        System.out.println("Danh sách Đạt/Không đạt:");
        for (SinhVien sv : list) {
            System.out.println(sv.ten + " - " + sv.diem + " -> " + (sv.diem >= 5 ? "Đạt" : "Không đạt"));
        }
    }

    // --- Bài 2: Tần suất ký tự ---
    static void bai2() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println("Tần suất: " + map);
    }

    // --- Bài 3: Số Armstrong ---
    static void bai3() {
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int temp = n, sum = 0, digits = String.valueOf(n).length();
        while (temp > 0) {
            int last = temp % 10;
            sum += Math.pow(last, digits);
            temp /= 10;
        }
        if (sum == n) System.out.println(n + " là số Armstrong");
        else System.out.println(n + " không phải số Armstrong");
    }

    // --- Bài 4: Mảng con tổng lớn nhất (Kadane's Algorithm) ---
    static void bai4() {
        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập mảng:");
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        System.out.println("Tổng mảng con lớn nhất: " + maxSoFar);
    }

    // --- Bài 5: Palindrome ---
    static void bai5() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println(s.equals(rev) ? "Là Palindrome" : "Không phải Palindrome");
    }

    // --- Bài 6: Phần tử xuất hiện nhiều nhất ---
    static void bai6() {
        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int maxCount = 0, res = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                res = entry.getKey();
            }
        }
        System.out.println("Số " + res + " xuất hiện " + maxCount + " lần.");
    }

    // --- Bài 7: Gộp mảng, loại trùng ---
    static void bai7() {
        System.out.print("Nhập n1: "); int n1 = sc.nextInt();
        int[] a = new int[n1];
        for(int i=0; i<n1; i++) a[i] = sc.nextInt();

        System.out.print("Nhập n2: "); int n2 = sc.nextInt();
        int[] b = new int[n2];
        for(int i=0; i<n2; i++) b[i] = sc.nextInt();

        Set<Integer> set = new LinkedHashSet<>(); // Giữ thứ tự thêm vào
        for(int x : a) set.add(x);
        for(int x : b) set.add(x);
        System.out.println("Kết quả: " + set);
    }

    // --- Bài 8: Mật khẩu mạnh ---
    static void bai8() {
        System.out.print("Nhập mật khẩu: ");
        String pass = sc.nextLine();
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;':,./<>?";

        if (pass.length() < 8) {
            System.out.println("Không hợp lệ: Quá ngắn."); return;
        }
        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.contains(String.valueOf(c))) hasSpecial = true;
        }

        if (hasUpper && hasLower && hasDigit && hasSpecial) 
            System.out.println("Mật khẩu mạnh!");
        else 
            System.out.println("Mật khẩu yếu (Thiếu thành phần yêu cầu).");
    }

    // --- Bài 9: Sắp xếp (Bubble Sort) ---
    static void bai9() {
        System.out.print("Nhập n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j]; a[j] = a[j+1]; a[j+1] = temp;
                }
            }
        }
        System.out.println("Mảng tăng dần: " + Arrays.toString(a));
    }

    // --- Bài 10: Số lớn thứ hai ---
    static void bai10() {
        System.out.print("Nhập n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = sc.nextInt();

        if (n < 2) { System.out.println("Mảng cần ít nhất 2 phần tử"); return; }
        
        // Sắp xếp giảm dần hoặc tìm thủ công
        Arrays.sort(a);
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] != a[n - 1]) {
                System.out.println("Số lớn thứ hai: " + a[i]);
                return;
            }
        }
        System.out.println("Không tồn tại số lớn thứ hai.");
    }

    // --- Bài 11: Đếm số nguyên tố ---
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }
    static void bai11() {
        System.out.print("Nhập n: "); int n = sc.nextInt();
        int[] a = new int[n];
        int count = 0;
        System.out.print("Các số NT: ");
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            if (isPrime(a[i])) {
                System.out.print(a[i] + " ");
                count++;
            }
        }
        System.out.println("\nTổng cộng: " + count + " số.");
    }

    // --- Bài 12: Tổng chữ số ---
    static void bai12() {
        System.out.print("Nhập n: "); int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            int sum = 0, temp = Math.abs(num);
            while(temp > 0) { sum += temp % 10; temp /= 10; }
            System.out.println(num + " -> Tổng: " + sum);
        }
    }

    // --- Bài 13: Chuẩn hóa chuỗi ---
    static void bai13() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine().trim();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
              .append(w.substring(1).toLowerCase()).append(" ");
        }
        System.out.println("Chuẩn hóa: " + sb.toString().trim());
    }

    // --- Bài 14: Đếm số từ ---
    static void bai14() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine().trim();
        if (s.isEmpty()) System.out.println("Số từ: 0");
        else System.out.println("Số từ: " + s.split("\\s+").length);
    }

    // --- Bài 15: Đảo ngược từng từ ---
    static void bai15() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();
        String[] words = s.split(" ");
        for (String w : words) {
            System.out.print(new StringBuilder(w).reverse().toString() + " ");
        }
        System.out.println();
    }

    // --- Bài 16: Cặp số tổng K ---
    static void bai16() {
        System.out.print("Nhập n: "); int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = sc.nextInt();
        System.out.print("Nhập K: "); int k = sc.nextInt();

        System.out.println("Các cặp có tổng = " + k + ":");
        // Cách đơn giản nhất: 2 vòng lặp. Để không trùng cặp (i,j) và (j,i), ta cho j chạy từ i+1
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == k) {
                    System.out.println("(" + a[i] + ", " + a[j] + ")");
                }
            }
        }
    }

    // --- Bài 17: Tách chẵn lẻ ---
    static void bai17() {
        System.out.print("Nhập n: "); int n = sc.nextInt();
        ArrayList<Integer> chan = new ArrayList<>();
        ArrayList<Integer> le = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            if (x % 2 == 0) chan.add(x); else le.add(x);
        }
        System.out.println("Mảng Chẵn: " + chan);
        System.out.println("Mảng Lẻ: " + le);
    }

    // --- Bài 18: Ma trận đường chéo ---
    static void bai18() {
        System.out.print("Nhập kích thước n: "); int n = sc.nextInt();
        int[][] mt = new int[n][n];
        System.out.println("Nhập ma trận:");
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++) mt[i][j] = sc.nextInt();
        
        int chinh = 0, phu = 0;
        for(int i=0; i<n; i++) {
            chinh += mt[i][i];
            phu += mt[i][n-1-i];
        }
        System.out.println("Tổng chéo chính: " + chinh);
        System.out.println("Tổng chéo phụ: " + phu);
    }

    // --- Bài 19: Ma trận chuyển vị ---
    static void bai19() {
        System.out.print("Nhập dòng r: "); int r = sc.nextInt();
        System.out.print("Nhập cột c: "); int c = sc.nextInt();
        int[][] mt = new int[r][c];
        System.out.println("Nhập ma trận:");
        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++) mt[i][j] = sc.nextInt();

        System.out.println("Chuyển vị:");
        for(int j=0; j<c; j++) {
            for(int i=0; i<r; i++) {
                System.out.print(mt[i][j] + " ");
            }
            System.out.println();
        }
    }

    // --- Bài 20: Đoán số ---
    static void bai20() {
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;
        int count = 0;
        System.out.println("Máy đã nghĩ 1 số từ 1-100. Bạn có 7 lần đoán.");
        
        while (count < 7) {
            System.out.print("Lần " + (count+1) + ": ");
            int guess = sc.nextInt();
            count++;
            if (guess == target) {
                System.out.println("Chúc mừng! Bạn đoán đúng.");
                return;
            } else if (guess < target) System.out.println("Số cần tìm LỚN hơn.");
            else System.out.println("Số cần tìm NHỎ hơn.");
        }
        System.out.println("Thua rồi! Số đúng là: " + target);
    }
    
}
