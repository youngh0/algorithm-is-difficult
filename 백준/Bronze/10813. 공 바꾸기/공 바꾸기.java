

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] buckets = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            buckets[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int tmp = buckets[src];

            buckets[src] = buckets[target];
            buckets[target] = tmp;
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(buckets[i] + " ");
        }
    }
}
