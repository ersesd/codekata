package com.sparta.code.level2;

class Solution33 {
    
    public int solution(int n) {
        
        int cnt = countOnesInBinary(n);
        
        for (int i = n + 1; ; i++) {
            if (countOnesInBinary(i) == cnt) {
                return i;
            }
        }
    }
    
    // 주어진 숫자를 2진수로 변환후 1의 비트 개수를 세는 함수
    private int countOnesInBinary(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) count++;  // 비트 발견시 카운트를 증가시킴
            num /= 2;  // 다음 비트를 확인하기 위해 숫자를 2로 나눔
        }
        return count;
    }
    
}
