
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int startDir = Integer.parseInt(st.nextToken());
        if (startDir == 1) {
            startDir = 3;
        } else if (startDir == 3) {
            startDir = 1;
        }

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        int curRow = startRow;
        int curCol = startCol;
        int curDir = startDir;
        while (true) {
            if (map[curRow][curCol] == 0) {
                map[curRow][curCol] = 2;
            }
            boolean goFlag = false;
            for (int i = 0; i < 4; i++) {
                curDir = (curDir + 1) % 4;
                int nr = curRow + dr[curDir];
                int nc = curCol + dc[curDir];
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    curRow = nr;
                    curCol = nc;
                    goFlag = true;
                    break;
                }
            }
            if (goFlag) {
                continue;
            }

            int backRow = curRow + dr[(curDir + 2) % 4];
            int backCol = curCol + dc[(curDir + 2) % 4];

            if (backRow < 0 || backRow >= row || backCol < 0 || backCol >= col) {
                break;
            }
            if (map[backRow][backCol] == 1) {
                break;
            }
            curRow = backRow;
            curCol = backCol;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 2) {
                    answer++;
                }
            }
        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }
}
