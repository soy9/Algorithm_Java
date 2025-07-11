import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Main {
    static class Node {
        int next;
        int dist;
        
        Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }
    
    static int answer;
    static List<Node>[] tree;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            tree[from].add(new Node(to, cost));
        }
        // input end
        
        dfs(1);
		System.out.println(answer);
	}
    
    static int dfs(int node) {
        int sum = 0;
        int max = 0;
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        
        for(Node n : tree[node]) {
            int dist = dfs(n.next) + n.dist;
            list.add(dist);
            
            max = Math.max(dist, max);
            cnt++;
        }
        list.sort((a, b) -> b - a);
        
        if(cnt > 0 && cnt < 2) {
        	sum = list.get(0);
        } else if(cnt >= 2){
        	for(int i = 0; i < 2; i++) {
        		sum += list.get(i);
        	}
        }
        
        answer = Math.max(sum, answer);
        
        return max;
    }

}