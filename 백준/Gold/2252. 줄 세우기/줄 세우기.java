

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }
        int[] deg = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            deg[end] += 1;
            map.get(start).add(end);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (deg[i] == 0) {
                dq.addLast(i);
            }
        }

        while (!dq.isEmpty()) {
            Integer cur = dq.pollFirst();
            System.out.print(cur + " ");
            for (int i : map.get(cur)) {
                deg[i] -= 1;
                if (deg[i] == 0) {
                    dq.addLast(i);
                }
            }
        }


    }
}
