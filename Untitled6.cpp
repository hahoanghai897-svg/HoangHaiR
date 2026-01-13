#include <iostream>
#include <iomanip>
using namespace std;

struct SinhVien {
    string ma, ten, lop;
    float diem;
};

int main() {
    int n;
    cin >> n;
    cin.ignore();

    SinhVien sv[100];
    for (int i = 0; i < n; i++) {
        getline(cin, sv[i].ma);
        getline(cin, sv[i].ten);
        getline(cin, sv[i].lop);
        cin >> sv[i].diem;
        cin.ignore();
    }

    float maxD = sv[0].diem;
    for (int i = 1; i < n; i++)
        if (sv[i].diem > maxD)
            maxD = sv[i].diem;

    cout << "Sinh vien diem cao nhat:\n";
    for (int i = 0; i < n; i++)
        if (sv[i].diem == maxD)
            cout << sv[i].ma << " - " << sv[i].ten
                 << " - " << fixed << setprecision(2)
                 << sv[i].diem << endl;
}
