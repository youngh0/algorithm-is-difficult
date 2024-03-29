class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int first = 10000;
        int sum = 0;
        int tmp = x;
        while(first != 0){
            System.out.println(first +" " + x/first);
            sum += tmp/first;
            tmp %= first;
            first /= 10;
            
        }
        System.out.println(sum);
        return x % sum == 0;
    }
}