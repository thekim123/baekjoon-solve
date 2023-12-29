package dfs;

import java.util.*;

public class No1260 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 정점의 개수
        int m = scanner.nextInt(); // 간선의 개수
        int v = scanner.nextInt() - 1; // 시작 정점 (1-인덱스를 0-인덱스로 변환)

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            int src = scanner.nextInt() - 1; // 1-인덱스를 0-인덱스로 변환
            int dest = scanner.nextInt() - 1; //1 -인덱스를 0-인덱스로 변환
            g.addEdge(src, dest);
        }

        System.out.println(g);

        g.DFS(v);
    }


    private static class Graph {
        private LinkedList<Integer>[] adjLists;
        private boolean[] visited;

        Graph(int vertices) {
            adjLists = new LinkedList[vertices];
            visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                adjLists[i] = new LinkedList<>();
            }
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "adjLists=" + Arrays.toString(adjLists) +
                    ", visited=" + Arrays.toString(visited) +
                    '}';
        }

        void addEdge(int src, int dest) {
            adjLists[src].add(dest);
            adjLists[dest].add(src); // 양방향 간선
        }

        void DFS(int vertex) {
            visited[vertex] = true;
            System.out.print((vertex + 1) + " "); // 정점 번호가 1부터 시작한다고 가정

            Collections.sort(adjLists[vertex]); // 정점 번호가 작은 것부터 방문

            Iterator<Integer> it = adjLists[vertex].listIterator();
            while (it.hasNext()) {
                int adj = it.next();
                if (!visited[adj]) {
                    DFS(adj);
                }
            }
        }
    }


}


