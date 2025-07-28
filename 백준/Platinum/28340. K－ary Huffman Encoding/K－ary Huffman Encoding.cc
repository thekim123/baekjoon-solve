// ConsoleApplication3.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;

struct Node {
	int value;
	int freq;
	vector<Node*> tree;
};

struct Compare {
	bool operator()(Node* a, Node* b) {
		return a->freq > b->freq;
	}
};

priority_queue<Node*, vector<Node*>, Compare> BuildArr(int arr_size) {
	priority_queue<Node*, vector<Node*>, Compare> pq;
	for(int i=0; i < arr_size; i++){
		int freq;
		cin >> freq;
		pq.push(new Node{i, freq});
	}
	return pq;
}


long long SumCost(Node* root, int depth)
{
	if (!root)
		return 0;

	if (root->tree.empty()) {
		//cout << root->value << ": " << str << ", freq: " << root->freq << "\n";
		return 1LL * depth * root->freq;
	}

	long long result = 0;
	for (auto child: root->tree) {
		result += SumCost(child, depth+1);
	}

	return result;
}

void DeleteTree(Node* root) {
	if (!root) return;
	for (auto child : root->tree) {
		DeleteTree(child);
	}
	delete root;
}

void HuffmanEncoding() {
	int arr_size, bit;
	cin >> arr_size >> bit;

	priority_queue<Node*, vector<Node*>, Compare> pq = BuildArr(arr_size);

	// 패딩: (n-1) % (bit-1) == 0 이 되도록 0 freq dummy 추가
	int need = (bit - 1 - ((arr_size - 1) % (bit - 1))) % (bit - 1);
	for (int i = 0; i < need; ++i) {
		pq.push(new Node{ -1, 0, {} });  // dummy node
	}

	while(pq.size() > 1){
		int value = 0;
		int total_freq = 0;
		vector<Node*> tree;
		for (int i = 0; i < bit; i++) {
			Node* node = pq.top();
			tree.push_back(node);
			value += node->value;
			total_freq += node->freq;
			// cout << "(" << "i: " << i << ", val: " << node->value << ", " << "), ";
			pq.pop();
		}
		Node* new_node = new Node{ value, total_freq, tree };
		pq.push(new_node);

		// cout << " -> ( new_node: " << new_node->value << ")" << endl;
	}

	long long result = SumCost(pq.top(), 0);
	cout << result << endl;
	DeleteTree(pq.top());  // ⭐ 메모리 해제


}

int main()
{
 
	int test_count;
	cin >> test_count;
	
	for (int i = 0; i < test_count; i++) {
		HuffmanEncoding();
	}


}