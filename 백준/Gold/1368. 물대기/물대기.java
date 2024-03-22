

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            edges.add(new int[]{0, i + 1, value});
        }

        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {

                int value = Integer.parseInt(st.nextToken());
                if (i >= j) {
                    continue;
                }
                edges.add(new int[]{i, j, value});
            }
        }

        Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);

        int[] parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        int answer = 0;
        int count = 0;
        for (int[] edge : edges) {
            if (find(edge[0], parents) != find(edge[1], parents)) {
                answer += edge[2];
                union(edge[0], edge[1], parents);
                count++;
                if (count == n) {
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static int find(int target, int[] parents) {
        if (target == parents[target]) {
            return target;
        }
        return parents[target] = find(parents[target], parents);
    }

    public static void union(int a, int b, int[] parents) {
        a = find(a, parents);
        b = find(b, parents);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}
