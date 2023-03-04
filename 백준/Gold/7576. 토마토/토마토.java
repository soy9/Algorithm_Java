import java.io.*;
import java.util.*;

public class Main {
	static class Position {
		int y, x;

		public Position(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static int M, N, tomato, raw, time;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Position> q = new LinkedList<Position>();

	static void bfs() {
		int next = 0;
		while (!q.isEmpty()) {
			next = 0;
			for (int i = 0; i < tomato; i++) {
				Position tmt = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = tmt.x + dx[d];
					int ny = tmt.y + dy[d];
					
					if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
						continue;
					}
					if (map[ny][nx] == 0) {
						q.add(new Position(ny, nx));
						next++;
						map[ny][nx] = 1;
						raw--;
					}
				}
			}
			tomato = next;
			time++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new Position(i, j));
					tomato++;
				} else if (map[i][j] == 0) {
					raw++;
				}
			}
		}

		bfs();
		time = (raw > 0) ? -1 : (time - 1);
		System.out.println(time);
	}
}