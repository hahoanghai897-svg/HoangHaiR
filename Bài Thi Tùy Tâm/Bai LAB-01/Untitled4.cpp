#include <iostream>
#include <cstring>
#include <cctype>
using namespace std;

int main() {
    char s[200];
    cin.getline(s, 200);

    int chu = 0, so = 0;
    for (int i = 0; s[i]; i++) {
        if (isalpha(s[i])) chu++;
        if (isdigit(s[i])) so++;
    }

    cout << "Chu cai: " << chu << endl;
    cout << "Chu so: " << so << endl;

    strrev(s);
    cout << "Dao nguoc: " << s << endl;
}
