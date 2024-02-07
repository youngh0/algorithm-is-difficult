

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> classList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classList.add(new int[]{start, end});
        }
        Collections.sort(classList, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> endPq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int start = classList.get(i)[0];
            int end = classList.get(i)[1];
//            System.out.println(start + " " + end);
            if (!endPq.isEmpty() && start >= endPq.peek()) {
                endPq.poll();
            }
            endPq.add(end);
        }

        System.out.println(endPq.size());
    }
}
