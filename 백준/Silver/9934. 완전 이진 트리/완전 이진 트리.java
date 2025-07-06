import java.util.*;

public class Main {
    static List<List<Integer>> levels = new ArrayList<>();
    static int[] inorder;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = (int)Math.pow(2, K) - 1;

        inorder = new int[N];
        for (int i = 0; i < N; i++) {
            inorder[i] = sc.nextInt();
        }

        for (int i = 0; i < K; i++) {
            levels.add(new ArrayList<>());
        }

        buildTree(0, N - 1, 0);  // start, end, level

        for (List<Integer> level : levels) {
            for (int num : level) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static void buildTree(int start, int end, int depth) {
        if (start > end) return;

        int mid = (start + end) / 2;
        levels.get(depth).add(inorder[mid]);

        buildTree(start, mid - 1, depth + 1);  // 왼쪽 서브트리
        buildTree(mid + 1, end, depth + 1);    // 오른쪽 서브트리
    }
}
