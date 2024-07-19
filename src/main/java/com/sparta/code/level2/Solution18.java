package com.sparta.code.level2;

class Solution18 {
    
    public int solution(int n, int k) {
    
        String kNumber = Integer.toString(n, k);
        String[] arr = kNumber.split("0+");  // 연속된 0을 하나의 구분자로 간주

        int answer = 0;

        // 문자열 배열 순회
        for (String s : arr) {
            // 문자열을 long 타입 숫자로 변환
            long num = Long.parseLong(s);

            if (isPrime(num)) {
                answer++; // 소수인 경우 ++
            }
        }

        return answer;
    }
    
    // 소수인지 여부를 판단하는 메서드
    private boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        
        for (long i = 2; i <= Math.sqrt(num); i++) {
            // 0이면 소수가 아니므로 false
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
        
    }
    
}
