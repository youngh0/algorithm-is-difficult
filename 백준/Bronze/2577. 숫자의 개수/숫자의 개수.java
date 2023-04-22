import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int sum = A * B * C;
        int[] arr = new int[10];
        List<Integer> nums = Arrays.stream(String.valueOf(sum).split(""))
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

        for (Integer num : nums) {
            arr[num] += 1;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
