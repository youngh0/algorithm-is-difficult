import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            Stack<Character> s = new Stack<>();
            String inputVal = br.readLine();
            s.push(inputVal.charAt(0));
            for (int j = 1; j < inputVal.length(); j++) {
                if (s.isEmpty()) {
                    s.push(inputVal.charAt(j));
                    continue;
                }
                if (s.peek() == inputVal.charAt(j)) {
                    s.pop();
                } else {
                    s.push(inputVal.charAt(j));
                }
            }

            if (s.isEmpty()) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
