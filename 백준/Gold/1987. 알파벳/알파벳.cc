#include <iostream>
#include <vector>

using namespace std;

int DFS(int i, int j, int result, vector<vector<char>>& arr, vector<bool>& visit) {
	int cur_index = arr[i][j] - 65;
	if (visit[cur_index]) return result;
	
	int temp1, temp2, temp3, temp4;
	result++;
	temp1 = temp2 = temp3 = temp4 = result;
	visit[cur_index] = true;
	if(i+1<(int)arr.size()) temp1 = DFS(i+1, j, temp1, arr, visit);
	if(i>0) temp2 = DFS(i-1, j, temp2,arr, visit);
	if(j+1<(int)arr[i].size()) temp3 = DFS(i, j + 1, temp3, arr, visit);
	if(j>0) temp4 = DFS(i, j-1, temp4,arr, visit);
	visit[cur_index] = false;

	return max(max(temp1, temp2), max(temp3,temp4));
}

int main() {
	int R, C;
	cin >> R >> C;

	vector<vector<char>> arr(R, vector<char>(C));
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin>>arr[i][j];
		}
	}

	vector<bool> visit(26);
	int result = DFS(0, 0, 0,arr, visit);
	cout << result;
}
