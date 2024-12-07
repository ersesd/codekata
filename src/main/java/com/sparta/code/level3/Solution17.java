package com.sparta.code.level3;

class Solution17 {
    
    public int solution(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;

        // 모든 단일 문자들은 팰린드롬이다.
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 두 문자로 된 팰린드롬 확인
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }

        // 세 문자 이상인 부분 문자열 확인
        for (int len = 3; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;

                // 현재 문자열의 양 끝이 같고 내부 문자열이 팰린드롬이면
                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                    maxLength = len;
                }
            }
        }

        return maxLength;
    }
    
}
