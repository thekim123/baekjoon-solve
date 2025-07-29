#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Task {
	int index;
	int time;
	int money;
};

bool compare(Task a, Task b) {
	int index_a = a.money * b.time;
	int index_b = b.money * a.time;
	if (index_a != index_b) return index_a > index_b;
	return a.index < b.index;
}

int main() {
	int n;
	cin >> n;

	vector<Task> tasks(n);
	for (int i = 0; i < n; i++) {
		int time, money;
		cin >> time >> money;
		tasks[i] = Task{ i, time, money };
	}
	sort(tasks.begin(), tasks.end(), compare);

	for (int i = 0; i < n; i++) {
		cout << tasks[i].index +1 << " ";
	}

}