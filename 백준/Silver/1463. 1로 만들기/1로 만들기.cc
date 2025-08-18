#include <iostream>
#include <vector>
#include <climits>

using namespace std;

void recur_calc(int n, vector<int>& count) {
	if (n % 2 == 0) {
		if (n % 2 == 0 && count[n / 2] + 1 < count[n]) {
			count[n] = count[n / 2] + 1;
		}
	}

	if (n % 3 == 0) {
		if (n % 3 == 0 && count[n / 3] + 1 < count[n]) {
			count[n] = count[n / 3] + 1;
		}
	}

	if (n-1 > 0 && count[n - 1] + 1 < count[n]) {
		count[n] = count[n - 1] + 1;
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;
	cin >> N;

	vector<int> count(N+1, INT_MAX);
	count[0] = 0;
	count[1] = 0;
	for (int i = 1; i < N+1; i++) {
		recur_calc(i, count);
	}
	cout << count[N];

}