package com.sparta.code.level2;

class Solution47 {
    
    public int solution(int[] arr) {
        // 최소 공배수 계산
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd = getGCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        return lcm;
    }

    public static int getGCD(int n1, int n2) {
        // 최대 공약수 계산
        if (n1 % n2 == 0) {
            return n2;
        }
        return getGCD(n2, n1 % n2);
    }
    
}
