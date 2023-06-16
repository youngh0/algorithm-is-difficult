import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] arr;
    static boolean[] visited;
    static int n;
    static ArrayList<Integer> tmp = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String inputValue = br.readLine();
            if (inputValue.length() == 1) {
                break;
            }
            st = new StringTokenizer(inputValue);

            n = Integer.parseInt(st.nextToken());

            arr = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            solution(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void solution(int depth, int start) {
        if (depth == 6) {
            for (Integer a : tmp) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(arr[i]);

                solution(depth+1, i+1);

                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
