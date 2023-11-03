// import java.util.*;

// class Solution {
//     public long solution(int n, int[] times) {
        
//         long left = 1;
//         Arrays.sort(times);
//         long right = times[times.length-1] * (long)n;
//         long answer = right;
//         while(left <= right){
//             long mid = (left + right) / 2;
//             int count = 0;
            
//             for(int time: times){
//                 count += mid / time;
//             }
            
//             if(count < n){
//                 left = mid + 1;
//             }else{
//                 // answer = Math.min(answer, mid);
//                 right = mid - 1;
//                 answer = mid;
//             }
//         }
        
//         return answer;
//     }
// }
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1;

        // times 배열의 최악의 경우는 범위
        // n명 기준으로 times의 가장 마지막 시간까지 탐색하는 경우.
    	long max = (long) times[times.length-1]*n;
    	long mid = 0;
    	long sum;
    	long answer = max;

    	while(min <= max) {
    		sum = 0;
    		mid = (min + max) / 2;

    		for(int time : times) {
    			sum += mid / time;
    		}

    		if(sum >= n) {
				answer = mid;
				max = mid - 1;
    		}
    		else {
    			min = mid + 1;
    		}
    	}


        return answer;
    }
}
