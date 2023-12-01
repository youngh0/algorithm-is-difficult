class Solution {
    public int solution(int n) {
        int answer = 0;
        int nOne = countOne(n);
        
        int tmp = n;
        while(true){
            tmp++;
            int tmpOne = countOne(tmp);
            if(nOne == tmpOne){
                break;
            }
        }
        return tmp;
    }
    
    public int countOne(int n){
        int count= 0;
        
        while(n != 0){
            if(n % 2 == 1){
                count++;
            }
            n /= 2;
        }
        return count;
    }
}