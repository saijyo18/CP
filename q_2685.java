import java.util.*;

class q_2685 {

    List<Integer>[] graph;
    boolean[] visited;
    int vertices;
    int edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        visited = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                vertices = 0;
                edgeCount = 0;

                dfs(i);

                edgeCount /= 2;

                if (edgeCount == vertices * (vertices - 1) / 2)
                    ans++;
            }
        }

        return ans;
    }

    private void dfs(int node) {

        visited[node] = true;
        vertices++;

        edgeCount += graph[node].size();

        for (int nei : graph[node]) {
            if (!visited[nei])
                dfs(nei);
        }
    }
}