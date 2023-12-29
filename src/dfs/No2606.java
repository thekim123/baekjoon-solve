package dfs;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class No2606 {

    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            g.addEdge(src, dest);
        }

        g.DFS(0);
        System.out.println(count);

    }


    private static class Graph {
        private LinkedList<Integer>[] lists;
        private boolean[] visited;

        public Graph(int vertices) {
            lists = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                lists[i] = new LinkedList<>();
            }
            visited = new boolean[vertices];
        }

        void addEdge(int src, int dest) {
            lists[src].add(dest);
            lists[dest].add(src); // 양방향 간선
        }

        void DFS(int vertex) {
            visited[vertex] = true;
            Collections.sort(lists[vertex]); // 정점 번호가 작은 것부터 방문

            Iterator<Integer> it = lists[vertex].listIterator();
            while (it.hasNext()) {
                int adj = it.next();
                if (!visited[adj]) {
                    count++;
                    DFS(adj);
                }
            }
        }
    }
}
