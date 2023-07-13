

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        int[][] bookTimes = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            String[] times = book_time[i];
            String[] start = times[0].split(":");
            String[] end = times[1].split(":");

            bookTimes[i][0] = convert(start);
            bookTimes[i][1] = convert(end);
        }

        Arrays.sort(bookTimes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[1]));
        pq.add(new int[]{bookTimes[0][0], bookTimes[0][1] + 10});

        for (int i = 1; i < bookTimes.length; i++) {
            int curStart = bookTimes[i][0];
            int curEnd = bookTimes[i][1];

            int[] peek = pq.peek();
            int fast = peek[1];
            if (curStart < fast) {
                pq.add(new int[]{curStart, curEnd + 10});
            } else {
                pq.poll();
                pq.add(new int[]{curStart, curEnd + 10});
            } 
        }

        return pq.size();
        
//        int fastEnd = bookTimes[0][1] + 10;
//        int fastIndex = 0;
//        for (int i = 1; i < bookTimes.length; i++) {
//            int curStart = bookTimes[i][0];
//            int curEnd = bookTimes[i][1];
//
//            if (curStart < fastEnd) {
//                answer++;
//                if (curEnd + 10 < fastEnd) {
//                    fastIndex = i;
//                    fastEnd = curEnd + 10;
//                }
////                fastEnd = Math.min(fastEnd, curEnd + 10);
//            } else {
//                fastEnd = curEnd + 10;
//                for (int j = 0; j < i; j++) {
//                    if (j == fastIndex) continue;
//                    if (bookTimes[j][1] + 10 < fastEnd) {
//                        System.out.println(j);
//                        fastIndex = j;
//                        fastEnd = bookTimes[j][1] + 10;
//                        bookTimes[fastIndex][1] = curEnd + 10;
//                        System.out.println(bookTimes[fastIndex][1]);
//                    }
////                    fastEnd = Math.min(fastEnd, bookTimes[j][1] + 10);
////                    System.out.println(fastEnd);
//                }
//            }
//            System.out.println(fastEnd);
//        }
//
//        return answer;
    }

    public int convert(String[] time) {
        int hour = Integer.parseInt(time[0]) * 60;
        int minute = Integer.parseInt(time[1]);

        return hour + minute;
    }
}
