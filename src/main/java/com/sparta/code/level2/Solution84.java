package com.sparta.code.level2;

class Solution84 {
    
    public int[] solution(long begin, long end) {
        int length = (int) (end - begin + 1); // 길이를 int로 변환
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            long number = begin + i;

            if (number == 1) {
                result[i] = 0; // 1은 항상 0
                continue;
            }

            result[i] = 1; // 기본 값은 1
            for (long j = 2; j <= Math.sqrt(number); j++) {
                if (number % j == 0) {
                    long divisor = number / j;
                    if (divisor <= 10_000_000) {
                        result[i] = (int) divisor; // 조건에 맞는 가장 큰 약수
                        break;
                    } else {
                        result[i] = (int) j; // 제한을 넘으면 작은 약수 사용
                    }
                }
            }
        }

        return result;
    }
    
}
