import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int n;
		int time;
		
		Node(int n, int time) {
			this.n = n;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int answer = bfs(N, M);
		
		System.out.print(answer);
	}
	
	static int bfs(int n, int goal) {
		boolean[] visited = new boolean[200001];
		int answer = -1;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n, 0));
		visited[n] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.n == goal) {
				return node.time;
			}

			int next1 = node.n - 1;
			int next2 = node.n + 1;
			int next3 = node.n * 2;
			
			if(next1 == goal || next2 == goal || next3 == goal) {
				return node.time + 1;
			}
			
			if(next1 >= 0 && next1 <= 200000 && !visited[next1]) {
				q.add(new Node(node.n - 1, node.time + 1));
				visited[next1] = true;
			}
			
			if(next2 <= 200000 && !visited[next2]) {
				q.add(new Node(next2, node.time + 1));
				visited[next2] = true;
			}
			
			if(next3 <= 200000 && !visited[next3] && next3 <= goal * 2) {
				q.add(new Node(next3, node.time + 1));
				visited[next3] = true;
			}
			
		}
		
		return answer;
	}

}
