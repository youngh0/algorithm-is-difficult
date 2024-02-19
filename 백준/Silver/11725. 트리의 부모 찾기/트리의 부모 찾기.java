

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        int[] parents = new int[v + 1];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < v - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            tree.get(first).add(second);
            tree.get(second).add(first);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int child : tree.get(cur)) {
                if (parents[child] != 0) {
                    continue;
                }
                parents[child] = cur;
                q.add(child);
            }
        }
        for (int i = 2; i < v + 1; i++) {
            System.out.println(parents[i]);
        }
    }
}
