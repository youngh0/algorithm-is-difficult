import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(q.peek()).append('\n');
                }
            } else if (command.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(q.peekLast()).append('\n');
                }
            } else if (command.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (command.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(q.poll()).append('\n');
                }
            } else if (command.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (command.equals("push")) {
                q.offer(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(sb);
    }
}
