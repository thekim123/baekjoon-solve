#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct Edge
{
	int v; int w;
	Edge(int v, int w) {
		this->v = v;
		this->w = w;
	}
};

class Graph {
public:
	int num_vertices;
	int num_edges;
	
	vector<vector<Edge>> adj;

	Graph(int num_vertices) {
		this->num_vertices = num_vertices;
		this->num_edges = 0;
		this->adj.resize(num_vertices);
	}

	void AddEdge(Edge& e) {
		this->num_edges++;
		this->adj[e.v].push_back(e);
	}
};

class BFS {
private:
	vector<int> prev;
	vector<bool> visited;
	vector<int> dist;

	queue<int> queue;

public:
	BFS(Graph& g, int s):
		prev(g.num_vertices, -1),
		visited(g.num_vertices, false),
		dist(g.num_vertices, numeric_limits<int>::max())
	{
		dist[s] = 0;
		queue.push(s);

		while (!queue.empty()) {
			int v = queue.front();
			queue.pop();

			if (visited[v]) continue;
			visited[v] = true;

			Relax(g, v);
		}
		
	}

	void Relax(Graph& g, int v) {
		vector<Edge>& edges = g.adj[v];
		for (auto& e : edges) {
			int new_dist = dist[e.v] + 1;
			if (dist[e.w] > new_dist) {
				dist[e.w] = new_dist;
				prev[e.w] = v;
				queue.push(e.w);
			}
		}
	}

	int getBecon() {
		int result = 0;
		for (auto& i : dist) {
			result += i;
		}
		return result;
	}
};

int main() {
	int N, M;
	cin >> N >> M;

	Graph g = Graph(N);
	for (int i = 0; i < M; i++) {
		int A, B;
		cin >> A >> B;
		Edge e = Edge(A-1, B-1);
		g.AddEdge(e);
		Edge rev_e = Edge(B-1, A-1);
		g.AddEdge(rev_e);
	}

	vector<int> becon(N, 0);
	for (int i = 0; i < N; i++) {
		BFS bfs = BFS(g, i);
		becon[i] = bfs.getBecon();
	}

	//cout << endl;
	int result = 0;
	int min_value = numeric_limits<int>::max();
	//cout << min_value << endl;
	//cout << endl;
	for (int i = 0; i < N; i++) {
		//cout << becon[i] << endl;
		if (becon[i] < min_value) {
			min_value = becon[i];
			result = i;
		}
	}

	//cout << endl;
	cout << result+1;
}