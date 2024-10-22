package com.sparta.code.level1;

class Solution41 {
    
    public int solution(int n) {
        int count = 0;
        
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            for (int i = start; i <= n; i++) {
                sum += i;
                if (sum == n) {
                    count++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        
        return count;
    }
    
}
