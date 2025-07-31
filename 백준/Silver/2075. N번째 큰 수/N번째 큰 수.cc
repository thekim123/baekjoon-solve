#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Compare {
	bool operator()(int a, int b) {
		return a > b;
	}
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;
	cin >> N;

	priority_queue<int, vector<int>, Compare> pq;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int a;
			cin >> a;
			pq.push(a);

			if (pq.size() > N) {
				pq.pop();
			}
		}
	}

	cout << pq.top();

}