import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String inputValue = br.readLine();
            String[] arr = inputValue.split("");
            Deque<String> left = new ArrayDeque<>();
            Deque<String> right = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            for (String command : arr) {
                if (command.equals("<")) {
                    if (left.isEmpty()) {
                        continue;
                    }
                    String removeVal = left.pollLast();
                    right.offerFirst(removeVal);
                } else if (command.equals(">")) {
                    if (right.isEmpty()) {
                        continue;
                    }
                    String removeVal = right.pollFirst();
                    left.offerLast(removeVal);
                } else if (command.equals("-")) {
                    if (left.isEmpty()) {
                        continue;
                    }
                    left.pollLast();
                } else {
                    left.offerLast(command);
                }
            }
            for (String s : left) {
                sb.append(s);
            }for (String s : right) {
                sb.append(s);
            }
            System.out.println(sb);
        }

    }
}
