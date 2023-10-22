class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int effect = 1 + (w * 2);
        int start = 1;
        
        for(int station: stations){
            int last = station - w ;
            
            if(start < last){
                int diff = last - start;
                answer += diff / effect;
                if(diff% effect > 0){
                    answer++;
                }
            }
            
            start = station + w + 1;
        }
        
        if(stations[stations.length - 1] + w < n){
            int diff = n - start + 1;
            answer += diff / effect;
            if(diff% effect > 0){
                answer++;
            }
        }
        return answer;
    }
}