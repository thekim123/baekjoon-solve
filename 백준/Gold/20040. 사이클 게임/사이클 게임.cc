#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class UnionFind {
public:
	vector<int> group;
	int num_groups;

	UnionFind(int N) : group(N) {
		for (int i = 0; i < N; i++) {
			group[i] = i;
		}
		num_groups = N;
	}

	int Find(int p) {
		if (group[p] != p) {
			group[p] = Find(group[p]);
		}
		return group[p];
	}

	bool Union(int p, int q) {
		int pid = Find(p);
		int qid = Find(q);
		if (pid == qid) return true;

		group[pid] = qid;
		num_groups--;
		return false;
	}

	bool Connected(int p, int q) {
		return Find(p) == Find(q);
	}
};


int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, m;
	cin >> n >> m;

	UnionFind uf(n);
	int result = 0;
	bool cycle = false;
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		cycle = uf.Union(a, b);
		if (cycle) {
			result = i + 1;
			break;
		}
	}

	cout << result;
}