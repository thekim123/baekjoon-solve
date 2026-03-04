/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> children;
vector<int> parent;
int del = 0;

int dfs(int node){
    if(node==del) return 0;
    
    int aliveChild = 0;
    int sum = 0;
    for(int child: children[node]) {
        if(child == del) continue;
        aliveChild++;
        //cout << "child: " << child << endl;
        sum += dfs(child);
    }
    if(aliveChild == 0) return 1;
    return sum;
}


int main()
{
    int N;
    cin >> N;
    children.assign(N, {});
    parent.resize(N);

    for(int i=0; i<N; i++){
        int number;
        cin >> number;
        parent[i] = number;
        if(number>-1)
            children[number].push_back(i);
    }
    
    int root = -1;
    for(int i=0; i<parent.size(); i++){
        if(parent[i] == -1){
            root = i;
            break;
        }
    }
    
    cin >> del;
    int result = dfs(root);
    cout << result;

    return 0;
}