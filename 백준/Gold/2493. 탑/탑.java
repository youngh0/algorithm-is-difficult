import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> arr = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        int deleteCount = 0;
        boolean flag = false;
        StringJoiner answer = new StringJoiner(" ");
        for (int i = 0; i < N; i++) {
            int tmpDeleteCount = 0;
            int num = Integer.parseInt(st.nextToken());

            while (!arr.isEmpty() && arr.peek() < num ) {
                arr.pop();
                idx.pop();
                tmpDeleteCount += 1;
            }

            if (arr.isEmpty()) {
                arr.add(num);
                idx.add(i + 1);
                answer.add("0");
            } else if (arr.peek() > num) {
                answer.add(String.valueOf(idx.peek()));
                arr.add(num);
                idx.add(i + 1);

                flag = true;
            }

            deleteCount += tmpDeleteCount;
        }
        if (flag) {
            System.out.print(answer);
        }else System.out.print(0);

    }
}
