#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int n, a[20][20];
    cin >> n;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> a[i][j];

    int sum = 0;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            sum += a[i][j];

    cout << "Tong = " << sum << endl;
    cout << "Chinh phuong duong cheo chinh: ";
    for (int i = 0; i < n; i++) {
        int r = sqrt(a[i][i]);
        if (r * r == a[i][i])
            cout << a[i][i] << " ";
    }
}
