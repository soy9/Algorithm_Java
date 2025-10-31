import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;
    static int[] minTime = new int[MAX + 1];
    static int[] count = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        bfs(N, K);
        System.out.println(minTime[K]);
        System.out.println(count[K]);
    }

    static void bfs(int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        minTime[start] = 0;
        count[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            int[] nextArr = {now - 1, now + 1, now * 2};
            for (int next : nextArr) {
                if (next < 0 || next > MAX) continue;

                // 첫 방문 (최단거리 처음 발견)
                if (minTime[next] == 0 && next != start) {
                    minTime[next] = minTime[now] + 1;
                    count[next] = count[now];
                    q.add(next);
                }
                // 이미 방문했지만, 같은 최단 거리로 도달 가능
                else if (minTime[next] == minTime[now] + 1) {
                    count[next] += count[now];
                }
            }
        }
    }
}
