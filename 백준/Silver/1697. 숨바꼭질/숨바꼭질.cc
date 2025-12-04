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
		
		
		int nexts[3] = { current*2, current-1, current+1 };
		for (int next: nexts) {
			if (next < 0 || next > POS) continue;
			if (visited[next]) continue;
			visited[next] = true;
			q.push({ count+1, next });
		}
	}

}

int main() {
	int N, K;
	cin >> N >> K;
	//BFS(5, 17);
	BFS(N, K);
}