


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int totalEgg = 0;
    static int[] dura;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        totalEgg = n;
        List<Egg> eggList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int shield = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggList.add(new Egg(weight, shield));
        }

        breakEgg(0, 0, eggList);
        System.out.println(answer);
    }

    public static void breakEgg(int idx, int breakCount, List<Egg> eggList) {
        if (idx == eggList.size()) {
            answer = Math.max(answer, breakCount);
            return;
        }

        Egg curEgg = eggList.get(idx);
        if (curEgg.shield <= 0 || breakCount == totalEgg - 1) {
            breakEgg(idx + 1, breakCount, eggList);
            return;
        }
        for (int i = 0; i < totalEgg; i++) {
            if (i == idx || eggList.get(i).shield <= 0) {
                continue;
            }
            Egg other = eggList.get(i);
            curEgg.crush(other);
            other.crush(curEgg);
            int cnt = 0;
            if (curEgg.shield <= 0) {
                cnt++;
            }
            if (other.shield <= 0) {
                cnt++;
            }
            breakEgg(idx + 1, breakCount + cnt, eggList);
            curEgg.rollback(other);
            other.rollback(curEgg);
        }
    }

    static class Egg {
        int weight;
        int shield;
        boolean isBreak = false;

        public Egg(int weight, int shield) {
            this.weight = weight;
            this.shield = shield;
        }

        public void crush(Egg other) {
            this.shield -= other.weight;
//            other.shield -= this.weight;
        }

        public void rollback(Egg other) {
            this.shield += other.weight;
//            other.shield += this.weight;
        }

    }
}

