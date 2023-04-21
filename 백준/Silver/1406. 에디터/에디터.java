import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initWord = br.readLine();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        for (int i = 0; i < initWord.length(); i++) {
            left.offer(initWord.charAt(i));
        }

        int commands = Integer.parseInt(br.readLine());
        for (int i = 0; i < commands; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("L")) {
                if (left.isEmpty()) {
                    continue;
                }

                Character character = left.removeLast();
                right.offerFirst(character);
            } else if (command.equals("D")) {
                if (right.isEmpty()) {
                    continue;
                }

                Character letter = right.removeFirst();
                left.offerLast(letter);

            } else if (command.equals("B")) {
                if (left.isEmpty()) {
                    continue;
                }
                left.removeLast();

            } else if (command.equals("P")) {
                char letter = st.nextToken().charAt(0);
                left.offerLast(letter);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (Character character : left) {
            answer.append(character);
        }
        for (Character character : right) {
            answer.append(character);
        }
        System.out.print(answer);
    }
}
