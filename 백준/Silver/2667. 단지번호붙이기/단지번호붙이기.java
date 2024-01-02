import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	static class Info {
		int y, x;

		public Info(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static LinkedList<Info> q = new LinkedList<>();

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int bfs(int x, int y) {
		LinkedList<Info> infoQ = new LinkedList<>();
		infoQ.add(new Info(y, x));
		visited[y][x] = true;
		int totalCnt = 0;

		while (!infoQ.isEmpty()) {
			Info pos = infoQ.poll();
			totalCnt++;

			for (int i = 0; i < 4; i++) {
				int ny = pos.y + dy[i];
				int nx = pos.x + dx[i];

				if (ny < 0 || nx < 0 || nx >= N || ny >= N || visited[ny][nx]) {
					continue;
				}

				if (map[ny][nx] == 1) {
					visited[ny][nx] = true;
					infoQ.add(new Info(ny, nx));
				}
			}
		}

		return totalCnt;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 1) {
					q.add(new Info(i, j));
				}
			}
		}
		// input end

		int total = 0;
		LinkedList<Integer> resList = new LinkedList<>();

		while (!q.isEmpty()) {
			Info tmpQ = q.poll();

			if (visited[tmpQ.y][tmpQ.x]) {
				continue;
			}

			resList.add(bfs(tmpQ.x, tmpQ.y));
			total++;
		}

		// 단지수 오름차순 정렬
		Collections.sort(resList);

		sb.append(total).append("\n");
		for (Integer res : resList) {
			sb.append(res).append("\n");
		}
		System.out.println(sb);

	}

}