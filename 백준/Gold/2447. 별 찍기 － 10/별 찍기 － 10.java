import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[][] arr;

	public static void star(int x, int y, int len) {
		int tmpLen = len / 3;
		char tmp = arr[y][x];
		int ny, nx;
		if (len == 3) {
			arr[y + 1][x + 1] = ' ';
			return;
		}

		for (int i = 0; i < 3; i++) {
			ny = (tmpLen * i) + y;
			for (int j = 0; j < 3; j++) {
				nx = (tmpLen * j) + x;

				// 가운데 인 경우
				if (i == 1 && j == 1) {
					for (int k = 0; k < tmpLen; k++) {
						for (int h = 0; h < tmpLen; h++) {
							arr[ny + k][nx + h] = ' ';
						}
					}
					continue;
				}
				star(nx, ny, tmpLen);
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int n = Integer.parseInt(input);

		arr = new char[n][n];

		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], '*');
		}

		star(0, 0, n);

		for (int i = 0; i < n; i++) {
			sb.setLength(0);
			for (int j = 0; j < n; j++) {
				sb.append(arr[j][i]);
			}
			System.out.println(sb.toString());
		}
	}
}
