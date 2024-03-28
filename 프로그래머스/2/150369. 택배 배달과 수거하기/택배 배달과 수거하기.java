class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int delivery = 0;
        int pick = 0;
        for(int i = deliveries.length-1;i >= 0; i--){
            delivery -= deliveries[i]   ; 
            pick -= pickups[i];
            
            while(delivery< 0 || pick < 0){
                delivery += cap;
                pick += cap;
                answer += (i + 1) * 2;
            }
            
        }
        return answer;
    }
}