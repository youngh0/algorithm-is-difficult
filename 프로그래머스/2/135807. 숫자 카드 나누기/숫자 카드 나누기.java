import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int aGcd = arrayA[0];
        int bGcd = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++){
            aGcd = gcd(arrayA[i], aGcd);
            bGcd = gcd(arrayB[i], bGcd);
        }
        
        if(!canDivide(arrayB, aGcd)){
            answer = Math.max(answer, aGcd);
        }
        
        if(!canDivide(arrayA, bGcd)){
            answer = Math.max(answer, bGcd);
        }
        
        
        return answer;
    }
    
    public static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
    
    public static boolean canDivide(int[] array, int gcd){
        for(int num:array){
            if(num%gcd==0){
                return true;
            }
        }
        return false;
    }
}