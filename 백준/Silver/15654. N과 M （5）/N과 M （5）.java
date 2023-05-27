import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> tmp = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        solution(0);
        System.out.println(sb);
    }

    public static void solution(int depth) {
        if (depth == m) {
            for (int i : tmp) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");

        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                tmp.add(arr[i]);

                solution(depth + 1);

                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }


    }
}
