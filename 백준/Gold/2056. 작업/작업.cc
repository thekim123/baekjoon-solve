#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct Graph {
	int num_vertices;
	vector<vector<int>> adj;
	vector<int> indegree;

	Graph(int num_vertices) {
		this->num_vertices = num_vertices;
		this->indegree.resize(num_vertices);
		this->adj.resize(num_vertices);
	}

	void AddEdge(int v, int w) {
		this->adj[v].push_back(w);
		indegree[w]++;
	}
};

class TopologicalSort {
public:
	queue<int> q;
	vector<long> dp;

	TopologicalSort(Graph& g, vector<long>& dist) {
		dp.resize(g.num_vertices);

		for (int i = 0; i < g.indegree.size(); i++) {
			if (g.indegree[i] == 0) {
				q.push(i);
				dp[i] = dist[i];
			}
		}

		while (!q.empty()) {
			int current = q.front(); q.pop();
			for (int next : g.adj[current]) {
				dp[next] = max(dp[next], dp[current] + dist[next]);
				g.indegree[next]--;
				if (g.indegree[next] == 0) {
					q.push(next);
				}
			}
		}
	}

};


int main() {
	int N;
	cin >> N;
	
	Graph g = Graph(N);
	vector<long> dist(N);
	int count;
	for (int i = 0; i < N; i++) {
		cin >> dist[i] >> count;
		for (int j = 0; j < count; j++) {
			int w; cin >> w;
			g.AddEdge(w-1, i);
		}
	}

	TopologicalSort topology = TopologicalSort(g, dist);
	int min=0;
	for (int result : topology.dp) {
		if (min < result) {
			min = result;
		}
	}
	cout << min << endl;
}