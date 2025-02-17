#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <unordered_map>
#include <map>
using namespace std;

struct Vertex
{
	Vertex(int v)
	{
		value = v; // ID (디버깅용)
	}

	int value = -1;

	bool visited = false;

	vector<Vertex*> out_neighbors;
	vector<Vertex*> in_neighbors; // 검증용
};

class Graph
{
public:
	// 방문 순서 확인용 (pre/post와 revPost 비교해보세요)
	queue<Vertex*> pre;
	queue<Vertex*> post;
	stack<Vertex*> revPost;

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
		vertices[w]->in_neighbors.push_back(vertices[v]);
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

	stack<Vertex*> TopologicalSort()
	{
		pre = queue<Vertex*>();
		post = queue<Vertex*>();
		revPost = stack<Vertex*>();

		for (auto* v : this->vertices)
		{
			v->visited = false;
		}

		for (auto* v : this->vertices)
		{
			if (!v->visited)
			{
				TopologicalSortHelper(v);
			}
		}

		return revPost;
	}

private:
	vector<Vertex*> vertices;

	void TopologicalSortHelper(Vertex* v)
	{
		pre.push(v);
		v->visited = true;
		for (auto* w : v->out_neighbors)
		{
			if (!w->visited)
			{
				TopologicalSortHelper(w);
			}
		}
		revPost.push(v);
		post.push(v);
	}
};

int main()
{
	{
		int n, m;
		cin >> n >> m;
		Graph g(n);
		for (int i = 0; i < m; i++)
		{
			int a, b;
			cin >> a >> b;
			g.AddDiEdge(a-1, b-1);
		}

		auto my_stack = g.TopologicalSort();

		//g.PrecedenceCheck(my_stack);

		while (!my_stack.empty())
		{
			cout << my_stack.top()->value+1;
			my_stack.pop();
			if (!my_stack.empty())
				cout << " ";
		}
		cout << endl;
	}

	return 0;
}
