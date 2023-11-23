import java.util.*;

class Solution {
    static List<ArrayList<Edge>> graph = new ArrayList<>();
    static HashSet<Integer> gate = new HashSet<>();
    static HashSet<Integer> summit = new HashSet<>();
    static int[] dp;
    static final int INF = 1_000_000_000;

    static class Edge {
        int a;
        int cost;

        Edge(int a, int cost) {
            this.a = a;
            this.cost = cost;
        }
    }

    static void bfs(int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {c, 0});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            if (summit.contains(p[0])) {
                continue;
            }

            for (Edge edge : graph.get(p[0])) {
                if (!gate.contains(edge.a)) {
                    int nextValue = Math.max(p[1], edge.cost);

                    if (nextValue < dp[edge.a]) {
                        queue.add(new int[] {edge.a, nextValue});
                        dp[edge.a] = nextValue;
                    }
                }
            }
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dp[i] = INF;
        }

        for (int i = 0; i < gates.length; i++) {
            gate.add(gates[i]); // gate 추가
        }

        for (int i = 0; i < summits.length; i++) {
            summit.add(summits[i]);
        }

        for (int i = 0; i < paths.length; i++) {
            graph.get(paths[i][0]).add(new Edge(paths[i][1], paths[i][2]));
            graph.get(paths[i][1]).add(new Edge(paths[i][0], paths[i][2]));
        }

        int[] res = new int[] {0, INF};

        for (Integer start : gate) {
            bfs(start);
        }

        for (Integer mount : summit) {
            if (res[1] >= dp[mount]) {
                if (res[1] == dp[mount]) {
                    if (res[0] > mount) {
                        res[0] = mount;
                        res[1] = dp[mount];    
                    }
                } else {
                    res[0] = mount;
                    res[1] = dp[mount];
                }
            }
        }

        return res;
    }
}
