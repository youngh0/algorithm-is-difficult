

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        if (row == 1 && col == 1) {
            System.out.println(1);
            return;
        }

        board = new char[row][col];
        visited = new boolean[2][row][col];

        for (int i = 0; i < row; i++) {
            String oneRow = br.readLine();
            for (int j = 0; j < oneRow.length(); j++) {
                board[i][j] = oneRow.charAt(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int breakCount = poll[2];
            int weight = poll[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                if (nx == row - 1 && ny == col - 1) {
                    System.out.println(weight + 1);
                    return;
                }
                //벽 부순 경우
                if (breakCount == 1) {
                    // 다음 맵이 벽, 벽을 뚫었는데도 목적지가 이미 방문된 경우
                    if (board[nx][ny] == '1' || visited[1][nx][ny] || visited[0][nx][ny]) {
                        continue;
                    }
                    q.offer(new int[]{nx, ny, breakCount, weight + 1});
                    visited[1][nx][ny] = true;
                } else {
                    if (visited[0][nx][ny]) {
                        continue;
                    }
                    if (board[nx][ny] == '1' && !visited[1][nx][ny]) {
                        q.offer(new int[]{nx, ny, 1, weight + 1});
                        // 벽인 칸에 올 수 있는건 아직 벽을 안부순 경우
                        visited[1][nx][ny] = true;
                        visited[0][nx][ny] = true;
                        continue;
                    }

                    q.offer(new int[]{nx, ny, breakCount, weight + 1});
                    visited[0][nx][ny] = true;
                }
            }

        }
        System.out.println(-1);
    }
}
