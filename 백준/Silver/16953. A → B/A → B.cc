#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
	int A, B;
	cin >> A >> B;

	queue<pair<long long, int>> q;
	q.push({ A, 0 });
	
	while (!q.empty()) {
		long long current = q.front().first;
		int cur_dist = q.front().second;
		q.pop();

		if (current == B) {
			cout << cur_dist+1;
			return 0;
		}


		long long moves[2] = { current * 10 + 1, current * 2 };
		for (long long next : moves) {
			if (next > B) continue;
			q.push({ next, cur_dist+1 });
		}
	}

	cout << -1 << endl;
}