import java.util.*;

class Solution {
    private static List<int[]> ansList;

    public static int[][] solution(int n) {

        ansList = new ArrayList<>();
        dfs(n, 1,3, 2);


        int[][] answer = new int[ansList.size()][];
        for(int i=0; i<ansList.size(); i++){
            answer[i] = ansList.get(i);
        }

        return answer;
    }

    private static void dfs(int n, int start, int to, int mid) {
        if(n == 1){
            ansList.add(new int[]{start, to});
            return;
        }
        
        dfs(n-1, start, mid, to);

        ansList.add(new int[]{start, to});

        dfs(n-1, mid, to, start);
    }
}