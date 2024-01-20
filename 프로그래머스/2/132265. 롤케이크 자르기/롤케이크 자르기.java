import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] left = new int[10001];
        int[] right = new int[10001];
        
        int leftCount = 0;
        int rightCount = 0;
        
        for(int top: topping){
            right[top]++;
            if(right[top] == 1){
                rightCount++;
            }
        }
        
        System.out.println(rightCount);
        System.out.println(leftCount);
        
        for(int i =0; i < topping.length-1;i++){
            int top = topping[i];
            if(left[top] == 0){
                leftCount++;
            }
            if(right[top] == 1){
                rightCount--;
            }
            right[top]--;
            left[top]++;
        
            
            if(leftCount == rightCount){
                answer++;
            }
        }
        
        return answer;
    }
}
