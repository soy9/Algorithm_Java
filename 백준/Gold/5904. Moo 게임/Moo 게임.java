import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int k = 0;
        while (getLength(k) < N) {
            k++;
        }

        System.out.println(moo(N, k));
    }

    static char moo(int n, int k) {
        if (k == 0) {
            // S(0) = "moo"
            if (n == 1) return 'm';
            else return 'o';
        }

        int lenPrev = getLength(k - 1);
        int lenMid = k + 3;

        if (n <= lenPrev) {
            return moo(n, k - 1);
        } else if (n <= lenPrev + lenMid) {
            if (n == lenPrev + 1) return 'm';
            else return 'o';
        } else {
            return moo(n - lenPrev - lenMid, k - 1);
        }
    }

    // S(k)의 전체 길이 반환
    static int getLength(int k) {
        if (k == 0) return 3; // S(0) = "moo"
        return 2 * getLength(k - 1) + (k + 3);
    }
}
