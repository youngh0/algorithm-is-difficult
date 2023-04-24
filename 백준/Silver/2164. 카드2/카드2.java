import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            q.offer(i);
        }

        while (q.size() > 2) {
            q.poll();
            q.offer(q.poll());
        }
        if (N == 1) {
            System.out.println(q.peek());
        } else {
            q.poll();
            System.out.println(q.peek());
        }
    }
}
