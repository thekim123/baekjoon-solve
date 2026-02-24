#include<vector>
#include<iostream>
#include<queue>
using namespace std;

vector<vector<int>> maps_cp;
vector<vector<bool>> visited;

const int INF = 1e9;
int solution(vector<vector<int>> maps)
{
    maps_cp = maps;
    int rows = maps.size();
    int cols = maps[0].size();
    
    if(maps[0][0] == 0 || maps[rows-1][cols-1]==0) return -1;
    
    vector<vector<int>> dist(rows, vector<int>(cols, 0));
    queue<pair<int, int>> q;
    dist[0][0] = 1;
    q.push({0, 0});
    
    int dx[4] = {1,-1,0,0};
    int dy[4] = {0,0,1,-1};
    
    while(!q.empty()){
        auto [x,y] = q.front();
        q.pop();
        if(x==rows -1 && y==cols -1) return dist[x][y];
        
        for(int k=0; k<4; k++){
            int nx = x+dx[k];
            int ny = y+dy[k];
            
            if(nx<0 || nx>= rows || ny<0 || ny>=cols) continue;
            if(maps_cp[nx][ny]==0) continue;
            if(dist[nx][ny]!=0) continue;
            dist[nx][ny] = dist[x][y]+1;
            q.push({nx, ny});
        }
    }
    
    return -1;
}