#include <iostream>3
using namespace std;

int main() {
    int n;
    cin >> n;

    int* a = new int[n];
    for (int i = 0; i < n; i++) cin >> a[i];

    int mn = a[0];
    for (int i = 1; i < n; i++)
        mn = min(mn, a[i]);

    cout << "Min = " << mn;
    delete[] a;
}
