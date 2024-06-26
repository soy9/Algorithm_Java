import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<Integer>[] list;

    static void bfs(int i) {
        for(Integer next : list[i]) {
            if(!visited[next]){
                visited[next] = true;
                bfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new LinkedList[N + 1];

        for(int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        //input end

        int res = 0;
        for(int i = 1; i <= N; i++){
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            bfs(i);
            res++;
        }

        System.out.println(res);
    }
}