import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map, distance;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int xx, yy;

	static class Position {
		int y, x;

		public Position(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(yy, xx));

		while (!q.isEmpty()) {
			Position now = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = now.y + dy[d];
				int nx = now.x + dx[d];

				if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
					continue;
				}
				if (map[ny][nx] == 0) {
					distance[ny][nx] = 0;
					continue;
				}
				if (distance[ny][nx] == -1) {
					distance[ny][nx] = distance[now.y][now.x] + 1;
					q.add(new Position(ny, nx));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		distance = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], -1);
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					yy = i;
					xx = j;
				} else if (map[i][j] == 0) {
					distance[i][j] = 0;
				}
			}
		}

		distance[yy][xx] = 0;
		bfs();

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				sb.append(distance[y][x] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}