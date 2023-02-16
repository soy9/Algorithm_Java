import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[][] rcs;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rcs = new int[K][3];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			rcs[k][0] = Integer.parseInt(st.nextToken()) - 1;
			rcs[k][1] = Integer.parseInt(st.nextToken()) - 1;
			rcs[k][2] = Integer.parseInt(st.nextToken());
		}

		permutation(0, new int[K], new boolean[K]);

		System.out.println(min);
	}

	public static void permutation(int cnt, int[] arr, boolean[] visited) {
		if (cnt == K) {
			rotate(arr);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			arr[cnt] = i;
			permutation(cnt + 1, arr, visited);
			visited[i] = false;
		}
	}

	public static void rotate(int[] arr) {
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}

		for (int k = 0; k < K; k++) {
			int r = rcs[arr[k]][0];
			int c = rcs[arr[k]][1];
			int S = rcs[arr[k]][2];

			for (int s = 1; s <= S; s++) {
				// 상
				int upTmp = tmp[r - s][c + s];
				for (int y = c + s; y > c - s; y--) {
					tmp[r - s][y] = tmp[r - s][y - 1];
				}

				// 우
				int rightTmp = tmp[r + s][c + s];
				for (int x = r + s; x > r - s; x--) {
					tmp[x][c + s] = tmp[x - 1][c + s];
				}
				tmp[r - s + 1][c + s] = upTmp;

				// 하
				int leftTmp = tmp[r + s][c - s];
				for (int y = c - s; y < c + s; y++) {
					tmp[r + s][y] = tmp[r + s][y + 1];
				}
				tmp[r + s][c + s - 1] = rightTmp;

				// 좌
				for (int x = r - s; x < r + s; x++) {
					tmp[x][c - s] = tmp[x + 1][c - s];
				}

				tmp[r + s - 1][c - s] = leftTmp;

			}
		}

		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += tmp[i][j];
			}
			min = Integer.min(min, sum);
		}
	}
}
