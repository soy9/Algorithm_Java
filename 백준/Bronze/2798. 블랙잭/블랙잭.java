import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m, max = 0;
		int[] arr = null;
		int tmp;
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					tmp = arr[i] + arr[j] + arr[k];
					if (tmp <= m && tmp > max) {
						max = tmp;
					}
				}
			}
		}

		System.out.println(max);
	}

}