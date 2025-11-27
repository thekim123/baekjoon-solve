#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct DirectedEdge {
	int v, w;
	long weight;
};

class WeightedDigraph {
public:
	int num_vertices;
	int num_edges;
	vector<vector<DirectedEdge>> adj;

	WeightedDigraph(int num_vertices) {
		this->num_edges = 0;
		this->num_vertices = num_vertices;
		this->adj.resize(num_vertices);
	}

	void AddEdge(DirectedEdge& edge) {
		this->adj[edge.v].push_back(edge);
		this->num_edges++;
	}
};

class Dijkstra {
private:
	vector<int> prev;
	vector<bool> visited;
	vector<long> dist;

	priority_queue<pair<long, int>, vector<pair<long, int>>, greater<pair<long, int>>> pq;

public:
	Dijkstra(WeightedDigraph& g, int s) :
		prev(g.num_vertices, -1),
		visited(g.num_vertices, false),
		dist(g.num_vertices, numeric_limits<long>::max())
	{
		dist[s] = 0;
		pq.push({ 0, s });

		while (!pq.empty()) {
			int v = pq.top().second;
			pq.pop();

			if (visited[v])continue;
			visited[v] = true;

			Relax(g, v);
		}
	}

	void Relax(WeightedDigraph& g, int v) {
		vector<DirectedEdge>& adj = g.adj[v];
		for (auto& e : adj) {
			int w = e.w;
			long new_dist = dist[v] + e.weight;
			if (dist[w] > new_dist) {
				dist[w] = new_dist;
				prev[w] = v;
				pq.push({ new_dist, w });
			}
		}
	}

	void PrintShortestPath(int N) {
		cout << dist[N];
	}

};

int main() {
	int N, M;
	cin >> N >> M;

	WeightedDigraph g = WeightedDigraph(N);
	for (int i = 0; i < M; i++) {
		int a, b; long c;
		cin >> a >> b >> c;
		DirectedEdge edge = { a-1, b-1, c };
		DirectedEdge reverse_edge = { b - 1, a - 1, c };
		g.AddEdge(edge);
		g.AddEdge(reverse_edge);
	}

	Dijkstra d = Dijkstra(g, 0);
	d.PrintShortestPath(N-1);
}