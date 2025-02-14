package com.sparta.code.level2;

import java.util.*;

public class Solution1 {
    
    public int solution(int[] A, int[] B) {
        // 배열 A를 오름차순 정렬
        Arrays.sort(A);
        // 배열 B를 오름차순 정렬한 후, 내림차순으로 사용하기 위해 뒤에서부터 접근
        Arrays.sort(B);
        
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // A의 i번째 원소와 B의 (n-i-1)번째 원소를 곱함
            sum += A[i] * B[n - i - 1];
        }
        return sum;
    }
    
    // 테스트를 위한 메서드
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        
        int[] A1 = {1, 4, 2};
        int[] B1 = {5, 4, 4};
        System.out.println(sol.solution(A1, B1)); // 예상 출력: 29
        
        int[] A2 = {1, 2};
        int[] B2 = {3, 4};
        System.out.println(sol.solution(A2, B2)); // 예상 출력: 10
    }
    
}
