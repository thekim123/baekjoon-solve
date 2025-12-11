#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> weights;
vector<int> values;
vector<int> counts;

int BottomUpKnapsack(int M) {
	vector<int> newWeights;
	vector<int> newValues;

	for (int i = 0; i < weights.size(); i++) {
		int w = weights[i];
		int v = values[i];
		int k = counts[i];

		int power = 1;
		while (k > 0) {
			int take = min(power, k);   // 이번에 묶을 개수 (1, 2, 4, ..., 나머지)
			newWeights.push_back(w * take);
			newValues.push_back(v * take);
			k -= take;
			power <<= 1;               // power *= 2;
		}
	}

	int N2 = (int)newWeights.size();
	vector<vector<int>> table(M + 1, vector<int>(N2 + 1, 0));


	for (int w = 0; w <= M; w++) {
		for (int n = 1; n <= newWeights.size(); n++) {
			int weight = newWeights[n - 1];
			int value = newValues[n - 1];

			table[w][n] = table[w][n - 1];
			if (weight > w) continue;
			table[w][n] = max(
				table[w - weight][n - 1] + value,
				table[w][n]
			);
		}
	}

	return table[M][N2];
}

int main() {
	int N, M;
	cin >> N >> M;
	weights.resize(N); values.resize(N); counts.resize(N);

	int V, C, K;
	for (int i = 0; i < N; i++) {
		cin >> V >> C >> K;
		weights[i] = V; values[i] = C; counts[i] = K;
	}

	int result = BottomUpKnapsack(M);
	cout << result;
}
