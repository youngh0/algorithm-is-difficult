

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static StringTokenizer st;
    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    static List<Integer> tmp = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static Set<Pair> pairSet = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0,0);
        System.out.println(sb);
    }

    static void backTracking(int depth, int idx) {
        if (depth == m) {
            int[] array = tmp.stream().mapToInt(t -> t).toArray();
            Pair newPair = new Pair(array);
            if (pairSet.contains(newPair)) {
                return;
            }
            pairSet.add(newPair);
            for (Integer integer : tmp) {
                sb.append(integer).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                tmp.add(arr[i]);
                visited[i] = true;
                backTracking(depth+1, i+1);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    static class Pair{
        int[] a;

        public Pair(int[] a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Arrays.equals(a, pair.a);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(a);
        }
    }
}
