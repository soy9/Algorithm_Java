class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if (len == 1) return sticker[0];
        if (len == 2) return Math.max(sticker[0], sticker[1]);

        int[] dp1 = new int[len - 1]; // 0번 스티커 포함 (마지막은 제외)
        int[] dp2 = new int[len];     // 0번 스티커 미포함 (마지막 포함 가능)

        // case 1: 첫 번째 스티커를 선택하는 경우
        dp1[0] = sticker[0];
        dp1[1] = dp1[0]; // 두 번째 스티커 선택 못 함

        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // case 2: 첫 번째 스티커를 선택하지 않는 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < len; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[len - 2], dp2[len - 1]);
    }
}
