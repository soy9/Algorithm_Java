import java.io.*;
import java.util.*;

public class Main {
    static int[] dist;
    static List<Integer>[] list;
    static boolean[] visited;

    static void bfs(int a) {
        Queue<Integer> q = new LinkedList<>();

        for(Integer n : list[a]) {
            dist[n] = 1;
            visited[n] = true;
            q.add(n);
        }

        while(!q.isEmpty()) {
            int next = q.poll();
            for(Integer n : list[next]) {
                if(!visited[n]) {
                    dist[n] = dist[next] + 1;
                    visited[n] = true;
                    q.add(n);
                }
            }
        }

        dist[a] = 0;
    }

    static int sum(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++) {
            res += dist[i];
        }
        return res;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        list = new LinkedList[N + 1];
        visited = new boolean[N + 1];

        // init
        for(int i = 1; i <= N; i++) {
            list[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        // input end

        // 최소거리 찾기
        int min = Integer.MAX_VALUE;
        int res, minIdx = 0;
        for(int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            Arrays.fill(dist, Integer.MAX_VALUE);
            visited[i] = true;
            bfs(i);
            res = sum(N);
            if(min > res) {
                min = res;
                minIdx = i;
            }
        }

        // output
        System.out.println(minIdx);
    }
}