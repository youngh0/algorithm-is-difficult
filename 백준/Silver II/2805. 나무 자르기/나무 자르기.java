

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr[N-1];
        int answer = 0;

        while(start <= end) {
            long sum = 0;
            int mid = (start + end) / 2;
            for(int j = 0; j < N; j++) {
                if(mid < arr[j]){
                    sum += arr[j] - mid;
                }
            }

            if(sum >= M) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid -1;
            }

        }

        System.out.println(answer);
        
    }
}

