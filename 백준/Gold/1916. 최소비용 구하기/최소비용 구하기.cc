#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class DirectedEdge {
public:
	int v;
	int w;
	long long weight;
	
	DirectedEdge(int v, int w, long long weight) {
		this->v = v;
		this->w = w;
		this->weight = weight;
	}
	
	int From() { return v; }
	int To() { return w; }
	long long Weight() { return weight; }

};

class EdgeWeightedDigraph {
public: 
	int num_vertices;
	int num_edges;
	vector<vector<DirectedEdge>> adj;

	EdgeWeightedDigraph(int num_vertices){
		this->num_vertices = num_vertices;
		this->adj.resize(num_vertices);
		this->num_edges = 0;
	}

	void AddEdge(DirectedEdge edge) {
		this->adj[edge.From()].push_back(edge);
		this->num_edges++;
	}
};

class DijkstraShortestPaths {
private:
	vector<int> prev;
	vector<long long> dist;
	vector<bool> visited;
	priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;

public:
	DijkstraShortestPaths(EdgeWeightedDigraph& g, int v):
		prev(g.num_vertices, -1),
		dist(g.num_vertices, numeric_limits<long long>::max()),
		visited(g.num_vertices, false)
	{
		dist[v] = 0;
		pq.push({ 0.0, v });

		while (!pq.empty()) {
			int v = pq.top().second;
			pq.pop();

			if (visited[v]) continue;
			visited[v] = true;

			Relax(g, v);
		}
	}

	void Relax(EdgeWeightedDigraph g, int v) {
		for (DirectedEdge& e : g.adj[v]) {
			int w = e.To();
			long long new_dist = dist[v] + e.Weight();
			if (dist[w] > new_dist) {
				dist[w] = new_dist;
				prev[w] = v;
				pq.push({ new_dist, w });
			}
		}
	}

	void PrintResult(int w) {
		cout << dist[w];
	}
};

int main() {
	int N, M;
	cin >> N >> M;

	EdgeWeightedDigraph g = EdgeWeightedDigraph(N);
	for (int i = 0; i < M; i++) {
		int v, w;
		long long weight;
		cin >> v >> w >> weight;
		g.AddEdge(DirectedEdge(v-1, w-1, weight));
	}

	int V, W;
	cin >> V >> W;
	DijkstraShortestPaths paths = DijkstraShortestPaths(g, V-1);
	paths.PrintResult(W-1);
}