import java.io.*;
import java.util.*;

public class Main {

	static class Tomato {
		int z, y, x;

		public Tomato(int z, int y, int x) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
		}

	}

	static int M, N, H;
	static int[][][] box;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dz = { -1, 1 };
	static int totalTomatoCnt;
	static int time;

	static Queue<Tomato> tomatoes = new LinkedList<Tomato>();

	static void dfs(int cnt) {
		int pCnt = cnt;

		while (!tomatoes.isEmpty()) {
			int nextCnt = 0;
			for (int i = 0; i < pCnt; i++) {
				Tomato now = tomatoes.poll();
				for (int d = 0; d < 4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
						continue;
					}
					if (box[now.z][ny][nx] == 0) {
						box[now.z][ny][nx] = 1;
						tomatoes.add(new Tomato(now.z, ny, nx));
						nextCnt++;
					}
				}
				for (int d = 0; d < 2; d++) {
					int nz = now.z + dz[d];
					if (nz < 0 || nz >= H) {
						continue;
					}
					if (box[nz][now.y][now.x] == 0) {
						box[nz][now.y][now.x] = 1;
						tomatoes.add(new Tomato(nz, now.y, now.x));
						nextCnt++;
					}
				}
			}
			if (nextCnt > 0) {
				pCnt = nextCnt;
				totalTomatoCnt += nextCnt;
				time++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H][N][M];
		int cnt = 0;
		int emptyCnt = 0;
		
		for (int z = 0; z < H; z++) {
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					box[z][y][x] = Integer.parseInt(st.nextToken());
					if (box[z][y][x] == 1) {
						tomatoes.add(new Tomato(z, y, x));
						cnt++;
						totalTomatoCnt++;
					} else if (box[z][y][x] == -1) {
						emptyCnt++;
					}
				}
			}
		}

		if (cnt == (M * N * H)) {
			System.out.println("0");
		} else {
			dfs(cnt);

			if (totalTomatoCnt == (M * N * H) - emptyCnt) {
				System.out.println(time);
			} else {
				System.out.println("-1");
			}
		}
	}

}