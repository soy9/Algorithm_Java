import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] cities;
    static int[] dist;

    public static void bfs(int start, int K) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : cities[current]) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == K) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int city : answer) {
                System.out.println(city);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 수
        int M = Integer.parseInt(st.nextToken()); // 도로 수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시

        cities = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, -1); // 거리 초기화: 방문하지 않음

        for (int i = 1; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cities[A].add(B);
        }

        bfs(X, K);
    }
}
