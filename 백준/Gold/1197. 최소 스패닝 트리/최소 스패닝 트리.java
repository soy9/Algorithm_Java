import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static Edge[] edgeList;
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static void makeSet() {
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		return;
	}

	static int findSet(int i) {
		if (i == parent[i])
			return i;
		return parent[i] = findSet(parent[i]);
	}

	static boolean union(int u, int v) {
		int uRoot = findSet(u);
		int vRoot = findSet(v);

		if (uRoot == vRoot) {
			return false;
		}

		parent[vRoot] = uRoot;
		return true;
	}

	static int MST() {
		int sum = 0;
		int cnt = 0;

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				sum += edge.weight;
				cnt++;
				if (cnt == (V - 1)) {
					break;
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(edgeList);

		makeSet();
		System.out.println(MST());
		
	}

}