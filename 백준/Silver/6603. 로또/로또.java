
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int k;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> tmp = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            arr = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backTracking(0,0);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void backTracking(int depth,int idx) {
        if (tmp.size() == 6) {
            for (Integer integer : tmp) {
                sb.append(integer).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = idx; i < k; i++) {
//            if (!visited[i]) {
                tmp.add(arr[i]);
                visited[i] = true;
                backTracking(depth + 1, i+1);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
//            }
        }
    }
}
