#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>
#include <limits>
using namespace std;

struct Edge{
    int v, w;
};

class Graph{
private:
    int num_vertices;
    vector<vector<Edge>> adj;
    
public:
    Graph(int num_vertices){
        this->num_vertices=num_vertices;
        this->adj.resize(num_vertices);
    }
    
    void AddEdge(Edge e){
        adj[e.v].push_back(e);
    }
    
    int NumVertices(){
        return this->num_vertices;
    }
    
    vector<Edge> Adj(int v){
        return this->adj[v];
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
        visited(g.NumVertices(), false),
        prev(g.NumVertices(), -1),
        dist(g.NumVertices(), numeric_limits<int>::max())
    {
        dist[s] = 0;
        queue.push({0, s});
        
        while(!queue.empty()){
            int v = queue.front().second;
            queue.pop();
            
            if(visited[v]) continue;
            visited[v]=true;
            
            Relax(g, v);            
        }
            
    }
    
    void Relax(Graph& g, int v){
        for(Edge& e: g.Adj(v)){
            int w = e.w;
            if(dist[v]+1 < dist[w]){
                dist[w] = dist[v]+1;
                prev[w] = v;
                queue.push({dist[w], w});
            }
        }
    }
    
    int Answer(){
        sort(dist.begin(), dist.end(), greater<int>());
        int answer=0;
        for(int i=0; i<dist.size(); i++){
            cout << dist[i] << endl;
            if(dist[0] == dist[i]){
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
};

int solution(int n, vector<vector<int>> edge) {
    Graph g(n);
    for(int i=0; i<edge.size(); i++){
        Edge e = {edge[i][0]-1, edge[i][1]-1};
        Edge re = {edge[i][1]-1, edge[i][0]-1};
        g.AddEdge(e);
        g.AddEdge(re);
    }
    BFS bfs(g, 0);
    
    return bfs.Answer();
}