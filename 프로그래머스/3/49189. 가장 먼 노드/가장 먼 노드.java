

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    Map<Integer, List<Integer>> maps = new HashMap<>();
    boolean[] visited;
    Map<Integer, Integer> results = new HashMap<>();

    public int solution(int n, int[][] edge) {
        int answer = 0;
        for (int[] ints : edge) {
            int source = ints[0];
            int target = ints[1];

            if (maps.containsKey(source)) {
                maps.get(source).add(target);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>(List.of(target));
                maps.put(source, tmp);
            }

            if (maps.containsKey(target)) {
                maps.get(target).add(source);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>(List.of(source));
                maps.put(target, tmp);
            }
        }

        for (int i = 2; i < n + 1; i++) {
            bfs(i,n);
        }

        ArrayList<Integer> keys = new ArrayList<>(results.keySet());
        keys.sort((o1, o2) -> results.get(o2) - results.get(o1));

        int maxValue = results.get(keys.get(0));

        for (Integer key : keys) {
            if (results.get(key) != maxValue) {
                break;
            }
            answer++;
        }

        return answer;
    }

    public void bfs(int target, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[n + 1];
        visited[1] = true;
        q.add(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] value = q.poll();
            int source = value[0];
            int count = value[1];

            for (Integer node : maps.get(source)) {
                if(results.containsKey(node)){
                    continue;
                }
                if (visited[node]) {
                    continue;
                }
                q.add(new int[]{node, count + 1});
                int nodeCount = results.getOrDefault(node, 0);
                results.put(node, Math.max(nodeCount, count+1));
                visited[node] = true;
            }
        }
    }
}
