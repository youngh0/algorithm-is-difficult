import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static String[][] board;
    static boolean[][] visited;
    static int[][] timeTable;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        board = new String[row][col];
        visited = new boolean[row][col];
        timeTable = new int[row][col];
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> jQ = new LinkedList<>();

        for (int[] ints : timeTable) {
            Arrays.fill(ints,-1);
        }

        for (int i = 0; i < row; i++) {
            String oneRow = br.readLine();
            for (int j = 0; j < oneRow.length(); j++) {
                board[i][j] = String.valueOf(oneRow.charAt(j));
                if (board[i][j].equals("F")) {
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                    timeTable[i][j] = 0;
                }
                if (board[i][j].equals("J")) {
                    jQ.offer(new int[]{i, j, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int time = cur[2] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx > row-1 || ny < 0 || ny > col-1) continue;
                if(visited[nx][ny] || board[nx][ny].equals("#")) continue;
                q.offer(new int[]{nx, ny, time});
                board[nx][ny] = "F";
                visited[nx][ny] = true;
                timeTable[nx][ny] = time;
            }
        }

//        for (int[] ints : timeTable) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

        visited = new boolean[row][col];
        int[] peek = jQ.peek();
        visited[peek[0]][peek[1]] = true;

        while (!jQ.isEmpty()) {
            int[] cur = jQ.poll();
            int time = cur[2] + 1;

            if (cur[0] == 0 || cur[0] == row - 1 || cur[1] == 0 || cur[1] == col - 1) {
                System.out.println(time);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx > row-1 || ny < 0 || ny > col-1) continue;
                if(visited[nx][ny] || board[nx][ny].equals("#")) continue;
                if(time>=timeTable[nx][ny] && timeTable[nx][ny] != -1)continue;

                jQ.offer(new int[]{nx, ny, time});
                visited[nx][ny] = true;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
