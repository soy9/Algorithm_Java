import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; // [y][x][0]: 벽 안 부숨, [y][x][1]: 벽 부숨
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x, dist, broken;

        Node(int y, int x, int dist, int broken) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.broken = broken;
        }
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.y == N - 1 && cur.x == M - 1) {
                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

                // 다음 위치가 벽이 아닐 경우
                if (map[ny][nx] == 0 && !visited[ny][nx][cur.broken]) {
                    visited[ny][nx][cur.broken] = true;
                    q.add(new Node(ny, nx, cur.dist + 1, cur.broken));
                }

                // 다음 위치가 벽인데 아직 벽을 안 부쉈을 경우
                else if (map[ny][nx] == 1 && cur.broken == 0 && !visited[ny][nx][1]) {
                    visited[ny][nx][1] = true;
                    q.add(new Node(ny, nx, cur.dist + 1, 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
