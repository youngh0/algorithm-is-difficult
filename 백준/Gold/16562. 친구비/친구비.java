

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        friends = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            friends[i] = i;
        }

        int[] monies = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            monies[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            int firstParent = findParent(first);
            int secondParent = findParent(second);

            if (monies[firstParent] > monies[secondParent]) {
                friends[firstParent] = secondParent;
            } else {
                friends[secondParent] = firstParent;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            friends[i] = findParent(i);
        }

        Set<Integer> unique = new HashSet<>();

        for (int i = 1; i < n + 1; i++) {
            unique.add(friends[i]);
        }

        int total = 0;
        for (Integer integer : unique) {
            total += monies[integer];
        }

        if (total <= money) {
            System.out.println(total);
        } else {
            System.out.println("Oh no");
        }
    }

    private static int findParent(int num) {
        if (friends[num] == num) return num;
        else return findParent(friends[num]);
    }
}
