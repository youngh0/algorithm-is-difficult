import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[] dm = new int[]{1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int matrix = Integer.parseInt(st.nextToken());

        board = new int[row * matrix][col];
        visited = new boolean[row * matrix][col];

        Queue<int[]> q = new LinkedList<>();
        int total = row * col * matrix;

        for (int i = 0; i < row * matrix; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                } else if (board[i][j] == -1) {
                    total -= 1;
                }
            }
        }

        if (total == q.size()) {
            System.out.println(0);
            return;
        }

        int maxNum = 0;
        int tomato = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int distance = cur[2] + 1;

            tomato += 1;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= row * matrix|| ny < 0 || ny >= col) continue;
                if (board[nx][ny] != 0 || visited[nx][ny]) continue;
                if(cur[0] % row == 0 && i==3 ) continue;
                if(cur[0] % row == row -1 && i == 2) continue;
                q.offer(new int[]{nx, ny, distance});
                visited[nx][ny] = true;
                maxNum = Math.max(distance, maxNum);
            }

            for (int i = 0; i < 2; i++) {
                int nx = cur[0] + (dm[i] * row);
                int ny = cur[1];

                if (nx < 0 || nx >= row * matrix || ny < 0 || ny >= col) continue;
                if (board[nx][ny] != 0 || visited[nx][ny]) continue;

                q.offer(new int[]{nx, ny, distance});
                visited[nx][ny] = true;
                maxNum = Math.max(distance, maxNum);
            }
        }

        if (total == tomato) {
            System.out.println(maxNum);
        } else System.out.println(-1);
    }
}
