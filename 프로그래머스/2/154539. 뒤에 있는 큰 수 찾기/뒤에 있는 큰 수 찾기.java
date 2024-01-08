import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = numbers.length-1;i > -1;i--){
            int cur = numbers[i];
            while(!dq.isEmpty()){
                // System.out.println(i + " " + dq.peekLast());
                if(dq.peekLast() > cur){
                    answer[i] = dq.peekLast();
                    break;
                }else{
                    dq.removeLast();
                }
            }
            
            dq.offerLast(cur);
            
            
            // for(int j = i+1;j < numbers.length;j++){
            //     if(numbers[j] > cur){
            //         answer[i] = numbers[j];
            //         break;
            //     }
            // }
        }
        return answer;
    }
}