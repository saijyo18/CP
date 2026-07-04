class q_2492 {
    List<int[]>[] graph;
    boolean[] vis;
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        vis = new boolean[n + 1];
        dfs(1);

        return ans;
    }

    private void dfs(int u) {
        vis[u] = true;

        for (int[] edge : graph[u]) {
            int v = edge[0];
            int w = edge[1];

            ans = Math.min(ans, w);

            if (!vis[v])
                dfs(v);
        }
    }
}