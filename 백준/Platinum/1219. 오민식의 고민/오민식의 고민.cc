#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct Transport {
	int start;
	int end;
	int pay;
};


int main() {
	int N, S, E, M;
	cin >> N >> S >> E >> M;

	vector<Transport> transports(M);
	for (int i = 0; i < M; i++) {
		int start, end, pay;
		cin >> start >> end >> pay;
		transports[i] = Transport{ start, end, pay };
	}

	vector<int> max_pay(N);
	for (int i = 0; i < N; i++) {
		cin >> max_pay[i];
	}

	vector<vector<int>> adj(N), rAdj(N);
	for (auto& t : transports) {
		adj[t.start].push_back(t.end);
		rAdj[t.end].push_back(t.start);
	}

	vector<char> reachS(N, 0);
	vector<int> st = { S };
	reachS[S] = 1;
	while (!st.empty()) {
		int x = st.back();
		st.pop_back();
		for (int nx : adj[x]) {
			if (!reachS[nx]) {
				reachS[nx] = 1;
				st.push_back(nx);
			}
		}
	}


	vector<char> reachE(N, 0);
	st = { E };
	reachE[E] = 1;
	while (!st.empty()) {
		int x = st.back();
		st.pop_back();
		for (int nx : rAdj[x]) {
			if (!reachE[nx]) {
				reachE[nx] = 1;
				st.push_back(nx);
			}
		}
	}

	const long long INF = 1LL << 60;
	vector<long long> dist(N, -INF);
	dist[S] = max_pay[S];

	for (int v = 1; v <= N; v++) {
		for (auto& transport : transports) {
			int max_p = min(max_pay[transport.end], transport.pay);
			if (dist[transport.start] != -INF && dist[transport.start] - transport.pay + max_pay[transport.end] > dist[transport.end]) {
				dist[transport.end] = dist[transport.start] - transport.pay + max_pay[transport.end];
			}

		}
	}

	if (dist[E] == -INF) {
		cout << "gg";
		return 0;
	}

	for (auto& transport : transports) {
		if (dist[transport.start] == -INF) continue;
		long long nd = dist[transport.start] - transport.pay + max_pay[transport.end];
		if (nd > dist[transport.end] && reachS[transport.start] && reachE[transport.end]) {
			cout << "Gee";
			return 0;
		}
	}

	cout << dist[E];

}