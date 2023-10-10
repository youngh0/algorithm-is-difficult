import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int paperNum = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            Deque<Paper> papers = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < paperNum; i++) {
                int importance = Integer.parseInt(st.nextToken());
                pq.add(importance);
                if (i == target) {
                    papers.addLast(new Paper(importance, true));
                } else {
                    papers.addLast(new Paper(importance, false));
                }
            }
            
            int order = 1;
            while (true) {
                Paper first = papers.removeFirst();
                if (first.importance == pq.peek()) {
                    if (first.isTarget()) {
                        System.out.println(order);
                        break;
                    }
                    pq.poll();
                    order++;
                } else {
                    papers.addLast(first);
                }

            }
        }
    }

    static class Paper {
        int importance;
        boolean isTarget;

        public Paper(int importance, boolean isTarget) {
            this.importance = importance;
            this.isTarget = isTarget;
        }

        public boolean isTarget() {
            return this.isTarget;
        }
    }
}
