#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
	int N, M;
	cin >> N >> M;

	vector<vector<int>> arr(N, vector<int>(M));
	vector<vector<int>> dist(N, vector<int>(M, 0));
	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		for (int j = 0; j < M; j++) {
			arr[i][j] = temp[j] - 48;
		}
	}

	int dx[4] = { 1, -1, 0, 0 };
	int dy[4] = { 0,0,-1,1 };

	queue<pair<int, int>> q;
	q.push({ 0, 0 });
	dist[0][0] = 1;
	while (!q.empty()) {
		pair<int, int> x = q.front();
		q.pop();

		for (int dir = 0; dir < 4; dir++) {
			int nx = x.first + dx[dir];
			int ny = x.second + dy[dir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if (arr[nx][ny] == 0) continue;
			if (dist[nx][ny] != 0) continue;
			dist[nx][ny] = dist[x.first][x.second] + 1;
			q.push({ nx, ny });
		}

	}

	cout << dist[N - 1][M - 1];

}