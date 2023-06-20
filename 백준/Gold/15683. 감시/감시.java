

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cctvNum;
    static int wallNum = 0;
    static int[][] map;
    static int[][] copyMap;
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<CCTV> cctvs = new ArrayList<>();
    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int element = Integer.parseInt(st.nextToken());
                if (element >= 1 && element <= 5) {
                    CCTV cctv = new CCTV(element, i, j);
                    cctvs.add(cctv);
                    cctvNum += 1;
                }
                if (element == 6) {
                    wallNum += 1;
                }
                map[i][j] = element;
            }
        }

        for (int i = 0; i < 1 << (2 * cctvNum); i++) {
            int tmp = i;
            copyMap = new int[n][m];
            for (int mapX = 0; mapX < n; mapX++) {
                for (int mapY = 0; mapY < m; mapY++) {
                    copyMap[mapX][mapY] = map[mapX][mapY];
                }
            }
            int tmpCount = 0;
            for (int idx = 0; idx < cctvNum; idx++) {
                CCTV cctv = cctvs.get(idx);
                int dir = tmp % 4;
                tmp /= 4;
                if (cctv.category == 1) {
                    tmpCount += watch(cctv.x, cctv.y, dir);
                }
                if (cctv.category == 2) {
                    tmpCount += watch(cctv.x, cctv.y, dir);
                    tmpCount += watch(cctv.x, cctv.y, dir+2);
                }
                if (cctv.category == 3) {
                    tmpCount += watch(cctv.x, cctv.y, dir);
                    tmpCount += watch(cctv.x, cctv.y, dir+1);
                }
                if (cctv.category == 4) {
                    tmpCount += watch(cctv.x, cctv.y, dir);
                    tmpCount += watch(cctv.x, cctv.y, dir+1);
                    tmpCount += watch(cctv.x, cctv.y, dir+2);
                }
                if (cctv.category == 5) {
                    tmpCount += watch(cctv.x, cctv.y, dir);
                    tmpCount += watch(cctv.x, cctv.y, dir+1);
                    tmpCount += watch(cctv.x, cctv.y, dir+2);
                    tmpCount += watch(cctv.x, cctv.y, dir+3);
                }
            }

            answer = Math.min(answer, n * m - (tmpCount + wallNum + cctvNum));
        }

        System.out.println(answer);
    }

    public static int watch(int curX, int curY, int dir) {
        dir = dir % 4;
        int changeCount = 0;
        while (true) {
            curX += dx[dir];
            curY += dy[dir];
            if (curX < 0 || curX >= n || curY < 0 || curY >= m) {
                return changeCount;
            }
            if (copyMap[curX][curY] == 0) {
                changeCount++;
                copyMap[curX][curY] = -1;
            }
            if (copyMap[curX][curY] == 6) {
                break;
            }
        }
        return changeCount;
    }

    static class CCTV{
        int category;
        int x;
        int y;

        public CCTV(int category, int x, int y) {
            this.category = category;
            this.x = x;
            this.y = y;
        }

        public int getCategory() {
            return category;
        }
    }
}
