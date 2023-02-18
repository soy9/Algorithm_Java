import java.io.*;
import java.util.*;

class Address {
	int y, x;

	public Address(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class Main {

	static List<Address> house = new ArrayList<Address>();
	static List<Address> chicken = new ArrayList<Address>();
	static int M;
	static int minTotalDist = Integer.MAX_VALUE;

	public static void combination(boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			findDistance(visited);
			return;
		}
		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	public static void findDistance(boolean[] visited) {
		int houseCnt = house.size();
		int[][] dist1 = new int[houseCnt][M];
		int idx = 0;

		for (int i = 0; i < chicken.size(); i++) {
			if (visited[i]) {
				// 거리 계산 수행
				for (int j = 0; j < houseCnt; j++) {
					int tmp = Math.abs(house.get(j).y - chicken.get(i).y) + Math.abs(house.get(j).x - chicken.get(i).x);

					dist1[j][idx] = tmp;
				}
				idx++;
			}
		}

		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < houseCnt; i++) {
			min = dist1[i][0];
			for (int j = 1; j < M; j++) {
				min = Math.min(dist1[i][j], min);
			}
			sum += min;
		}

		minTotalDist = Math.min(minTotalDist, sum);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) {
					// 1: 집
					house.add(new Address(i, j));
				} else if (input == 2) {
					// 2: 치킨집
					chicken.add(new Address(i, j));
				}
			}
		}

		combination(new boolean[chicken.size()], 0, chicken.size(), M);

		System.out.println(minTotalDist);
	}
}
