import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        
        for(int gate: gates){
            gateSet.add(gate);
        }
        
        for(int summit: summits){
            summitSet.add(summit);
        }
        
        List<List<int[]>> map = new ArrayList<>();
        
        for(int i = 0; i < n+1;i++){
            map.add(new ArrayList<>());
        }
        
        for(int[] path: paths){
            int start = path[0];
            int end = path[1];
            int cost = path[2];
            
            if(gateSet.contains(start)){
                map.get(start).add(new int[]{end,cost});
            }
            else if(gateSet.contains(end)){
                map.get(end).add(new int[]{start, cost});
            }
            else if(summitSet.contains(start)){
                map.get(end).add(new int[]{start, cost});
            }
            else if(summitSet.contains(end)){
                map.get(start).add(new int[]{end, cost});
            }else{
                map.get(start).add(new int[]{end, cost});
                map.get(end).add(new int[]{start,cost});
            }
        }
        
        int[] distance = new int[n+1];
        
        // for(List<int[]> root: map){
        //     for(int[] r: root){
        //         System.out.print(r[0] + ": " + r[1] + ", ");
        //     }
        //     System.out.println();
        // }
        dijkstra(distance, gateSet, map);
        
        int[] answer = new int[]{0, Integer.MAX_VALUE};
        Arrays.sort(summits);
        for(int s: summits){
            if(distance[s] < answer[1]){
                answer = new int[]{s, distance[s]};
            }
            
        }
        return answer;
    }
    
    public void dijkstra(int[] distance, Set<Integer> gateSet, List<List<int[]>> map){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int gate: gateSet){
            distance[gate] = 0;
            pq.add(new int[]{gate, 0});
        }
        
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int start = polled[0];
            int cost = polled[1];
    
            if(distance[start] < cost){
                continue;
            }
            
            for(int[] next: map.get(start)){
                int nextNode = next[0];
                int nextCost = next[1];
            
                int maxValue = Math.max(nextCost, distance[start]);
                if(maxValue < distance[nextNode]){
                    
                    distance[nextNode] = maxValue;
                    pq.add(new int[]{nextNode, maxValue});
                }
            }
        }
    }
}