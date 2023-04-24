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

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                dq.offerLast(num);
            } else if (command.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                dq.offerFirst(num);
            } else if (command.equals("pop_back")) {
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                } else sb.append(dq.pollLast()).append('\n');
            } else if (command.equals("pop_front")) {
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                } else sb.append(dq.pollFirst()).append('\n');
            } else if (command.equals("size")) {
                sb.append(dq.size()).append('\n');
            } else if (command.equals("empty")) {
                if (dq.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (command.equals("front")) {
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else sb.append(dq.peekFirst()).append('\n');
            }else if(command.equals("back")){
                if (dq.isEmpty()) {
                    sb.append(-1).append('\n');
                }
                else sb.append(dq.peekLast()).append('\n');
            }

        }

        System.out.println(sb);
    }
}
