package com.sparta.code.level3;

import java.util.*;

class Solution9 {
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) return sticker[0];
        
        return Math.max(maxStickerSum(Arrays.copyOfRange(sticker, 0, n - 1)), maxStickerSum(Arrays.copyOfRange(sticker, 1, n)));
    }

    private int maxStickerSum(int[] sticker) {
        int n = sticker.length;
        if (n == 0) return 0;
        if (n == 1) return sticker[0];
        
        int[] dp = new int[n];
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0], sticker[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        
        return dp[n - 1];
    }
}
