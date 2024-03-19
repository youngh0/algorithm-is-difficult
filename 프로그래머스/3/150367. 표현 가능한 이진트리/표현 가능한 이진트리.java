import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0;i < numbers.length;i++){
            long number = numbers[i];
            String binary = Long.toBinaryString(number);
            int nodeCount = 1;
            int depth = 1;
            
            while(binary.length() > nodeCount){
                nodeCount += Math.pow(2, depth);
                depth++;
            }
            
            int diff = nodeCount - binary.length();
            String full = "0".repeat(diff) + binary;
            if(dfs(full)){
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    
    public boolean dfs(String binary){
        if(binary.length() < 3){
            if(binary.charAt(0) == '0'){
                return false;
            }
            return true;
        }
        
        int mid = (binary.length() - 1 )/2;
        char root = binary.charAt(mid);
        String left = binary.substring(0, mid);
        String right = binary.substring(mid+1, binary.length());
        
        char leftRoot = left.charAt((left.length() -1 )/ 2);
        char righttRoot = right.charAt((right.length() -1)/ 2);
        
        if(root == '0' && (leftRoot == '1' || righttRoot == '1')){
            return false;
        }
        
        if(binary.length() == 3){
            return true;
        }
        
        if(dfs(left) && dfs(right)){
            return true;
        }
        return false;
    }
}