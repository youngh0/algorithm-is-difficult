import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sticks = br.readLine();

        Stack<Character> arr = new Stack<>();
        arr.push(sticks.charAt(0));

        char last = sticks.charAt(0);
        int answer = 0;
        for (int i = 1; i < sticks.length(); i++) {
            char cur = sticks.charAt(i);
            if (cur == '(') {
                arr.push(cur);
            } else {
                if (last == '(') {
                    arr.pop();
                    answer += arr.size();

                } else {
                    answer += 1;
                    arr.pop();
                }
            }
            last = cur;
        }
        System.out.println(answer);
    }
}
