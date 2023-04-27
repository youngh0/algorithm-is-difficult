import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maps = new int[n][m];
        visited = new boolean[n][m];
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }


        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                maps[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs();

    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int dis = poll[2];


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == maps.length-1 && ny == maps[0].length-1) {
                    System.out.println(dis+1);
                    return;
                }

                if ((0 <= nx && nx < maps.length) && (0 <= ny && ny < maps[0].length)) {
                    if(visited[nx][ny] == false && maps[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dis + 1});
                    }

                }
            }
        }
    }
}
