import java.io.*;
import java.util.Arrays;

public class Main {
	static int N, blue, red, green, rg;
	static int[][] map; // B:0, R:1, G:2
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int cnt3, cnt2;

	static void findArea(int y, int x, int color) {
		int nx, ny;
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];

			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if (map[ny][nx] == color && !visited[ny][nx]) {
					findArea(ny, nx, color);
				}
			}
		}
	}

	static void rgArea(int y, int x) {
		int nx, ny;
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];

			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if (map[ny][nx] != 0 && !visited[ny][nx]) {
					rgArea(ny, nx);
				}
			}
		}
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
				if (str.charAt(j) == 'B') {
					map[i][j] = 0;
				} else if (str.charAt(j) == 'R') {
					map[i][j] = 1;
				} else if (str.charAt(j) == 'G') {
					map[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					findArea(i, j, 0);
					blue++;
				} else if (!visited[i][j] && map[i][j] == 1) {
					findArea(i, j, 1);
					red++;
				} else if (!visited[i][j] && map[i][j] == 2) {
					findArea(i, j, 2);
					green++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					rgArea(i, j);
					rg++;
				}
			}
		}

		sb.append(blue + red + green).append(" ").append(blue + rg);
		System.out.println(sb);
	}

}