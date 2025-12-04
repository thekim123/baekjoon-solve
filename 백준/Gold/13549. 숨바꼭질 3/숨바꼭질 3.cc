#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int POS = 100000;

void BFS(int start, int goal) {
	queue<pair<int, int>> q;
	vector<bool> visited(POS+1, false);

	q.push({0, start});
	visited[start] = true;

	while (!q.empty()) {
		int count = q.front().first;
		int current = q.front().second;
		q.pop();

		if (current == goal) {
			cout << count;
			return;
		}
		
		
		vector<pair<int, int>> nexts = { {count, current * 2}, {count + 1, current - 1}, {count + 1, current + 1} };
		for (pair<int,int> next: nexts) {
			if (next.second < 0 || next.second > POS) continue;
			if (visited[next.second]) continue;
			visited[next.second] = true;
			q.push(next);
		}
	}

}

int main() {
	int N, K;
	cin >> N >> K;
	//BFS(5, 17);
	BFS(N, K);
}