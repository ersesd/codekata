package com.sparta.code.level2;

public class Solution52 {
    public static void main(String[] args) {
        System.out.println(solution(4)); 
    }

    public static int solution(int n) {
        if (n == 1) return 1;  
        if (n == 2) return 2;

        int[] arr = new int[n];
        arr[0] = 1;  // 세로
        arr[1] = 2;  // 가로

        // arr[2]부터 시작
        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }

        return arr[n - 1];
    }
}
