package com.sparta.code.level2;

class Solution {

    public long solution(int w, int h) {
        long totalSquares = (long) w * h; // 전체 정사각형의 개수
        long gcd = gcd(w, h); // 최대공약수 계산
        long unusableSquares = w + h - gcd; // 사용할 수 없는 정사각형 계산
        return totalSquares - unusableSquares; // 사용할 수 있는 정사각형 반환
    }

    // 최대공약수를 계산하는 유클리드 호제법
    private long gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8, 12)); // 80
    }

}
