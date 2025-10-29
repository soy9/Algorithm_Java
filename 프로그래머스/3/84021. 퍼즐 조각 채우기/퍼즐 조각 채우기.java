import java.util.*;

class Solution {

    // 4방향 탐색 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        boolean[][] visitedBoard = new boolean[n][n];
        boolean[][] visitedTable = new boolean[n][n];

        // 1. game_board에서 빈칸(0) 모양 추출
        List<List<int[]>> emptySpaces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !visitedBoard[i][j]) {
                    emptySpaces.add(bfs(game_board, visitedBoard, i, j, 0));
                }
            }
        }

        // 2. table에서 블록(1) 모양 추출
        List<List<int[]>> blocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    blocks.add(bfs(table, visitedTable, i, j, 1));
                }
            }
        }

        // 3. 각 빈칸과 블록 매칭 시도
        boolean[] used = new boolean[blocks.size()];
        int answer = 0;

        for (List<int[]> space : emptySpaces) {
            for (int b = 0; b < blocks.size(); b++) {
                if (used[b]) continue;
                List<int[]> block = blocks.get(b);

                if (space.size() != block.size()) continue; // 크기 다르면 비교 X

                // 4. 블록 4방향 회전 비교
                if (match(space, block)) {
                    answer += space.size();
                    used[b] = true;
                    break;
                }
            }
        }

        return answer;
    }

    // BFS로 모양 추출
    private List<int[]> bfs(int[][] board, boolean[][] visited, int sx, int sy, int target) {
        int n = board.length;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> shape = new ArrayList<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        int minX = sx, minY = sy;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            shape.add(new int[]{x, y});
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || board[nx][ny] != target) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        // 좌표 정규화 (0,0 기준으로)
        List<int[]> normalized = new ArrayList<>();
        for (int[] pos : shape) {
            normalized.add(new int[]{pos[0] - minX, pos[1] - minY});
        }

        return normalized;
    }

    // 모양 비교 (회전 포함)
    private boolean match(List<int[]> space, List<int[]> block) {
        for (int rot = 0; rot < 4; rot++) {
            block = rotate(block);
            List<int[]> normBlock = normalize(block);

            if (equalsShape(space, normBlock)) {
                return true;
            }
        }
        return false;
    }

    // 90도 회전
    private List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        int maxX = 0, maxY = 0;

        for (int[] pos : shape) {
            maxX = Math.max(maxX, pos[0]);
            maxY = Math.max(maxY, pos[1]);
        }

        for (int[] pos : shape) {
            int x = pos[0], y = pos[1];
            rotated.add(new int[]{y, maxX - x});
        }
        return rotated;
    }

    // 좌표 정규화 (좌상단 0,0으로 맞춤)
    private List<int[]> normalize(List<int[]> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] pos : shape) {
            minX = Math.min(minX, pos[0]);
            minY = Math.min(minY, pos[1]);
        }

        List<int[]> result = new ArrayList<>();
        for (int[] pos : shape) {
            result.add(new int[]{pos[0] - minX, pos[1] - minY});
        }

        // 비교 용이하도록 정렬
        result.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        return result;
    }

    // 두 모양이 같은지 비교
    private boolean equalsShape(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;

        List<int[]> na = normalize(a);
        List<int[]> nb = normalize(b);

        for (int i = 0; i < na.size(); i++) {
            if (na.get(i)[0] != nb.get(i)[0] || na.get(i)[1] != nb.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
}
