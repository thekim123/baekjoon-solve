#include <string>
#include <vector>
#include <unordered_set>
#include <iostream>

using namespace std;

bool solution(vector<string> phone_book) {
    unordered_set<string> hash;
    for(int i=0; i<phone_book.size(); i++){
        hash.insert(phone_book[i]);
    }
    
    for(int i=0; i<phone_book.size(); i++){
        string prefix="";
        for(int j=0; j<phone_book[i].length()-1; j++){
            prefix+=phone_book[i][j];
            //cout << prefix << endl;
            if(hash.find(prefix) != hash.end()){
                return false;
            }
        }
    }
    
    return true;
}