#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, vector<string>> clothes_map;
    for(int i=0; i<clothes.size(); i++){
        clothes_map[clothes[i][1]].push_back(clothes[i][0]);
    }

    int answer=1;
    for(auto& [name, arr] : clothes_map){
        cout << name << endl;
        for(int i=0; i< arr.size(); i++){
            cout << arr[i] <<", ";
        }
        cout << endl;
        answer *= arr.size()+1;
        
    }
  

    
    return answer-1;
}