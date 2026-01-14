#include <iostream>
#include <cmath>
using namespace std;

bool chinhPhuong(int x) {
    if (x < 0) return false;
    int r = sqrt(x);
    return r * r == x;
}

int main() {
    int n, a[100];
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];

    int sum = 0, demAm = 0, mx = a[0], mn = a[0];
    for (int i = 0; i < n; i++) {
        sum += a[i];
        if (a[i] < 0) demAm++;
        mx = max(mx, a[i]);
        mn = min(mn, a[i]);
    }

    cout << "Tong = " << sum << endl;
    cout << "So am = " << demAm << endl;
    cout << "So chinh phuong: ";
    for (int i = 0; i < n; i++)
        if (chinhPhuong(a[i]))
            cout << a[i] << " ";
}
