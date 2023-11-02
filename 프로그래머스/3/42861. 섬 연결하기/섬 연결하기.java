import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
//         int[] result = new int[n];
//         for(int i = 0;i < n;i++){
//             result[i] = Integer.MAX_VALUE;
//         }
        
//         for(int[] cost: costs){
//             int less = Math.min(cost[0], cost[1]);
//             int big = Math.max(cost[0], cost[1]);
            
//             result[big] = Math.min(result[big], cost[2]);
//         }
        
//         for(int res: result){
//             if(res == Integer.MAX_VALUE){
//                 continue;
//             }
//             answer += res;
//         }
        
        Map<Integer, List<int[]>> nodeMap = new HashMap<>();
        for(int i = 0; i < n;i++){
            nodeMap.put(i, new ArrayList<int[]>());
        }
        
        for(int cost[]: costs){
            nodeMap.get(cost[0]).add(new int[]{cost[1], cost[2]});
            nodeMap.get(cost[1]).add(new int[]{cost[0], cost[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for(int[] cost: nodeMap.get(0)){
            pq.add(cost);
        }
        
        Set<Integer> nodeSet = new HashSet<>();
        nodeSet.add(0);
        
        while(nodeSet.size() != n){
            int[] cost = pq.poll();
            int dest = cost[0];
            int money = cost[1];
            if(nodeSet.contains(dest)){
                continue;
            }
            nodeSet.add(dest);
            answer += money;
            
            for(int[] info: nodeMap.get(dest)){
                pq.add(new int[]{info[0], info[1]});
            }
        }
        
        return answer;
    }
}