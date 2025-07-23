import java.io.*;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line> {
        int start, end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new Line(x, y));
        }

        Collections.sort(lines);  // 시작점을 기준으로 정렬

        long totalLength = 0;
        int currentStart = lines.get(0).start;
        int currentEnd = lines.get(0).end;

        for (int i = 1; i < N; i++) {
            Line line = lines.get(i);
            if (line.start <= currentEnd) {  // 선분이 겹침
                currentEnd = Math.max(currentEnd, line.end);  // 병합
            } else {
                totalLength += currentEnd - currentStart;  // 이전 선분 길이 더함
                currentStart = line.start;
                currentEnd = line.end;
            }
        }

        totalLength += currentEnd - currentStart;  // 마지막 선분 길이 더함

        System.out.println(totalLength);
    }
}
