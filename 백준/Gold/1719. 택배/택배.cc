#include<iostream>
#include<vector>
#include<queue>

using namespace std;

struct Edge {
	int v;
	int w;
	long weight;
};

class WeightedDigraph {
public:
	int num_vertices;
	int num_edges;
	vector<vector<Edge>> adj;

	WeightedDigraph(int num_vertices) {
		this->num_edges = 0;
		this->num_vertices = num_vertices;
		this->adj.resize(num_vertices);
	}

	void AddEdge(Edge& e) {
		this->num_edges++;
		this->adj[e.v].push_back(e);
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

			if (visited[v]) continue;
			visited[v] = true;

			Relax(g, v);
		}
	}

	void Relax(WeightedDigraph& g, int v){
		for (auto& e : g.adj[v]) {
			int w = e.w;
			long new_dist = dist[v] + e.weight;
			if (dist[w] > new_dist) {
				dist[w] = new_dist;
				prev[w] = v;
				pq.push({ new_dist, w });
			}
		}
	}

	void PrintResult(int s, vector<vector<int>>& result) {
		for (int i = 0; i < prev.size(); i++) {
			if (i == s) {
				result[i][s] = -1;
				continue;
			}
			result[i][s] = prev[i]+1;
		}
	}

};

int main() {
	int n, m;
	cin >> n >> m;

	WeightedDigraph g = WeightedDigraph(n);
	for (int i = 0; i < m; i++) {
		int v, w; long weight;
		cin >> v >> w >> weight;
		Edge e = { v-1,w-1,weight };
		Edge rev_e = { w-1,v-1,weight };
		g.AddEdge(e);
		g.AddEdge(rev_e);
	}

	vector<vector<int>> result(n, vector<int>(n));
	for (int i = 0; i < n; i++) {
		Dijkstra d = Dijkstra(g, i);
		d.PrintResult(i, result);
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (result[i][j] == -1) {
				cout << "- ";
			}
			else {
				cout << result[i][j] << " ";
			}
		}
		cout << endl;
	}

}