import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int y, x;
		int cost;

		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}

	static int[][] map;
	static int N;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int INF = Integer.MAX_VALUE;

	static int dijkstra() {
		boolean[][] visited = new boolean[N][N];
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], INF);
		}
		dist[0][0] = map[0][0];
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Node(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Node curNode = pq.remove();

			if (curNode.y == N - 1 && curNode.x == N - 1) {
				break;
			}

			if (visited[curNode.y][curNode.x]) {
				continue;
			}

			visited[curNode.y][curNode.x] = true;

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + curNode.y;
				int nx = dx[i] + curNode.x;

				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) {
					continue;
				}

				if (dist[ny][nx] > dist[curNode.y][curNode.x] + map[ny][nx]) {
					dist[ny][nx] = dist[curNode.y][curNode.x] + map[ny][nx];
					pq.add(new Node(ny, nx, dist[ny][nx]));
				}
			}
		}
		return dist[N - 1][N - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = 0;
		int t = 0;

		while (true) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			if (N == 0) {
				break;
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// input end

			sb.append("Problem " + (++t)).append(": " + dijkstra()).append("\n");
		}

		// output
		System.out.println(sb);

	}

}