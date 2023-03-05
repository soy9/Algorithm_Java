import java.io.*;
import java.util.*;

public class Main {

	static class Bus implements Comparable<Bus> {
		int to, cost;

		public Bus(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bus o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static LinkedList<Bus>[] busList;
	static int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[] dist;

	static int findMinCost(int s, int t) {
		PriorityQueue<Bus> pq = new PriorityQueue<Bus>();
		boolean visited[] = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

		pq.add(new Bus(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Bus bus = pq.poll();
			int now = bus.to;

			if (!visited[now]) {
				visited[now] = true;
				for (Bus b : busList[bus.to]) {
					if (dist[b.to] > dist[now] + b.cost) {
						dist[b.to] = dist[now] + b.cost;
						pq.add(new Bus(b.to, dist[b.to]));
					}
				}
			}
		}

		return dist[t];

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		busList = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			busList[i] = new LinkedList<Bus>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			busList[from].add(new Bus(to, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());

		System.out.println(findMinCost(start, destination));

	}

}