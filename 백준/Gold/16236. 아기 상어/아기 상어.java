import java.io.*;
import java.util.*;

public class Main {
	static class Fish implements Comparable<Fish> {
		int y, x, size;

		public Fish(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			return Integer.compare(this.size, o.size);
		}
	}

	static int N, fishCnt, time;
	static int sharkX, sharkY, sharkSize;
	static int[][] map;
	static int INF = 20 * 20 * 6;
	static LinkedList<Fish> fishList = new LinkedList<>();

	static void shark() {
		int eat = 0;
		if (fishCnt == 0) {
			return;
		}

		while (fishCnt > 0) {
			boolean flag = dijkstra();
			if (!flag) {
				return;
			}

			eat++;
			if (eat == sharkSize) {
				eat = 0;
				sharkSize++;
			}
		}

	}

	static boolean dijkstra() {

		/* 상어로부터 갈 수 있는 모든 곳의 거리 구하기 */
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int[][] distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], INF);
		}
		distance[sharkY][sharkX] = 0;
		pq.add(new Fish(sharkY, sharkX, 0));

		while (!pq.isEmpty()) {
			Fish fish = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = fish.x + dx[i];
				int ny = fish.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (map[ny][nx] > sharkSize) {
					continue;
				}

				if (distance[ny][nx] > distance[fish.y][fish.x] + 1) {
					distance[ny][nx] = distance[fish.y][fish.x] + 1;
					pq.add(new Fish(ny, nx, map[ny][nx]));
				}
			}
		}

		/* 갈 수 있는 곳 중에 최소 거리인 곳 구하기 */
		int minDistance = INF;
		LinkedList<Integer> targetIdx = new LinkedList<>();

		for (int i = 0; i < fishList.size(); i++) {
			Fish f = fishList.get(i);
			if (f.size >= sharkSize) {
				continue;
			}
			if (distance[f.y][f.x] < minDistance) {
				targetIdx.clear();
				targetIdx.add(i);
				minDistance = distance[f.y][f.x];
			} else if (distance[f.y][f.x] == minDistance && distance[f.y][f.x] < INF) {
				targetIdx.add(i);
			}
		}
		if (targetIdx.size() == 0) {
			return false;
		}

		/* 유일한 경우 먹기 */
		int goal = targetIdx.get(0);
		if (targetIdx.size() == 1) {
			Fish f = fishList.get(goal);
			time += distance[f.y][f.x];

			map[sharkY][sharkX] = 0;
			sharkX = f.x;
			sharkY = f.y;
			map[sharkY][sharkX] = 9;

			fishList.remove(goal);

			fishCnt--;


			return true;
		}
		/* 여럿인 경우 : y값 가장 큰 물고기 > 가장 왼쪽 */
		else {
			// i = 0일 때는 이미 초기화 함. => goal = targetIdx.get(0);
			for (int i = 1; i < targetIdx.size(); i++) {
				int tmp = targetIdx.get(i);
				if (fishList.get(tmp).y == fishList.get(goal).y) {
					if (fishList.get(tmp).x < fishList.get(goal).x) { // x값 작을수록 왼쪽
						goal = tmp;
					}
				} else if (fishList.get(tmp).y < fishList.get(goal).y) { // y값 작을수록 위쪽
					goal = tmp;
				}
			}
			Fish f = fishList.get(goal);
			time += distance[f.y][f.x];

			map[sharkY][sharkX] = 0;
			sharkX = f.x;
			sharkY = f.y;

			map[sharkY][sharkX] = 9;
			fishList.remove(goal);
			fishCnt--;

		}

		return true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sharkSize = 2;
		int tmp = 0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if (tmp == 9) {
					sharkY = i;
					sharkX = j;
				} else if (tmp > 0) {
					fishCnt++;
					fishList.add(new Fish(i, j, tmp));
				}
			}
		}
		shark();
		System.out.println(time);

	}

}