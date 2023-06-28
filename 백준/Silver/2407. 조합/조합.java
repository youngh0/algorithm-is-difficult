

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        double[] dp = new double[m + 2];
        dp[1] = n;

        BigInteger mul = new BigInteger(String.valueOf(n));
        BigInteger sum = BigInteger.ONE;
        for (int i = 2; i < m + 1; i++) {
            mul = mul.multiply(new BigInteger(String.valueOf(n - i + 1)));
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(mul.divide(sum));
    }
}
