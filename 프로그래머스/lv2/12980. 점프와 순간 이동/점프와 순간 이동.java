import java.util.*;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n > 1){
            if(n % 2 == 1){
                ans++;
            }
            n /= 2;
        }
        return ans+1;
    }
}
