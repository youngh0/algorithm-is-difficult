class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pCount = 0;
        int yCount = 0;
        
        for(int i = 0;i < s.length();i++){
            Character a = s.charAt(i);
            if(a == 'p' || a == 'P'){
                pCount++;
            }
            if(a == 'y' || a == 'Y'){
                yCount++;
            }
        }

        return pCount == yCount;
    }
}