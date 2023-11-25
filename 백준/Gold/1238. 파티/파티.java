

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static Map<Integer, List<Town>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            List<Town> towns = graph.get(start);
            towns.add(new Town(end, cost));
        }

        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            if (x == i) {
                continue;
            }
            int goDistance = dijkstra(n, i, x);
            int backDistance = dijkstra(n, x, i);
            answer = Math.max(answer, goDistance + backDistance);
        }

        System.out.println(answer);
    }

    private static int dijkstra(int n, int start, int end) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int curTown = poll[0];
            int curCost = poll[1];

            if (distances[curTown] < curCost) {
                continue;
            }
            for (Town town : graph.get(curTown)) {
                if (curCost + town.cost < distances[town.num]) {
                    distances[town.num] = curCost + town.cost;
                    pq.add(new int[]{town.num, curCost + town.cost});
                }
            }
        }
        return distances[end];
    }

}

class Town {
    int num;
    int cost;

    public Town(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
}
