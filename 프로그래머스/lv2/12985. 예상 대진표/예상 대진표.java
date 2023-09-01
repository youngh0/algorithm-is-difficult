class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        int firstNum = a;
        int secondNum = b;
        
        while(!isMatch(firstNum, secondNum)){
            answer++;
            firstNum = (firstNum + 1) / 2;
            secondNum = (secondNum + 1) / 2;
        }


        return answer + 1;
    }
    
    public boolean isMatch(int first, int second){
        return Math.abs(first - second) == 1 && ((first + second) / 2) % 2 == 1;
    }
}