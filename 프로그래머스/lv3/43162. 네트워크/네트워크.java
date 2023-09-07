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
        
        int[] parent = new int[n];
        for(int i = 0;i < n;i++){
            parent[i] = i;
        }
        
        for(int key: map.keySet()){
            List<Integer> connects = map.get(key);
            for(int connect: connects){
                int a = getParent(parent, key);
                int b = getParent(parent, connect);
                
                if(a < b){
                    parent[b] = a;
                }else{
                    parent[a] = b;
                }
            }
        }
        
        Set<Integer> nodes = new HashSet<>();
        
        for(int p : parent){
            nodes.add(getParent(parent, p));
        }    
        return nodes.size();
    }
    
    public int getParent(int[] parent, int node){
        if(parent[node] == node) return node;
        else return getParent(parent, parent[node]);
    }
}