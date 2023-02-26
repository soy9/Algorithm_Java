import java.io.*;
import java.util.*;

public class Main {

	static int N, minDiff = Integer.MAX_VALUE;
	static int[] population;
	static List<List<Integer>> list = new ArrayList<List<Integer>>();
	static boolean[] visited;

	static int checkConnected(int num, int totalCity, boolean flag) {
		boolean[] checked = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		int sum = population[num];

		checked[num] = true;
		q.add(num);

		int cnt = 1;
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i : list.get(node)) {
				if (!checked[i] && visited[i] == flag) {
					checked[i] = true;
					cnt++;
					sum += population[i];
					q.add(i);
				}
			}
		}

		if (cnt == totalCity) {
			return sum;
		} else {
			return -1;
		}

	}

	static void combi(int start, int n, int r, int cnt) {

		if (r == 0) {
			int groupA = -1;
			// 두 그룹이 연결되어있는 지 확인
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					groupA = checkConnected(i, n - cnt, false);
					break;
				}
			}
			int groupB = -1;
			if (groupA != -1) {
				for (int i = 1; i <= N; i++) {
					if (visited[i]) {
						groupB = checkConnected(i, cnt, true);
						break;
					}
				}
				if (groupB != -1) {
					minDiff = (minDiff < Math.abs(groupA - groupB)) ? minDiff : Math.abs(groupA - groupB);
				}
			}

			// 둘다 연결되어 있다면 인구수 차이 확인
			return;
		}
		for (int i = start; i <= n; i++) {
			visited[i] = true;
			combi(i + 1, n, r - 1, cnt);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				list.get(i).add(tmp);
			}
		}

		for (int i = 1; i <= N / 2; i++) {
			combi(1, N, i, i);
		}

		minDiff = (minDiff == Integer.MAX_VALUE) ? -1 : minDiff;

		System.out.println(minDiff);

	}

}
