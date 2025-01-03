package com.sparta.code.level1;

class n17 {
    
    public int solution(int n) {
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count += (i * i == n) ? 1 : 2;
            }
        }
        
        return count;
    }
    
}
