import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1,o2) -> o1[1] - o2[1]);
        
        int lastCamera = routes[0][1];
        for(int i = 1;i < routes.length;i++){
            int[] route = routes[i];
            if(route[0] <= lastCamera){
                continue;
            }
            answer++;
            lastCamera = route[1];
        }
        return answer;
    }
}