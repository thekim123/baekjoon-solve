#include <iostream>
#include <vector>
using namespace std;

vector<int> zero(40);
vector<int> one(40);
vector<int> fibo(40);

void fibonacci(int n) {
    for (int i = 2; i <= n; i++) {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
        zero[i] = zero[i - 1] + zero[i - 2];
        one[i] = one[i - 1] + one[i - 2];
    }
}

int main() {

    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        fibo[0] = 0; fibo[1] = 1;
        one[0] = 0; one[1] = 1;
        zero[0] = 1; zero[1] = 0;
        int c;
        cin >> c;
        fibonacci(c);
        cout << zero[c] << " " << one[c] << endl;
    }
}