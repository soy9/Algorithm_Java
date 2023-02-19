import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static boolean[] visited;
	static int N, leafCnt;

	public static void findLeaf(int p) {
		boolean isLeaf = true;
		visited[p] = true;
		if (parent[p] != -2) {
			for (int i = 0; i < N; i++) {
				if (parent[i] == p && !visited[i]) {
					findLeaf(i);
					isLeaf = false;

				}
			}
			if (isLeaf) {
				leafCnt++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
        int root = 0;

		parent = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
				root = i;
			}
		}

		int del = Integer.parseInt(br.readLine());
		parent[del] = -2;
        
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(del);
		while (!stack.isEmpty()) {
			int p = stack.pop();
			for (int i = 0; i < N; i++) {
				if (parent[i] == p) {
					parent[i] = -2;
					stack.push(i);
				}
			}
		}

		findLeaf(root);
		System.out.println(leafCnt);

	}

}
