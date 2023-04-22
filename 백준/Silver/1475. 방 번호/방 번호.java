import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roomNum = Integer.parseInt(br.readLine());

        int[] arr = new int[10];

        Arrays.stream(String.valueOf(roomNum).split(""))
                .map(num -> Integer.parseInt(num))
                .forEach(n -> arr[n] += 1);

        int sameNum = arr[6] + arr[9];
        int div = sameNum / 2;
        if (sameNum % 2 == 1) {
            arr[6] = div + 1;
            arr[9] = div + 1;
        } else {
            arr[6] = div;
            arr[9] = div;
        }

        int maxNum = Arrays.stream(arr)
                .max()
                .getAsInt();

        System.out.println(maxNum);
    }
}
