#include <iostream>
#include <vector>

using namespace std;

vector<int> dist;
int N;

int BFS(vector<pair<int, int>> &schedule, int day, int result) {
  if (day >= N)
    return result;
  int result1 = BFS(schedule, day+1, result);

  if (day + schedule[day].first > N)
    return result1;

  int go = schedule[day].second;
  result += go;
  int result2 = BFS(schedule, day + schedule[day].first, result);
  if (result1 > result2) {
    return result1;
  } else {
    return result2;
  }
}

int main() {
  cin >> N;

  dist.resize(N, 0);
  vector<pair<int, int>> schedule(N);

  for (int i = 0; i < N; i++) {
    cin >> schedule[i].first >> schedule[i].second;
  }


  cout << BFS(schedule, 0, 0);


}