import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int value; // A[i]
        int index; // i

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Pair o) {
            if (this.value == o.value) {
                return Integer.compare(this.index, o.index);
            }
            return Integer.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        Pair[] pairs = new Pair[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            pairs[i] = new Pair(A[i], i);
        }
        
        Arrays.sort(pairs);

        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[pairs[i].index] = i;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}
