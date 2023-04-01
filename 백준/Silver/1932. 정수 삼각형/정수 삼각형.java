import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[N - 1] = Arrays.copyOf(map[N - 1], N);
		for (int y = N - 2; y >= 0; y--) {
			for (int x = 0; x <= y; x++) {
				dp[y][x] = map[y][x] + Math.max(dp[y + 1][x], dp[y + 1][x + 1]);
			}
		}

		System.out.println(dp[0][0]);

	}
}