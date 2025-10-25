import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 내림차순: a+b 와 b+a 를 비교
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab); // ba > ab 이면 양수 -> b가 앞
            }
        });
        
        // 모든 수가 0인 경우 대비
        if (strs.length > 0 && strs[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }
}
