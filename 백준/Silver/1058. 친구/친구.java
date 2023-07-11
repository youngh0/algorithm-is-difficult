

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer = 0;
    static List<Integer>[] friends;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        friends = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String info = st.nextToken();
            for (int j = 0; j < info.length(); j++) {
                if (info.charAt(j) == 'Y') {
                    friends[i].add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            bfs(i);
        }
//        bfs(2);
        System.out.println(answer);
    }

    public static void bfs(int start) {
        Queue<Friend> q = new ArrayDeque<>();
        for (Integer friend : friends[start]) {
            q.add(new Friend(1, friend));
        }
        int tmpAnswer = 0;
        visited[start] = true;
        while (!q.isEmpty()) {
            Friend friend = q.poll();
            if (visited[friend.num] || friend.relationship > 2) {
                continue;
            }
            visited[friend.num] = true;
            tmpAnswer++;
            for (Integer f : friends[friend.num]) {
                q.add(new Friend(friend.relationship + 1, f));
            }

        }
        answer = Math.max(answer, tmpAnswer);

    }

    static class Friend {
        int relationship;
        int num;

        public Friend(int relationship, int num) {
            this.relationship = relationship;
            this.num = num;
        }
    }
}
