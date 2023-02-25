import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static int[][] map;
	static int[] dx = { 1, 1, 0 }; // 가로(0), 대각선(1), 세로(2)
	static int[] dy = { 0, 1, 1 };
	static int[][] state = { { 0, 1 }, { 0, 1, 2 }, { 1, 2 } }; // 0: 가로(0, 1), 1: 대각선(0, 2), 2: 세로(1, 2)

	static void pipe(int dir, int y, int x) {

		if (y == N - 1 && x == N - 1) {
			cnt++;
			return;
		}

		for (int i = 0; i < state[dir].length; i++) {
			int ny = y + dy[state[dir][i]];
			int nx = x + dx[state[dir][i]];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] != 1) {
				
				// 대각선으로 갈 때 주변에 벽 있는지 확인
				if (state[dir][i] != 1) {
					pipe(state[dir][i], ny, nx);
			
				} else if(map[ny - 1][nx] == 0 && map[ny][nx - 1] == 0) {
					pipe(state[dir][i], ny, nx);
				}
			} 
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pipe(0, 0, 1);
		System.out.println(cnt);
	}

}
