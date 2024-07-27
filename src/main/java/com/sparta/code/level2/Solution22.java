package com.sparta.code.level2;

import java.util.*;

class Solution22 {
    
    public int solution(int x, int y, int n) {
        // x가 이미 y와 같다면 0
        if (x == y) {
            return 0;
        }
        
        // 배열을 사용하여 각 숫자에 도달하는 최소 단계 수를 저장
        int[] cnt = new int[1000001];
        Arrays.fill(cnt, -1);
        cnt[x] = 0;
        
        // x에서 y까지의 모든 숫자를 순회
        for (int i = x; i <= y; i++) {
            // cnt[i]가 초기값(-1)인 경우는 건너뜀
            if (cnt[i] == -1) {
                continue;
            }
            
            int nc = cnt[i] + 1;
            
            // 세 가지 변환 방법을 사용하여 다음 숫자로 이동
            if (i + n <= y) {
                cnt[i + n] = cnt[i + n] == -1 ? nc : Math.min(cnt[i + n], nc);
            }
            if (i * 2 <= y) {
                cnt[i * 2] = cnt[i * 2] == -1 ? nc : Math.min(cnt[i * 2], nc);
            }
            if (i * 3 <= y) {
                cnt[i * 3] = cnt[i * 3] == -1 ? nc : Math.min(cnt[i * 3], nc);
            }
        }
        
        // y에 도달하는 최소 단계 수 반환
        return cnt[y];
    }
    
}
