#include <iostream>
#include <vector>
#include <queue>
#include <limits>


using namespace std;

struct Edge{
    int v,w,weight;
};

class Graph{
public:
    int num_vertices;
    vector<vector<Edge>> adj;
    
    Graph(int num_vertices){
        this->num_vertices=num_vertices;
        this->adj.resize(num_vertices);
    }
    
    void AddEdge(Edge& e){
        this->adj[e.v].push_back(e);
    }
    
};

class Dijkstra {
private:
    vector<bool> visited;
    vector<int> prev;
    vector<long> dist;
    
    priority_queue<pair<long, int>, vector<pair<long, int>>, greater<pair<long, int>>> pq;
    
public:
    Dijkstra(Graph& g, int s):
        visited(g.num_vertices, false),
        prev(g.num_vertices, -1),
        dist(g.num_vertices, numeric_limits<long>::max())
    {
        dist[s] = 0;
        pq.push({0,s});
        
        while(!pq.empty()){
            int v = pq.top().second;
            pq.pop();
            
            if(visited[v]) continue;
            visited[v] = true;
            
            Relax(g, v);
        }
        
    }
    
    void Relax(Graph& g, int v){
        for(Edge& e: g.adj[v]){
            int w = e.w;
            if(dist[v]+e.weight < dist[w]){
                dist[w] = dist[v]+e.weight;
                prev[w] = v;
                pq.push({dist[w], w});
            }
        }
    }
    
    int Answer(int k){
        
        int result = 0;
        for(int i=0; i<dist.size(); i++){
            cout << dist[i] << " ";
            if(dist[i] <= k){
                result++;
            }
        }
        cout << endl;
        return result;
    }
};

int solution(int N, vector<vector<int> > road, int K) {
    int answer = 0;
    
    Graph g(N);
    for(int i=0; i<road.size(); i++){
        Edge e = {road[i][0]-1, road[i][1]-1, road[i][2]};
        Edge re = {road[i][1]-1, road[i][0]-1, road[i][2]};
        g.AddEdge(e);
        g.AddEdge(re);
    }
    Dijkstra d(g, 0);
    return d.Answer(K);
    

    
}