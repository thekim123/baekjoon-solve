#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

struct Vertex {
	int v, w;
};

class Graph {
public:
	int num_vertices;
	int num_edges;
	vector<vector<int>> adj;
	vector<int> indegree;

	Graph(int num_vertices) {
		this->num_edges = 0;
		this->num_vertices = num_vertices;
		this->adj.resize(num_vertices);
		this->indegree.resize(num_vertices);
	}

	void AddEdge(Vertex& v) {
		adj[v.v].push_back(v.w);
		indegree[v.w]++;
		num_edges++;
	}
};

class TopologicalSort {
	queue<pair<int, int>> q;
	vector<int> result;

public:
	TopologicalSort(Graph& g):
		result(g.num_vertices)
	{
		for (int i = 0; i < g.num_vertices; i++) {
			if (g.indegree[i] == 0) {
				q.push({ i , 1});
				result[i] = 1;
			}
		}

		while (!q.empty()) {
			int current = q.front().first;
			int count = q.front().second;
			q.pop();
			
			for (int next : g.adj[current]) {
				g.indegree[next]--;
				if (g.indegree[next] == 0) {
					q.push({ next, count+1});
					result[next] = count+1;
				}

			}
		}
	}

	void PrintResult() {
		for (auto number : result) {
			cout << number << " ";
		}
	}
	
};

int main() {
	int N, M;
	cin >> N >> M;

	Graph g = Graph(N);
	for (int i = 0; i < M; i++) {
		int A, B;
		cin >> A >> B;
		Vertex v = { A-1, B-1 };
		g.AddEdge(v);
	}

	TopologicalSort topo = TopologicalSort(g);
	topo.PrintResult();
}