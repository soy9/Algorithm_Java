import java.io.*;
import java.util.*;

public class Main {
	static int A, B, N;
	static int t, m;
	static String c;
	static int totalGifts;
	static Queue<Integer> queueB = new LinkedList<Integer>();
	static Queue<Integer> queueR = new LinkedList<Integer>();
	static HashMap<Integer, Integer> mapB = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> mapR = new HashMap<Integer, Integer>();

	public static void packing() {
		int giftIdx = 0;

		int blueWaiting = 0;
		int redWaiting = 0;

		int bluePacking = 0;
		int redPacking = 0;

		int time = 1;

		while (giftIdx < totalGifts) {
			// blue
			if (mapB.containsKey(time)) {
				blueWaiting += mapB.get(time);
				if (A == 0) {
					int tmp = mapB.get(time);
					while (tmp > 0) {
						queueB.add(++giftIdx);
						tmp--;
					}
					blueWaiting = 0;
					
				}
			}
			if (bluePacking > 0) {
				bluePacking--;
			}
			if (bluePacking == 0 && blueWaiting > 0) {
				blueWaiting--;
				bluePacking = A;
				queueB.add(++giftIdx);
			}

			// red
			if (mapR.containsKey(time)) {
				redWaiting += mapR.get(time);
				if (B == 0) {
					int tmp = mapR.get(time);
					while (tmp > 0) {
						queueR.add(++giftIdx);
						tmp--;
					}
					redWaiting = 0;
				}
			}
			if (redPacking > 0) {
				redPacking--;
			}
			if (redPacking == 0 && redWaiting > 0) {
				redWaiting--;
				redPacking = B;
				queueR.add(++giftIdx);
			}
			time++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken()); // 상민이 걸리는 시간
		B = Integer.parseInt(st.nextToken()); // 지수가 걸리는 시간
		N = Integer.parseInt(st.nextToken()); // 손님 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken()); // 주문시각
			c = st.nextToken(); // 색깔 B:상민, R:지수
			m = Integer.parseInt(st.nextToken()); // 주문개수

			if (c.equals("B")) {
				mapB.put(t, m);
			} else {
				mapR.put(t, m);
			}
			totalGifts += m;
		}

		packing();

		Iterator<Integer> iterB = queueB.iterator();
		Iterator<Integer> iterR = queueR.iterator();

		System.out.println(queueB.size());
		while (iterB.hasNext()) {
			System.out.print(iterB.next());
			System.out.print(" ");
		}
		System.out.println();
		System.out.println(queueR.size());
		while (iterR.hasNext()) {
			System.out.print(iterR.next());
			System.out.print(" ");
		}

	}

}
