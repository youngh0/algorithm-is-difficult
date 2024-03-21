

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        List<List<int[]>> map = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(from).add(new int[]{to, cost});
        }

        int[] distance = new int[n + 1];
        int[] pre = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        distance[start] = 0;
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int curNode = polled[0];
            int curCost = polled[1];

            if (distance[curNode] < curCost) {
                continue;
            }

            for (int[] nodes : map.get(curNode)) {
                int nextNode = nodes[0];
                int nextCost = nodes[1];
                if (distance[nextNode] > nextCost + curCost) {
                    pq.add(new int[]{nextNode, curCost + nextCost});
                    distance[nextNode] = curCost + nextCost;
                    pre[nextNode] = curNode;
                }
            }
        }
        System.out.println(distance[end]);
        List<Integer> path = new ArrayList<>();
        int cur = end;
        while (cur != start) {
            path.add(cur);
            cur = pre[cur];
        }
        path.add(start);
        System.out.println(path.size());
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}
