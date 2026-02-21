#include <string>
#include <vector>
#include <iostream>

using namespace std;

int answer = 0;

void dfs(vector<int>& numbers, int target, int i, int result) {
                //cout << "i: " << i << ", result: " << result << ", answer: " << answer << endl;

    if(i==numbers.size()){ 

        if(result == target){
            answer++;
        }
        return;
    }
    dfs(numbers, target, i+1, result+numbers[i]);
    dfs(numbers, target, i+1, result-numbers[i]);
}

int solution(vector<int> numbers, int target) {
    answer = 0;
    dfs(numbers, target, 0, 0);
    return answer;
}
