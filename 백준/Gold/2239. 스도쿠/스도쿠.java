import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map = new int[9][9];
	static boolean flag;

	static void dfs(int d) {
		if (d == 81) {
			flag = true;
			return;
		}

		int r = d / 9;
		int c = d % 9;

		if (map[r][c] != 0) {
			dfs(d + 1);
		} else {
			for (int i = 1; i < 10; i++) {
				if (!isValid(r, c, i)) {
					continue;
				}
				map[r][c] = i;
				dfs(d + 1);

				if (flag) {
					return;
				}
				map[r][c] = 0;
			}
		}
	}

	static boolean isValid(int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == n || map[i][c] == n) {
				return false;
			}
		}
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
//		int sc = c - c % 3;
		for (int y = sr; y < sr + 3; y++) {
			for (int x = sc; x < sc + 3; x++) {
				if (map[y][x] == n) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		dfs(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}
}
