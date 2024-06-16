

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> tmp = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static StringTokenizer st;
    static boolean[][] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[m][n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solution();
        System.out.println(sb);
    }

    static void solution() {
        if (tmp.size() == m) {
            for (Integer integer : tmp) {
                sb.append(integer).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < n; i++) {
            tmp.add(arr[i]);
            solution();
            tmp.remove(tmp.size() - 1);
        }

    }

}
