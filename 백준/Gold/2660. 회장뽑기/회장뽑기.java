

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int n;
    static int[] depthArray;
    static int chairMan = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        depthArray = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == -1 && end == -1) {
                break;
            }

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 1; i < n + 1; i++) {
            bfs(i);
        }
        List<Integer> chairManList = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (depthArray[i] == chairMan) {
                chairManList.add(i);
            }
        }
        Collections.sort(chairManList);
        System.out.println(chairMan + " " + chairManList.size());
        for (Integer integer : chairManList) {
            System.out.print(integer + " ");
        }

    }

    public static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        boolean[] visited = new boolean[n + 1];

        visited[start] = true;
        int maxDepth = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int member = poll[0];
            int depth = poll[1];

            for (int friend : graph.get(member)) {
                if (visited[friend]) {
                    continue;
                }
                q.add(new int[]{friend, depth + 1});
                maxDepth = Math.max(maxDepth, depth + 1);
                visited[friend] = true;
            }
        }

        depthArray[start] = maxDepth;
        chairMan = Math.min(chairMan, maxDepth);
    }
}
