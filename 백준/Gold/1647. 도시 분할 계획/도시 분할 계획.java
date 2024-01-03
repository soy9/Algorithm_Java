import java.util.*;
import java.io.*;

public class Main {

	static class Node implements Comparable<Node> {
		int v1, v2;
		int cost;

		public Node(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	static List<Node> list;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new LinkedList<>();
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.add(new Node(v1, v2, cost));
		}
		Collections.sort(list);
		int totalCnt = 0;
		int sum = 0;
		int maxCost = -1;

		for (Node node : list) {
			if (find(node.v1) != find(node.v2)) {
				union(node.v1, node.v2);
				sum += node.cost;
				maxCost = Math.max(node.cost, maxCost);
				totalCnt++;
			}

			if (totalCnt == N - 1) {
				break;
			}
		}

		System.out.println(sum - maxCost);
	}

	public static int find(int node) {
		if (parent[node] != parent[parent[node]]) {
			parent[node] = find(parent[parent[node]]);
		}
		return parent[node];
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa <= pb)
			parent[pb] = parent[pa];
		else
			parent[pa] = parent[pb];
	}

}