

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<int[]>> map = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(src).add(new int[]{dest, cost});
            map.get(dest).add(new int[]{src, cost});
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long distA = 0;
        long distB = 0;

        distA += dijkstra(1, v, map, v1);
        distA += dijkstra(v1, v, map, v2);
        distA += dijkstra(v2, v, map, v);

        distB += dijkstra(1, v, map, v2);
        distB += dijkstra(v2, v, map, v1);
        distB += dijkstra(v1, v, map, v);

        long answer = (distA >= Integer.MAX_VALUE && distB >= Integer.MAX_VALUE) ? -1 : Math.min(distA, distB);

        System.out.println(answer);
    }

    public static int dijkstra(int start, int v, List<List<int[]>> map, int end) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int cur = polled[0];
            int curCost = polled[1];

            if (dist[cur] < curCost) {
                continue;
            }

            for (int[] neighbor : map.get(cur)) {
                int nextNode = neighbor[0];
                int nextCost = neighbor[1];

                int total = curCost + nextCost;
                if (dist[nextNode] > total) {
                    pq.add(new int[]{nextNode, total});
                    dist[nextNode] = total;
                }
            }
        }
        return dist[end];
    }
}
