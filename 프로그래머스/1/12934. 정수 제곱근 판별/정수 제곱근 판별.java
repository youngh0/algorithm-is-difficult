class Solution {
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long)Math.sqrt(n);
        System.out.print(sqrt);
        if(Math.pow(sqrt,2) == n){
            return (long)Math.pow(sqrt+1,2);
        
        }
        return -1;
    }
}