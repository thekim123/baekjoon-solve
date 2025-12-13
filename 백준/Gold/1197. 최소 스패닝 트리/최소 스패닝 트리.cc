#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge {
	int u, v, weight;

	bool operator < (const Edge& other) const {
		return weight < other.weight;
	}
};

struct UnionFind {
	int size;
	vector<int> group;

	UnionFind(int size) {
		this->size = size;
		group.resize(size);
		for (int i = 0; i < size; i++) {
			group[i] = i;
		}
	}

	bool Connected(int p, int q) {
		return Find(p) == Find(q);
	}

	int Find(int p) {
		if (group[p] != p) {
			group[p] = Find(group[p]);
		}
		return group[p];
	}

	void Union(int p, int q) {
		int pid = Find(p);
		int qid = Find(q);

		if (pid == qid) return;
		group[pid] = qid;
		size--;
	}
};

int main() {
	int V, E;
	cin >> V >> E;
	UnionFind uf = UnionFind(V);

	int A, B, C;
	vector<Edge> edges(E);
	for (int i = 0; i < E; i++) {
		cin >> A >> B >> C;
		Edge e = {A-1,B-1,C};
		edges[i] = e;
	}

	int result = 0;
	sort(edges.begin(), edges.end());
	for (int i = 0; i < E; i++) {
		int u = edges[i].u;
		int v = edges[i].v;
		if (!uf.Connected(u, v)) {
			result += edges[i].weight;
			uf.Union(u, v);
		}
	}

	cout << result;
}