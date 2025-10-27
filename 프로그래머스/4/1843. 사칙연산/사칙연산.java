import java.util.*;

class Solution {
    public int solution(String arr[]) {      
        int len = (arr.length / 2) + 1;
        
        int[] num = new int[len];
        boolean[] isPlus = new boolean[len - 1];
        
        int[][] max = new int[len][len];
        int[][] min = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                int idx = i / 2;
                num[idx] = Integer.valueOf(arr[i]);
                max[idx][idx] = num[idx];
                min[idx][idx] = num[idx];
            } else if (arr[i].equals("+")) {
                isPlus[i / 2] = true;
            } else {
                isPlus[i / 2] = false;
            }
        }
        
        for (int d = 1; d < len; d++) {
            for (int i = 0; i < len - d; i++) {
                int j = i + d;
                for (int k = i; k < j; k++) {
                    if (isPlus[k]) {
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
                    } else {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
                    }
                }
            }
        }
                
        return max[0][len - 1];
    }
}
