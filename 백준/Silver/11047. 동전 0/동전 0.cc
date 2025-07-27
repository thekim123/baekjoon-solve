#include <iostream>
#include <vector>
#include <algorithm>
#include <functional> // greater
#include <climits>    // INT_MAX (안 쓰면 빼도 됨)

using namespace std;

int main()
{
	int size, total_count;
	cin >> size >> total_count;

	vector<int> arr(size, 0);

	for (int i = 0; i < arr.size(); i++) {
		int temp;
		cin >> temp;
		arr[i] = temp;
	}
	sort(arr.begin(), arr.end(), greater<int>());

	int index = 0;
	int min_sum = INT_MAX;
	int count = 0;
	while (index < arr.size()) {
		if (arr[index] > total_count) {
			index++;
			continue;
		}

		while (total_count >= arr[index]) {
			total_count -= arr[index];
			count++;
		}
		index++;
	}

	cout << count;
	return 0;
}
