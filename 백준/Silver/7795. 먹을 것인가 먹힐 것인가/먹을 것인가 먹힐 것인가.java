

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (testcase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int anum = Integer.parseInt(st.nextToken());
            int bnum = Integer.parseInt(st.nextToken());
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < anum; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bnum; i++) {
                b.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(a);
            Collections.sort(b);

            int answer = 0;
            int lastIdx = 0;
            Map<Integer, Integer> eatMap = new HashMap<>();
            for (Integer eatNum : a) {
                if (eatMap.containsKey(eatNum)) {
                    answer += eatMap.get(eatNum);
                    continue;
                }

                int left = 0;
                int right = bnum - 1;
                int idx = 0;

                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (eatNum > b.get(mid)) {
                        left = mid + 1;
                        idx = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                answer += idx;
            }
            System.out.println(answer);
        }
    }
}
