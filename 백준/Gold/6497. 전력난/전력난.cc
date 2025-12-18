#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge {
	int u, v;
	long weight;

	bool operator < (const Edge& o) const {
		return weight < o.weight;
	}
};

struct UnionFind {
	vector<int> group;
	int num_groups;

	UnionFind(int num_groups) {
		this->group.resize(num_groups);
		this->num_groups = num_groups;
		for (int i = 0; i < num_groups; i++) {
			group[i] = i;
		}
	}

	int Find(int p) {
		if (group[p] == p) return p;		
		group[p] = Find(group[p]);
		return group[p];
	}

	bool Connected(int p, int q) {
		return Find(p) == Find(q);
	}

	void Union(int p, int q) {
		int pid = Find(p);
		int qid = Find(q);

		if (pid == qid) return;
		group[pid] = qid;
		num_groups--;
	}
};

int main() {
	int N, M;
	while (true) {

		cin >> N >> M;

		if (N == 0 && M == 0) {
			break;
		}

		int a, b;
		long c;
		vector<Edge> edges(M);
		long current = 0;
		for (int i = 0; i < M; i++) {
			cin >> a >> b >> c;
			Edge e = { a,b,c };
			edges[i] = e;
			current += c;
		}
		sort(edges.begin(), edges.end());

		UnionFind uf = UnionFind(N);
		int result = 0;
		for (int i = 0; i < M; i++) {
			Edge& e = edges[i];
			if (!uf.Connected(e.u, e.v)) {
				uf.Union(e.u, e.v);
				result += e.weight;
			}
		}

		cout << current - result << endl;
	}
}