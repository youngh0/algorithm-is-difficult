

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 선호도 상위 N 개가 목표 선호도 못 넘으면 -1
    // N개의 맥주를 마실 때 목표 선호도 넘길 수 있는 최저 조합 찾아서 맥주 종류 중 시작으로 이거로.
    //  (0 ~ N) 개 합해서 선호도 못 넘으면 (0+1 ~ N+1) 합해보는 식으로 해서 시작 인덱스 찾아
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int purpose = Integer.parseInt(st.nextToken());
        int beerCategory = Integer.parseInt(st.nextToken());

        int[][] beers = new int[beerCategory][2];
        for (int i = 0; i < beerCategory; i++) {
            st = new StringTokenizer(br.readLine());
            int beerLike = Integer.parseInt(st.nextToken());
            int stun = Integer.parseInt(st.nextToken());
            beers[i][0] = beerLike;
            beers[i][1] = stun;
        }

        Arrays.sort(beers, Comparator.comparingInt(o -> o[1]));

        Queue<Integer> q = new PriorityQueue<>();
        // q 에 선호도를 넣으면서 q 크기가 n 이 되면 합을 구함
        // 합이 purpose 넘으면 그게 정답
        int total = 0;
        for (int[] beer : beers) {
            q.add(beer[0]);
            total += beer[0];
            if (q.size() == n && total >= purpose) {
                System.out.println(beer[1]);
                return;
            }
            if (q.size() == n) {
                total -= q.poll();
            }
        }

        System.out.println(-1);
    }
}
