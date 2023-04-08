import java.io.*;
import java.util.*;

public class Main {
	static int N, M, time;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Cheese> cheese = new LinkedList<Cheese>();

	static class Cheese {
		int y, x;

		public Cheese(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void melting() {

		while (!cheese.isEmpty()) {
			int cSize = cheese.size();
			Queue<Cheese> removeList = new LinkedList<Cheese>();
			for (int t = 0; t < cSize; t++) {

				Cheese c = cheese.poll();
				// 4방 탐색으로 공기 2곳 이상 접촉하는 지 확인
				int air = 0;
				for (int i = 0; i < 4; i++) {
					int ny = c.y + dy[i];
					int nx = c.x + dx[i];

					if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
						continue;
					}

					if (visited[ny][nx] && map[ny][nx] == 0) {
						air++;
					}
					if (air >= 2) {
						break;
					}
				}
				if (air < 2) {
					cheese.add(c);
				} else {
					removeList.add(c);
				}

			}
			// removeQ가 비어있지 않다면 큐에 들어있는 애들의 값을 0으로 바꾼다.
			for (Cheese rc : removeList) {
				map[rc.y][rc.x] = 0;
				visited[rc.y][rc.x] = true;

				check(rc.y, rc.x);
			}
			time++;
		}
	}

	static void check(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
				continue;
			}

			if (!visited[ny][nx] && map[ny][nx] == 0) {
				check(ny, nx);
				continue;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese.add(new Cheese(i, j));
				}
			}
		}
		// input end

		check(0, 0);
		melting();

		// output
		System.out.println(time);
	}

}