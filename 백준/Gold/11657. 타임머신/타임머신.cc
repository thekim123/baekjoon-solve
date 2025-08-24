#include <iostream>
#include <vector>
#include <climits>
#include <limits>

using namespace std;

struct Bus {
	int start;
	int end;
	int duration;
};


int main() {
	//constexpr double kInf = numeric_limits<double>::infinity();
	long long kInf = 1LL << 62;
	int N, M;
	cin >> N >> M;

	vector<Bus> buses(M);
	for (int i = 0; i < M; i++) {
		int start, end, duration;
		cin >> start >> end >> duration;
		buses[i] = Bus{ start, end, duration };
	}
	// 30 000 000 000
	//  2 147 483 647
	// 도시의 개수 N
	// 버스의 개수 M
	vector<long long> dist(N+1, kInf);
	dist[0] = 0;
	dist[1] = 0;

	for (int v = 1; v < N + 1; v++) {
		for (auto& bus : buses) {
			if (dist[bus.start] != kInf && dist[bus.end] > dist[bus.start] + bus.duration) {
				dist[bus.end] = dist[bus.start] + bus.duration;
			}
		}
	}


	for (auto& bus : buses) {
		if (dist[bus.start] != kInf && dist[bus.end] > dist[bus.start] + bus.duration) {
			cout << "-1\n";
			return 0;
		}
	}


	/*
	만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력한다. 그렇지 않다면 N-1개 줄에 걸쳐 각 줄에 1번 도시에서 출발해 2번 도시, 3번 도시, ..., N번 도시로 가는 가장 빠른 시간을 순서대로 출력한다. 만약 해당 도시로 가는 경로가 없다면 대신 -1을 출력한다.
	*/
	for (int i = 2; i < N + 1; i++) {
		if (dist[i] == kInf) {
			cout << "-1\n";
		} else {
			cout << dist[i] << "\n";
		}
	}
}