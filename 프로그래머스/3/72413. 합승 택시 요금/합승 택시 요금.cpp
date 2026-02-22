#include <string>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

struct Edge{
    int v,w,weight;
};

class Graph{
private:
    int num_vertices;
    vector<vector<Edge>> adj;

public:
    Graph(int n){
        this->num_vertices = n;
        this->adj.resize(n);
    }
    
    void AddEdge(Edge& e){
        this->adj[e.v].push_back(e);
    }
    
    int getNumVertices(){
        return this->num_vertices;
    }
    
    const vector<Edge>& Adj(int v){
        return this->adj[v];
    }
};

class Dijkstra{
private:
    vector<bool> visited;
    vector<int> prev;
    vector<long> dist;
    
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    
public:
    Dijkstra(Graph& g, int s):
        visited(g.getNumVertices(), false),
        prev(g.getNumVertices(), -1),
        dist(g.getNumVertices(), numeric_limits<int>::max())
    {
        dist[s] = 0;
        pq.push({dist[s], s});
        
        while(!pq.empty()){
            int v = pq.top().second;
            pq.pop();
            
            if(visited[v]) continue;
            visited[v] = true;
            
            Relax(g, v);
        }
    }
    
    void Relax(Graph& g, int v){
        for(const Edge& e: g.Adj(v)){
            int w = e.w;
            if(dist[v]+e.weight < dist[w]){
                dist[w] = dist[v]+e.weight;
                prev[w] = v;
                pq.push({dist[w], w});
            }
        }
    }
    
    int GetDist(int i){
        long distance = this->dist[i];
        if(distance == numeric_limits<int>::max()){
            return -1;
        }
        return this->dist[i];
    }
    
};

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    
    Graph g(n);
    for(int i=0; i<fares.size(); i++) {
        Edge e = {fares[i][0]-1, fares[i][1]-1, fares[i][2]};
        Edge re = {fares[i][1]-1, fares[i][0]-1, fares[i][2]};
        g.AddEdge(e);
        g.AddEdge(re);
    }
    Dijkstra start(g, s-1);
    Dijkstra point_a(g, a-1);
    Dijkstra point_b(g, b-1);
    
    int answer = numeric_limits<int>::max();
    for(int i=0; i<n; i++){
        int start_dist = start.GetDist(i);
        int a_dist = point_a.GetDist(i);
        int b_dist = point_b.GetDist(i);
        
        if(start_dist != -1 && a_dist != -1 && b_dist != -1) {
            int total_dist = start_dist+a_dist+b_dist;
            if(answer > total_dist){
                answer = total_dist;
            }
        }
    }
    
    return answer;
}