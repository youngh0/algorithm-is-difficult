class Solution {
    int answer = Integer.MAX_VALUE;

    public int solution(int storey) {
    
        dfs(storey, 0, 0);
        return answer;
    }
    
    public void dfs(int s, int count, int depth){
        if(depth >= 10){
            return;
        }
        if(s == 0){
            answer = Math.min(answer, count);
            return;
        }
        String st = String.valueOf(s);
        
        int plus = s + (10 - (st.charAt(st.length() -1 - depth) - '0')) * (int)Math.pow(10, depth);
        int minus = s - ((st.charAt(st.length() -1 - depth) - '0')) * (int)Math.pow(10, depth);
        
        dfs(plus, count + (10 - (st.charAt(st.length() -1 - depth) - '0')),depth+1);
        dfs(minus, count + ((st.charAt(st.length() -1 - depth) - '0')),depth+1);
    }
}