import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] board;
    static boolean[][][] visited;
    static int[] dx = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dy = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int matrix = Integer.parseInt(st.nextToken());

        board = new int[row][col][matrix];
        visited = new boolean[row][col][matrix];

        Queue<int[]> q = new LinkedList<>();
        int total = row * col * matrix;

        for (int z = 0; z < matrix; z++) {
            for (int x = 0; x < row; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < col; y++) {
                    board[x][y][z] = Integer.parseInt(st.nextToken());
                    if (board[x][y][z] == 1) {
                        q.offer(new int[]{x, y, z, 0});
                        visited[x][y][z] = true;
                    } else if (board[x][y][z] == -1) {
                        total -= 1;
                    }
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
            int distance = cur[3] + 1;

            tomato += 1;

            for (int i = 0; i < 6; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[2] + dz[i];

                if (nx < 0 || nx >= row|| ny < 0 || ny >= col || nz < 0 || nz >= matrix) continue;
                if (board[nx][ny][nz] != 0 || visited[nx][ny][nz]) continue;

                q.offer(new int[]{nx, ny, nz, distance});
                visited[nx][ny][nz] = true;
                maxNum = Math.max(distance, maxNum);
            }
            
        }

        if (total == tomato) {
            System.out.println(maxNum);
        } else System.out.println(-1);
    }
}
