import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] dp;

	static int dfs(int y, int x) {
		if (y == M - 1 && x == N - 1) {
			return 1;
		}

		if (dp[y][x] >= 0) {
			return dp[y][x];
		}

		dp[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}

			if (map[ny][nx] < map[y][x]) {
				dp[y][x] += dfs(ny, nx);
			}
		}

		return dp[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로

		map = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		// input end

		System.out.println(dfs(0, 0));
	}

}
