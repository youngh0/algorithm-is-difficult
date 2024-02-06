

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            answer++;
            int zeroCount = 2 * row + (col * 2 - 4);
            boolean[][] isIce = new boolean[row][col];
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (map[i][j] != 0) {
                        isIce[i][j] = true;
                    } else {
                        zeroCount++;
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int count = 0;
                    for (int q = 0; q < 4; q++) {
                        int ni = i + dx[q];
                        int nj = j + dy[q];
                        if (ni < 0 || ni > row - 1 || nj < 0 || nj > col - 1) {
                            continue;
                        }
                        if (!isIce[ni][nj]) {
                            count++;
                        }
                    }
                    map[i][j] = Math.max(map[i][j] - count, 0);
                }
            }

            boolean[][] visited = new boolean[row][col];

            int count = 0;
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        bfs(map, visited, i, j);
                        count++;
                    }
                }
            }
//            System.out.println("count: " + count);
            if (count >= 2) {
                System.out.println(answer);
                return;
            }

            if (zeroCount == row * col) {
                System.out.println(0);
                return;
            }

        }
    }

    static void bfs(int[][] map, boolean[][] visited, int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 1 || nr > map.length - 2 || nc < 1 || nc > map[0].length - 2) {
                    continue;
                }
                if (visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
