package com.sparta.code.level2;

import java.util.ArrayList;
import java.util.Arrays;

class Solution67 {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> ary = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            ary.add(i);
        }
        
        long total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        
        k--;
        
        int idx = 0;
        while (idx < n) {
            total /= (n - idx);
            answer[idx++] = ary.remove((int) (k / total));
            k %= total;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Solution67 sol = new Solution67();
        int n = 3;
        long k = 4;
        int[] result = sol.solution(n, k);
        System.out.println(Arrays.toString(result));
    }
    
}
