#include <vector>
#include <unordered_map>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<int> nums)
{
    unordered_map<int, int> map;
    for(int i=0; i<nums.size(); i++){
        map[nums[i]]++;
    }
    
    for(auto& [name, count] : map){
        cout << name << ", " << count << endl;
    }
    
    int answer = min(nums.size()/2, map.size());
    
    return answer;
}