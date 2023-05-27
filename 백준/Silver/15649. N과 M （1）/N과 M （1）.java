import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[9];
    static List<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        backTracking(0,m,n);
        bw.append(sb.toString());
        bw.close();
    }

    public static void backTracking(int depth, int m, int n) {
        if (depth == m) {
            for (Integer a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr.add(i);

                backTracking(depth+1, m,n);

                visited[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }
}
