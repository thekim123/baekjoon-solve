// Online C++ compiler to run C++ program online
#include <iostream>
#include <vector>

using namespace std;

struct Edge {
    int v, w;
};

struct Graph {
    int num_vertices;
    vector<vector<Edge>> adj;

    Graph(int n) {
        this->num_vertices = n;
        this->adj.resize(n);
    }

    void AddEdge(Edge e) {
        this->adj[e.v].push_back(e);
    }
};


long dfs(vector<long>& leafCount, Graph& g, int s, int parent) {
    long sum = 1;
    for (Edge& e : g.adj[s]) {
        int v = e.w;
        if (v == parent) continue;
        sum += dfs(leafCount, g, e.w, s);
    }

    leafCount[s] = sum;
    return sum;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);


    int N, R, Q;
    cin >> N >> R >> Q;
    R--;
    Graph g(N);
    for (int i = 0; i < N-1; i++) {
        int v, w;
        cin >> v >> w;
        v--; w--;
        Edge e = {v, w};
        Edge re = { w, v };
        g.AddEdge(e);
        g.AddEdge(re);
    }

    vector<long> leafCount(N, 0);
    dfs(leafCount, g, R, -1);
    for (int i = 0; i < Q; i++) {
        int s; cin >> s; s--;
        cout << leafCount[s] << "\n";
    }
    return 0;
}