class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(long x = 0; x <= d; x += k){
            
            long maxY = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(x,2)) / k;

            answer += maxY + 1;
        }
        
        return answer;
    }
}