import java.util.*;

class Solution {
    int[] discountRate = {10,20,30,40};
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        if(o1[0] == o2[0]){
            return o2[1] - o1[1];
        }
        return o2[0] - o1[0];
    });
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        dfs(new int[emoticons.length], 0, emoticons, users);
        return pq.poll();
    }
    
    public void dfs(int[] arr, int n, int[] emoticons, int[][] users){
        if(n == emoticons.length){
            calculate(arr, emoticons, users);
            return;
        }
        for(int i = 0;i < 4;i++){
            arr[n] = discountRate[i];
            dfs(arr, n+1, emoticons, users);
        }
    }
    
    public void calculate(int[] arr, int[] emoticons, int[][] users){
        int buy = 0;
        int memberCount = 0;
        
        for(int[] user: users){
            int buyRate = user[0];
            int memberAmount = user[1];
            
            int buyTotal = 0;
            
            for(int i = 0;i < arr.length;i++){
                int dis = arr[i];
                int emoji = emoticons[i];
                
                if(dis >= buyRate){
                    buyTotal += emoji/100 * (100-dis);
                }
            }
            
            
            if(buyTotal >= memberAmount){
                memberCount++;
            }else{
                buy += buyTotal;
            }
        }

        
        
        pq.add(new int[]{memberCount, buy});
    }
}