import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; 
        Map<Integer, List<Integer>> map = new HashMap<>();
        int answer = 0;
    
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                
                if(computers[i][j] == 0){
                    continue;
                }
                if(!map.containsKey(i)){
                    map.put(i, new ArrayList<Integer>(List.of(j)));
                }else{
                   List<Integer> connects = map.get(i); 
                    connects.add(j);
                } 
            }
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int key : map.keySet()){
            if(!visited[key]){
                visited[key] = true;
                answer++;
                List<Integer> connects = map.get(key);
                for(int connect : connects){
                    if(!visited[connect]){
                        dq.offerLast(connect);       
                    }
                }
                if(!dq.isEmpty()){
                    while(!dq.isEmpty()){
                        int start = dq.pollFirst();
                        visited[start] = true;
                        List<Integer> connects2 = map.get(start);
                        for(int connect : connects2){
                            if(!visited[connect]){
                                visited[connect] = true;
                            
                                dq.offerLast(connect);
                            }
                        }
                    }
                }
            }
        
        }
        
        return answer;
    }
}