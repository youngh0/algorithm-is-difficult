import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int q = 0; q < T; q++) {
            String commands = br.readLine();
            int numCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < numCount; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean isFirst = true;
            boolean isError = false;

            for (int i = 0; i < commands.length(); i++) {
                char command = commands.charAt(i);

                if (command == 'R') {
                    isFirst = !isFirst;
                    continue;
                }
                if (dq.isEmpty()) {
                    isError = true;
                    break;
                }
                if (isFirst) {
                    dq.pollFirst();
                } else {
                    dq.pollLast();
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                int size = dq.size();
                StringJoiner sj = new StringJoiner(",", "[", "]");
                if (isFirst) {
                    for (int i = 0; i < size; i++) {
                        sj.add(String.valueOf(dq.pollFirst()));
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        sj.add(String.valueOf(dq.pollLast()));
                    }
                }

                System.out.println(sj);
            }
        }
    }
}
