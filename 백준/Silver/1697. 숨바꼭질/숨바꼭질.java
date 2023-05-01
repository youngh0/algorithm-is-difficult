import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] distance = new int[200_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(distance, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        distance[N] = 0;
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            int[] ds = new int[]{1, -1, cur};

            for (int i = 0; i < 3; i++) {

                int nx = cur + ds[i];
                if(nx > 100000 || nx < 0) continue;
                if(distance[nx] != -1) continue;
                distance[nx] = distance[cur] + 1;
                if (nx == K){
                    System.out.println(distance[K]);
                    return;
                }

                q.offer(nx);
            }
        }

        System.out.println(distance[K]);
    }
}
