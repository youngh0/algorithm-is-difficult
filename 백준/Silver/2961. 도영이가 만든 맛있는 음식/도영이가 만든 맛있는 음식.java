

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] visited;
    static Taste[] tastes;
    static StringTokenizer st;
    static List<Taste> tasteList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        tastes = new Taste[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int mul = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());
            tastes[i] = new Taste(mul, plus);
        }

        for (int i = 1; i < n+1; i++) {
            backTracking(0, i);
        }
        System.out.println(answer);
    }

    public static void backTracking(int idx, int targetCount) {
        if (tasteList.size() == targetCount) {
            int mulVal = 1;
            int plusVal = 0;
            for (Taste taste : tasteList) {
                mulVal *= taste.getMul();
                plusVal += taste.getPlus();
            }
            answer = Math.min(answer, Math.abs(mulVal - plusVal));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tasteList.add(tastes[i]);
                backTracking(i + 1, targetCount);
                visited[i] = false;
                tasteList.remove(tasteList.size() - 1);
            }
        }
    }

    static class Taste{
        int mul;
        int plus;

        public Taste(int mul, int plus) {
            this.mul = mul;
            this.plus = plus;
        }

        public int getMul() {
            return mul;
        }

        public int getPlus() {
            return plus;
        }
    }
}
