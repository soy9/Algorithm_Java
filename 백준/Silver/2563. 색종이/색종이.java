import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N, x, y;

		boolean[][] color = new boolean[100][100];
		int cnt = 0;

		N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int i = y - 1; i < y + 9; i++) {
				for (int j = x - 1; j < x + 9; j++) {
					if (color[i][j] == false) {
						color[i][j] = true;
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}
