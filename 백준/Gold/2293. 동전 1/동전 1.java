import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		int[] dp = new int[k + 1];
        
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
        // input end
        
        dp[0] = 1;
        for(int coin : coins) {
            for(int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
		System.out.println(dp[k]);
	}
}