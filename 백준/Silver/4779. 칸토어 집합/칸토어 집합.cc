#include <iostream>
#include <vector>

using namespace std;

void Cantore(vector<char>::iterator begin, vector<char>::iterator end) {
    auto size = end - begin;
    if (size < 3) return;
    auto one_third = size / 3;
    for (auto it = begin + one_third; it != begin + 2 * one_third; ++it) {
        *it = ' ';
    }
    Cantore(begin, begin + one_third);
    Cantore(begin + 2 * one_third, end);
}

int pow3(int n) {
    int result = 1;
    while (n--) result *= 3;
    return result;
}


int main() {
    int N;
    while (cin >> N) {
        int test_case = pow3(N);
        vector<char> arr(test_case, '-');
        Cantore(arr.begin(), arr.end());

        for (auto a : arr) {
            cout << a;
        }

        cout << endl;
    }
}