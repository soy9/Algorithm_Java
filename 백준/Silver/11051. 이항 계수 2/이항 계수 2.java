import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 10007;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        dp = new int[N + 1][N + 1];
        
        for (int n = 0; n <= N; n++) {
            for (int k = 0; k <= n; k++) {
                if (k == 0 || k == n) {
                    dp[n][k] = 1;
                } else { 
                    dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k]) % MOD;
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
