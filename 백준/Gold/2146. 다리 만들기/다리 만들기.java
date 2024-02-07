

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][n];
        int region = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j, map, visited, region);
                    region++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    bfs(i, j, map);
                }
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int row, int col, int[][] map) {
        int curRegion = map[row][col];
        boolean[][] visited = new boolean[map.length][map.length];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col, 0});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cr = poll[0];
            int cc = poll[1];
            int dist = poll[2];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dx[i];
                int nc = cc + dy[i];

                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) {
                    continue;
                }
                if (map[nr][nc] == curRegion || visited[nr][nc]) {
                    continue;
                }
                if ((map[nr][nc] != 0 && map[nr][nc] != curRegion)) {
//                    System.out.println(row + " " + col + " -> " + nr + " " + nc);
                    answer = Math.min(answer, dist);
                    continue;
                }
                q.add(new int[]{nr, nc, dist + 1});
                visited[nr][nc] = true;
            }
        }
    }

    public static void dfs(int row, int col, int[][] map, boolean[][] visited, int region) {
        map[row][col] = region;

        for (int i = 0; i < 4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            if (nr < 0 || nr >= map.length || nc < 0 || nc >= map.length) {
                continue;
            }
            if (map[nr][nc] == 0 || map[nr][nc] != 1 || visited[nr][nc]) {
                continue;
            }
            dfs(nr, nc, map, visited, region);
        }
    }
}
