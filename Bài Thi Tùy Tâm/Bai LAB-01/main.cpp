#include <iostream>
#include <vector>
#include <cmath>
#include <string>
#include <algorithm>
#include <sstream>
#include <iomanip>

using namespace std;

// --- Khai báo cấu trúc Sinh Viên cho Bài 6 ---
struct SinhVien {
    string maSV;
    string hoTen;
    string lop;
    float diem;
};

// --- Các hàm hỗ trợ tính toán ---
long long giaiThua(int n) {
    long long gt = 1;
    for (int i = 2; i <= n; i++) gt *= i;
    return gt;
}

bool laSoChinhPhuong(int n) {
    if (n < 0) return false;
    int can = sqrt(n);
    return can * can == n;
}

// ================= BÀI 1: TỔNG CHUỖI SỐ =================
void Bai1() {
    cout << "\n--- BAI 1: TINH TONG ---\n";
    int n;
    double x;
    cout << "Nhap n: "; cin >> n;
    cout << "Nhap x: "; cin >> x;

    // 1. S = 1 + 1/2 + ... + 1/n
    double s1 = 0;
    for (int i = 1; i <= n; i++) s1 += 1.0 / i;
    cout << "1. S = " << s1 << endl;

    // 2. S = 1/2 + 1/4 + ... + 1/2n
    double s2 = 0;
    for (int i = 1; i <= n; i++) s2 += 1.0 / (2 * i);
    cout << "2. S = " << s2 << endl;

    // 3. S = 1 + 3 + 5 + ... + (2n+1)
    long long s3 = 0;
    for (int i = 0; i <= n; i++) s3 += (2 * i + 1);
    cout << "3. S = " << s3 << endl;

    // 4. S = 1 + x + x^2 + ... + x^n
    double s4 = 0;
    for (int i = 0; i <= n; i++) s4 += pow(x, i);
    cout << "4. S = " << s4 << endl;

    // 5. S = 1 - x^2/2! + x^4/4! ... (Cos x)
    double s5 = 1;
    for (int i = 1; i <= n; i++) {
        double term = pow(x, 2 * i) / giaiThua(2 * i);
        if (i % 2 == 1) s5 -= term; else s5 += term;
    }
    cout << "5. S = " << s5 << endl;

    // 6. S = 1 + x/1! + x^2/2! ... (e^x)
    double s6 = 0;
    for (int i = 0; i <= n; i++) s6 += pow(x, i) / giaiThua(i);
    cout << "6. S = " << s6 << endl;
}

// ================= BÀI 2: MẢNG 1 CHIỀU =================
void Bai2() {
    cout << "\n--- BAI 2: MANG 1 CHIEU ---\n";
    int n;
    cout << "Nhap so phan tu n: "; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cout << "a[" << i << "] = "; cin >> a[i];
    }

    cout << "2. Mang vua nhap: ";
    for (int x : a) cout << x << " ";
    cout << endl;

    int tong = 0, demAm = 0;
    int maxVal = a[0], minVal = a[0];
    double tongSCP = 0; int demSCP = 0;

    cout << "7. Cac so chinh phuong: ";
    for (int x : a) {
        tong += x;
        if (x < 0) demAm++;
        if (x > maxVal) maxVal = x;
        if (x < minVal) minVal = x;
        if (laSoChinhPhuong(x)) {
            cout << x << " ";
            tongSCP += x;
            demSCP++;
        }
    }
    cout << endl;

    cout << "3. Tong cac phan tu: " << tong << endl;
    cout << "4. So luong so am: " << demAm << endl;
    if (demSCP > 0) cout << "6. TB cong SCP: " << tongSCP / demSCP << endl;
    else cout << "6. Khong co so chinh phuong de tinh TB." << endl;
    
    cout << "8. Max: " << maxVal << endl;
    cout << "9. Min: " << minVal << endl;
    cout << "10. Cac so trong khoang (" << minVal << ", " << maxVal << "): ";
    for (int x : a) {
        if (x > minVal && x < maxVal) cout << x << " ";
    }
    cout << endl;
}

// ================= BÀI 3: MA TRẬN =================
void Bai3() {
    cout << "\n--- BAI 3: MA TRAN ---\n";
    int n;
    cout << "Nhap cap ma tran n: "; cin >> n;
    vector<vector<int>> mat(n, vector<int>(n));
    long long tong = 0;

    cout << "Nhap ma tran:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> mat[i][j];
            tong += mat[i][j];
        }
    }

    cout << "2. Ma tran:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) printf("%4d", mat[i][j]);
        cout << endl;
    }
    cout << "3. Tong cac phan tu: " << tong << endl;

    int k;
    cout << "Nhap k (0 <= k < " << n << "): "; cin >> k;
    if (k >= 0 && k < n) {
        int maxRow = mat[k][0];
        for (int j = 1; j < n; j++) if (mat[k][j] > maxRow) maxRow = mat[k][j];
        cout << "4. Max hang " << k << ": " << maxRow << endl;

        int countNegCol = 0;
        for (int i = 0; i < n; i++) if (mat[i][k] < 0) countNegCol++;
        cout << "5. So am cot " << k << ": " << countNegCol << endl;
    }

    cout << "6. SCP tren duong cheo chinh: ";
    for (int i = 0; i < n; i++) if (laSoChinhPhuong(mat[i][i])) cout << mat[i][i] << " ";
    cout << endl;

    double sumSub = 0; int countSub = 0;
    for (int i = 0; i < n; i++) {
        int val = mat[i][n - 1 - i];
        if (val != 0 && 150 % val == 0) { // Uoc cua 150
            sumSub += val; countSub++;
        }
    }
    if (countSub > 0) cout << "7. TB cong uoc cua 150 tren cheo phu: " << sumSub / countSub << endl;

    cout << "8. Sap xep cac hang giam dan:\n";
    for (int i = 0; i < n; i++) {
        sort(mat[i].rbegin(), mat[i].rend()); // sort descending
        for (int x : mat[i]) printf("%4d", x);
        cout << endl;
    }
}

// ================= BÀI 4: XỬ LÝ CHUỖI =================
void Bai4() {
    cout << "\n--- BAI 4: XU LY CHUOI ---\n";
    cin.ignore(); 
    string s;
    cout << "Nhap chuoi: "; getline(cin, s);

    int chuCai = 0, chuSo = 0, tongSo = 0;
    for (char c : s) {
        if (isalpha(c)) chuCai++;
        if (isdigit(c)) {
            chuSo++;
            tongSo += (c - '0');
        }
    }
    cout << "1. So chu cai: " << chuCai << endl;
    cout << "2. So chu so: " << chuSo << endl;
    cout << "8. Tong cac chu so: " << tongSo << endl;

    // 3 & 5 Replace
    string sCopy = s;
    size_t pos = sCopy.find("gmail.com");
    if (pos != string::npos) sCopy.insert(pos, "@");
    cout << "3. Chen @: " << sCopy << endl;

    sCopy = s;
    while ((pos = sCopy.find("gmail.com")) != string::npos) {
        sCopy.replace(pos, 9, "ctech.edu.vn");
    }
    cout << "5. Thay the: " << sCopy << endl;

    // 4. Insert '-' between evens
    string s4 = "";
    for (int i = 0; i < s.length(); i++) {
        s4 += s[i];
        if (i < s.length() - 1 && isdigit(s[i]) && isdigit(s[i + 1])) {
            if ((s[i] - '0') % 2 == 0 && (s[i + 1] - '0') % 2 == 0) {
                s4 += '-';
            }
        }
    }
    cout << "4. Chen '-': " << s4 << endl;

    // 6, 9, 11 Words processing
    stringstream ss(s);
    string word, maxWord = "", s9 = "";
    cout << "6. Cac tu: ";
    while (ss >> word) {
        cout << "[" << word << "] ";
        if (word.length() > maxWord.length()) maxWord = word;
        
        // Cap dau tu (9)
        word[0] = toupper(word[0]);
        s9 += word + " ";
    }
    cout << endl;
    cout << "9. Hoa dau tu: " << s9 << endl;
    cout << "11. Tu dai nhat: " << maxWord << endl;

    // 7. Dao hoa thuong
    string s7 = s;
    for (char &c : s7) {
        if (isupper(c)) c = tolower(c);
        else if (islower(c)) c = toupper(c);
    }
    cout << "7. Dao hoa/thuong: " << s7 << endl;

    // 10. Dao nguoc
    string s10 = s;
    reverse(s10.begin(), s10.end());
    cout << "10. Dao nguoc: " << s10 << endl;
}

// ================= BÀI 5: MẢNG ĐỘNG (VECTOR) =================
void Bai5() {
    cout << "\n--- BAI 5: MANG DONG ---\n";
    int n;
    cout << "Nhap so phan tu: "; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cout << "a[" << i << "] = "; cin >> a[i];
    }

    cout << "2. Hien thi: ";
    int minVal = a[0];
    long long sum = 0;
    int maxVal = a[0];

    for (int x : a) {
        cout << x << " ";
        if (x < minVal) minVal = x;
        if (x > maxVal) maxVal = x;
        sum += x;
    }
    cout << endl;
    cout << "3. Min: " << minVal << endl;
    cout << "4. Tong: " << sum << endl;

    int k, x;
    cout << "5. Nhap k de xoa: "; cin >> k;
    if (k >= 0 && k < a.size()) a.erase(a.begin() + k);
    
    cout << "6. Nhap x va k de them: "; cin >> x >> k;
    if (k >= 0 && k <= a.size()) a.insert(a.begin() + k + 1, x); // Sau k
    else a.push_back(x);

    sort(a.rbegin(), a.rend());
    cout << "7. Sap xep giam: ";
    for (int val : a) cout << val << " ";
    cout << endl;

    // 8. Xoa max
    // maxVal co the thay doi, tim lai
    if (!a.empty()) {
        maxVal = a[0]; // Do da sap xep giam dan
        // Xoa tat ca so max
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a[i] == maxVal) a.erase(a.begin() + i);
        }
        cout << "8. Sau khi xoa max: ";
        for (int val : a) cout << val << " ";
        cout << endl;
    }
}

// ================= BÀI 6: QUẢN LÝ SINH VIÊN =================
void nhapDS(vector<SinhVien> &ds) {
    int n; cout << "Nhap so luong SV: "; cin >> n;
    for (int i = 0; i < n; i++) {
        SinhVien sv;
        cout << "SV thu " << i + 1 << endl;
        cin.ignore();
        cout << "Ma SV: "; getline(cin, sv.maSV);
        cout << "Ho ten: "; getline(cin, sv.hoTen);
        cout << "Lop: "; getline(cin, sv.lop);
        cout << "Diem: "; cin >> sv.diem;
        ds.push_back(sv);
    }
}

void hienThiDS(const vector<SinhVien> &ds) {
    cout << fixed << setprecision(2);
    for (const auto &sv : ds) {
        cout << sv.maSV << " | " << sv.hoTen << " | " << sv.lop << " | " << sv.diem << endl;
    }
}

void Bai6() {
    cout << "\n--- BAI 6: QUAN LY SINH VIEN ---\n";
    vector<SinhVien> ds;
    int chon;
    do {
        cout << "\n1. Nhap DS\n2. Hien thi\n3. Tim theo lop\n4. Tim Lop & Diem > 5\n";
        cout << "5. SV diem cao nhat\n6. Them SV cuoi\n7. Them SV sau k\n8. Xoa SV tai k\n";
        cout << "9. Sap xep diem giam\n10. Chuyen lop\n11. Top 1 lop\n12. Xoa cuoi\n0. Thoat\nChon: ";
        cin >> chon;
        
        if (chon == 1) nhapDS(ds);
        else if (chon == 2) hienThiDS(ds);
        else if (chon == 3) {
            cin.ignore(); string lop; cout << "Nhap lop: "; getline(cin, lop);
            for(auto &sv : ds) if(sv.lop == lop) cout << sv.hoTen << endl;
        }
        else if (chon == 4) {
            cin.ignore(); string lop; double d; 
            cout << "Nhap lop: "; getline(cin, lop);
            cout << "Nhap diem san: "; cin >> d;
            for(auto &sv : ds) if(sv.lop == lop && sv.diem > d) cout << sv.hoTen << " - " << sv.diem << endl;
        }
        else if (chon == 5) {
            if(ds.empty()) continue;
            float maxD = ds[0].diem;
            for(auto &sv : ds) if(sv.diem > maxD) maxD = sv.diem;
            for(auto &sv : ds) if(sv.diem == maxD) cout << sv.hoTen << " (" << maxD << ")" << endl;
        }
        else if (chon == 6) {
            SinhVien sv; cin.ignore();
            cout << "Ma: "; getline(cin, sv.maSV);
            cout << "Ten: "; getline(cin, sv.hoTen);
            cout << "Lop: "; getline(cin, sv.lop);
            cout << "Diem: "; cin >> sv.diem;
            ds.push_back(sv);
        }
        else if (chon == 7) {
            int k; cout << "Nhap k: "; cin >> k;
            SinhVien sv; cin.ignore();
            cout << "Ma: "; getline(cin, sv.maSV);
            cout << "Ten: "; getline(cin, sv.hoTen);
            cout << "Lop: "; getline(cin, sv.lop);
            cout << "Diem: "; cin >> sv.diem;
            if (k >= 0 && k < ds.size()) ds.insert(ds.begin() + k + 1, sv);
        }
        else if (chon == 8) {
            int k; cout << "Nhap k: "; cin >> k;
            if (k >= 0 && k < ds.size()) ds.erase(ds.begin() + k);
        }
        else if (chon == 9) {
            sort(ds.begin(), ds.end(), [](SinhVien a, SinhVien b){ return a.diem > b.diem; });
        }
        else if (chon == 10) {
            cin.ignore(); string ma, lopMoi;
            cout << "Nhap Ma SV: "; getline(cin, ma);
            cout << "Nhap Lop moi: "; getline(cin, lopMoi);
            for(auto &sv : ds) if(sv.maSV == ma) sv.lop = lopMoi;
        }
        else if (chon == 11) {
            cin.ignore(); string lop; cout << "Nhap lop: "; getline(cin, lop);
            float maxLop = -1;
            for(auto &sv : ds) if(sv.lop == lop && sv.diem > maxLop) maxLop = sv.diem;
            if(maxLop != -1)
                for(auto &sv : ds) if(sv.lop == lop && sv.diem == maxLop) cout << sv.hoTen << endl;
        }
        else if (chon == 12) {
            if(!ds.empty()) ds.pop_back();
        }

    } while (chon != 0);
}

int main() {
    int choice;
    do {
        cout << "\n========= MENU LAB 01 (C++) =========" << endl;
        cout << "1. Bai 1 (Tong chuoi)" << endl;
        cout << "2. Bai 2 (Mang 1 chieu)" << endl;
        cout << "3. Bai 3 (Ma tran)" << endl;
        cout << "4. Bai 4 (Chuoi)" << endl;
        cout << "5. Bai 5 (Vector)" << endl;
        cout << "6. Bai 6 (Quan ly SV)" << endl;
        cout << "0. Thoat" << endl;
        cout << "Chon bai: ";
        cin >> choice;

        switch (choice) {
            case 1: Bai1(); break;
            case 2: Bai2(); break;
            case 3: Bai3(); break;
            case 4: Bai4(); break;
            case 5: Bai5(); break;
            case 6: Bai6(); break;
            case 0: cout << "Ket thuc!" << endl; break;
            default: cout << "Chon sai!" << endl;
        }
    } while (choice != 0);
    return 0;
}