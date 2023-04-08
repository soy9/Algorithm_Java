import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, K, res;
	static int[][] map;
	static boolean[][] visited;
	static List<Position> top = new LinkedList<Position>();
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Position {
		int y, x;

		public Position(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void init() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	static void dfs(int y, int x, boolean flag, int d) {
		res = Math.max(res, d);

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
				continue;
			}
			if (visited[ny][nx]) {
				continue;
			}

			if (map[ny][nx] >= map[y][x] && flag) {
				continue;
			}

			if (map[ny][nx] < map[y][x]) {
				visited[ny][nx] = true;
				dfs(ny, nx, flag, d + 1);
				visited[ny][nx] = false;
			} else if (!flag) {
				if (map[ny][nx] - K < map[y][x]) {
					int tmp = map[ny][nx];
					map[ny][nx] = map[y][x] - 1;
					visited[ny][nx] = true;
					dfs(ny, nx, true, d + 1);
					visited[ny][nx] = false;
					map[ny][nx] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			top.clear();
			int height = 0;
			res = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > height) {
						top.clear();
						top.add(new Position(i, j));
						height = map[i][j];
					} else if (map[i][j] == height) {
						top.add(new Position(i, j));
					}
				}
			}
			// input end

			for (Position t : top) {
				init();
				visited[t.y][t.x] = true;
				dfs(t.y, t.x, false, 1);
			}

			// output
			sb.append("#" + tc + " ");
			sb.append(res + " \n");
		}
		System.out.println(sb);
	}

}