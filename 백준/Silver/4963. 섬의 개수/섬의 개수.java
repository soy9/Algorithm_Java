import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int N, M;
	static LinkedList<Info> q = new LinkedList<>();
	static boolean[][] visited;
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class Info {
		int y, x;

		public Info(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void bfs(int y, int x) {

		LinkedList<Info> tmpQ = new LinkedList<>();
		tmpQ.add(new Info(y, x));

		while (!tmpQ.isEmpty()) {
			Info posInfo = tmpQ.poll();
			int posy = posInfo.y;
			int posx = posInfo.x;

			for (int i = 0; i < 8; i++) {
				int ny = posy + dy[i];
				int nx = posx + dx[i];

				if (ny < 0 || nx < 0 || ny >= N | nx >= M || visited[ny][nx]) {
					continue;
				}

				if (map[ny][nx] == 1) {
					tmpQ.add(new Info(ny, nx));
				}

				visited[ny][nx] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int count = 0;

		while (true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0) {
				break;
			}

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						q.add(new Info(i, j));
					}
				}
			}
			// input end

			count = 0;
			while (!q.isEmpty()) {
				Info tmpInfo = q.poll();
				if (!visited[tmpInfo.y][tmpInfo.x]) {
					visited[tmpInfo.y][tmpInfo.x] = true;
					bfs(tmpInfo.y, tmpInfo.x);
					count++;
				}
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

}
