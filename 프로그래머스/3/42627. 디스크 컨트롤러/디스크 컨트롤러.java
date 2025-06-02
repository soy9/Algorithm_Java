import java.util.*;

class Work implements Comparable<Work> {
    int start;
    int time;
    int num;
    
    public Work(int start, int time, int num) {
        this.start = start;
        this.time = time;
        this.num = num;
    }
    
    @Override
    public int compareTo(Work o) {
        if (this.time != o.time) {
            return this.time - o.time;
        } else if (this.start != o.start) {
            return this.start - o.start;
        } else {
            return this.num - o.num;
        }
    }
}

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시각 기준 정렬

        PriorityQueue<Work> pq = new PriorityQueue<>();
        int time = 0;
        int pos = 0;
        int count = 0;
        int totalTurnaround = 0;
        int len = jobs.length;

        while (count < len) {
            // 현재 시점까지 들어온 작업을 큐에 추가
            while (pos < len && jobs[pos][0] <= time) {
                pq.add(new Work(jobs[pos][0], jobs[pos][1], pos));
                pos++;
            }

            if (pq.isEmpty()) {
                // 처리할 작업이 없으면 시간을 다음 요청 시각으로 점프
                time = jobs[pos][0];
                continue;
            }

            Work job = pq.poll();
            time += job.time;
            totalTurnaround += time - job.start;
            count++;
        }

        return totalTurnaround / len;
    }
}
