import java.util.Scanner;

public class Main {

	static String[] str;

	public static void quad(int x, int y, int len) {
		char tmp = str[y].charAt(x);
		if (len == 1) {
			System.out.print(tmp);
			return;
		}

		for (int i = 0; i < len; i++) {
			int ny = y + i;
			for (int j = 0; j < len; j++) {
				int nx = x + j;
				if (str[ny].charAt(nx) != tmp) {
					System.out.print("(");
					// 좌 상
					quad(x, y, (len / 2));
					// 우 상
					quad(x + (len / 2), y, (len / 2));
					// 좌 하
					quad(x, y + (len / 2), (len / 2));
					// 우 하
					quad(x + (len / 2), y + (len / 2), (len / 2));
					System.out.print(")");
					return;
				}
			}
		}
		System.out.print(tmp);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int left = 0, right = 0;
		int n = sc.nextInt();
		str = new String[n];

		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}
		quad(left, right, n);
	}

}
