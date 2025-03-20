package com.sparta.code.level2;

import java.util.*;

public class Solution {
    
    public int solution(int[][] targets) {
        // targets 배열을 오른쪽 끝(e) 기준으로 오름차순 정렬합
        Arrays.sort(targets, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int count = 0;
        double current = Double.NEGATIVE_INFINITY;
        
        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];
            // current가 구간 (s, e) 내에 없으면 새 요격 미사일을 발사
            if (!(s < current && current < e)) {
                count++;
                // 새 요격 미사일을 e - 0.5 (즉, e 바로 왼쪽)에서 발사
                current = e - 0.5;
            }
        }
        
        return count;
    }
    
}
