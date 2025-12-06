#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <unordered_map>
#include <map>
#include <assert.h>
using namespace std;

struct Vertex
{
	Vertex(int v)
	{
		value = v;
	}

	int value = -1;

	bool visited = false;

	vector<Vertex*> out_neighbors;
	vector<Vertex*> in_neighbors; // 선행 정점 방문 확인용
};

struct Cmp {
	bool operator()(Vertex* a, Vertex* b) const { return a->value > b->value;  }
};

class Graph
{
public:
	Graph(int num_vertices)
	{
		vertices.resize(num_vertices);
		for (int i = 0; i < num_vertices; i++)
			vertices[i] = new Vertex(i);
	}

	~Graph()
	{
		for (auto* v : vertices)
			delete v;
	}

	void AddDiEdge(int v, int w)
	{
		vertices[v]->out_neighbors.push_back(vertices[w]);
		vertices[w]->in_neighbors.push_back(vertices[v]); // 선행 정점 방문 확인용
	}

	void PrecedenceCheck(stack<Vertex*> my_stack) // my_stack의 사본
	{
		for (auto* v : this->vertices)
			v->visited = false;

		while (!my_stack.empty())
		{
			Vertex* v = my_stack.top();
			cout << "Precedence check " << v->value << " : ";
			for (auto* w : v->in_neighbors)
			{
				// 선수조건을 만족했는지 확인
				if (!w->visited)
				{
					cout << "Wrong" << endl;
					exit(-1);
				}
				else {
					cout << w->value << ", ";
				}
			}
			cout << endl;
			v->visited = true;
			my_stack.pop();
		}
		cout << "OK" << endl;
	}

	stack<Vertex*> QueueBasedTopologicalSort()
	{
		vector<int> indegree(vertices.size()); // indegree를 Vertex에 저장할 수도 있습니다.
        for (auto *v : vertices) {
            for (auto *b : v->out_neighbors) {
				indegree[b->value]++;
            }
        }


		//queue<Vertex*> q;
        priority_queue<Vertex *, vector<Vertex *>, Cmp> pq;

        for (int i = 0; i < vertices.size(); i++) {
            if (indegree[i] == 0) {
				pq.push(vertices[i]);
			}
        }
		// indegree가 0인 vertex들을 q에 넣기
		// TODO:

		vector<Vertex*> result;
        while (!pq.empty()) {
	      Vertex *v = pq.top();
          pq.pop();
		  
		  result.push_back(v);

		  for (auto *w : v->out_neighbors) {
                indegree[w->value]--;
                if (indegree[w->value] == 0) {
                    pq.push(w);
				}
		  }
		}
		// TODO:

		// 뒤에서 DFS 방식 예제와의 호환성을 위해 역순으로 stack에 저장
		stack<Vertex*> s;
		for (auto i = result.rbegin(); i != result.rend(); i++)
			s.push(*i);

		return s;
	}
private:
	vector<Vertex*> vertices;
};

int main()
{
  int N, M;
  cin >> N >> M;
  Graph g(N);
  for (int i = 0; i < M; i++) {
    int v, w;
    cin >> v >> w;
    g.AddDiEdge(v-1, w-1);
  }
  stack<Vertex*> my_stack =  g.QueueBasedTopologicalSort();
  //g.PrecedenceCheck(my_stack);

  while (!my_stack.empty()) {
    cout << my_stack.top()->value +1 << " ";
    my_stack.pop();
  }
	
  return 0;
}
