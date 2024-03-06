import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            dq.add(i);
        }

        List<Integer> targets = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            targets.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int target : targets) {
            int idx = 0;
            for (int d : dq) {
                if (d == target) {
                    break;
                }
                idx += 1;
            }
            int half;
            if (dq.size() % 2 == 0) {
                half = dq.size() / 2 - 1;
            } else {
                half = dq.size() / 2;
            }
            if (idx <= half) {
                //앞에서 빼기
                for (int i = 0; i < idx; i++) {
                    answer += 1;
                    dq.offerLast(dq.pollFirst());
                }
            } else {

                for (int i = 0; i < dq.size() - idx; i++) {
                    answer += 1;
                    dq.offerFirst(dq.pollLast());
                }
            }
            dq.pollFirst();
        }
        System.out.println(answer);
    }
}
