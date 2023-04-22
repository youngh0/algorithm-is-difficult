import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        StringJoiner sj = new StringJoiner(", ","<",">");
        for (Integer integer : answer) {
            sj.add(String.valueOf(integer));
        }

        System.out.println(sj);
    }
}
