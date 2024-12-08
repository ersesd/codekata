package com.sparta.code.level3;

class Solution18 {
    
    public int solution(int n, int[] money) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];

        // 거슬러줄 금액이 0일 때는 방법이 1가지
        dp[0] = 1;

        // 각 화폐 단위를 이용하여 dp 테이블 갱신
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution18 sol = new Solution18();
        System.out.println(sol.solution(5, new int[]{1, 2, 5})); // Output: 4
    }

}
