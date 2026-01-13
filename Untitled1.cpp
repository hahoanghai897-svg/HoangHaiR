#include <iostream>
using namespace std;

int tong1(int n) {
    int s = 0;
    for (int i = 1; i <= n; i++) s += i;
    return s;
}

int tong2(int n) {
    int s = 0;
    for (int i = 1; i <= n; i++) s += i * i;
    return s;
}

int main() {
    int n;
    cin >> n;
    cout << "Tong 1 = " << tong1(n) << endl;
    cout << "Tong 2 = " << tong2(n) << endl;
}
n