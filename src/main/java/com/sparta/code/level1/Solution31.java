package com.sparta.code.level1;

class Solution31 {

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (isPrime(num)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {  // 제곱근까지만 체크
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
