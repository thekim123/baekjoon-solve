#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> players, int m, int k) {
    int answer = 0;

    int runningServersCount = 0;
    vector<int> servers(24, 0);
    for (int i = 0; i < players.size(); i++) {
        if (players[i]/m > 0) {
            int restPeople = players[i] - servers[i] * m;
            if (restPeople > 0) {
                int needToIncrease = (restPeople / m);
                answer += needToIncrease;

                for (int cap = 0; cap < k; cap++) {
                    if (i + cap >= players.size()) break;
                    servers[i+cap] = servers[i+cap] + needToIncrease;
                }
               
            }
        }
    }
    
    return answer;
}