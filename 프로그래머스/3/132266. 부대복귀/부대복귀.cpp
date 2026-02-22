#include <string>
#include <vector>
#include <queue>
#include <limits>
#include <iostream>

using namespace std;

struct Edge{
  int w, v;  
};

class Graph{
private:
    int num_vertices;
    vector<vector<Edge>> adj;

public:    
    Graph(int n){
        this->num_vertices=n;
        this->adj.resize(n);
    }
    
    void AddEdge(Edge& e) {
        this->adj[e.v].push_back(e);
    }
    
    vector<Edge> Adj(int v) {
        return this->adj[v];
    }
    
    int getNumVertices() {
        return this->num_vertices;
    }
};


class BFS{
private:
    vector<bool> visited;
    vector<int> prev;
    vector<int> dist;
    
    queue<pair<int, int>> queue;
    
public:
    BFS(Graph& g, int s):
        visited(g.getNumVertices(), false),
        prev(g.getNumVertices(), -1),
        dist(g.getNumVertices(), numeric_limits<int>::max())
    {
        dist[s] = 0;
        queue.push({dist[s], s});
        
        while(!queue.empty()) {
            int v = queue.front().second;
            queue.pop();
            
            if(visited[v]) continue;
            visited[v] = true;
            
            Relax(g, v);
        }
    }
    
    void Relax(Graph& g, int v) {
        for(Edge& e : g.Adj(v)){
            int w = e.w;
            if(dist[v]+1 < dist[w]){
                dist[w] = dist[v]+1;
                prev[w] = v;
                queue.push({dist[w], w});
            }
        }
    }
    
    int GetDist(int dest) {
        return this->dist[dest];
    }
    
};



vector<int> solution(int n, vector<vector<int>> roads, vector<int> sources, int destination) {
    vector<int> answer(sources.size());
    Graph g(n);

    for(int i=0; i<roads.size(); i++){
        Edge e = {roads[i][0]-1, roads[i][1]-1};
        Edge re = {roads[i][1]-1, roads[i][0]-1};
        g.AddEdge(e);
        g.AddEdge(re);
    }
    
    cout << numeric_limits<int>::max() << endl;
    for(int i=0; i<sources.size(); i++){
        BFS bfs(g, sources[i]-1);
        int dist = bfs.GetDist(destination-1);
        cout <<dist << endl;
        if(dist == numeric_limits<int>::max()){
            answer[i] = -1;
        }
        else if(dist != 0){
            answer[i] = dist;
        }
        else {
            answer[i] = 0;
        }
    }
    

    return answer;
}