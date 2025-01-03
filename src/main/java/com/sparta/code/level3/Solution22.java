package com.sparta.code.level3;

class Solution22 {
    
    public int solution(int[] a) {
        if (a.length <= 2) return a.length; // 길이가 2 이하인 경우 모든 풍선이 남을 수 있음

        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        // 왼쪽 최소값 계산
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        // 오른쪽 최소값 계산
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        // 최후까지 남을 수 있는 풍선의 개수 계산
        int count = 0;
        for (int i = 0; i < n; i++) {
            // 현재 풍선이 왼쪽 또는 오른쪽에서 최소값이면 남길 수 있음
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution22 sol = new Solution22();

        int[] test1 = {9, -1, -5};
        int[] test2 = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};

        System.out.println(sol.solution(test1)); // 3
        System.out.println(sol.solution(test2)); // 6
    }
    
}
