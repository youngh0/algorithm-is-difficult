import java.util.*;

class Solution {

    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long factorial = 1;
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i < n+1;i++){
            factorial *= i;
            arr.add(i);
        }
        
        k--;
        int idx = 0;
        while(n > 0){
            factorial /= n;
            int category = (int) (k / factorial);
            answer[idx] = arr.get(category);
            arr.remove(category);
            
            k %= factorial;
            idx++;
            n--;
        }
        
        return answer;
    }
}