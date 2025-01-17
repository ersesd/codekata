package com.sparta.code.level2;

import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems)); // 보석 종류
        int totalTypes = gemTypes.size();

        Map<String, Integer> currentWindow = new HashMap<>(); // 현재 구간 내 보석 개수
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (right < gems.length) {
            // 오른쪽 포인터가 가리키는 보석 추가
            currentWindow.put(gems[right], currentWindow.getOrDefault(gems[right], 0) + 1);

            // 모든 보석 종류를 포함하는지 확인
            while (currentWindow.size() == totalTypes) {
                if (right - left < minLength) {
                    minLength = right - left;
                    result[0] = left + 1; // 진열대 번호는 1부터 시작
                    result[1] = right + 1;
                }

                // 왼쪽 포인터가 가리키는 보석 제거
                currentWindow.put(gems[left], currentWindow.get(gems[left]) - 1);
                if (currentWindow.get(gems[left]) == 0) {
                    currentWindow.remove(gems[left]);
                }
                left++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}))); // [3, 7]
        System.out.println(Arrays.toString(sol.solution(new String[]{"AA", "AB", "AC", "AA", "AC"}))); // [1, 3]
        System.out.println(Arrays.toString(sol.solution(new String[]{"XYZ", "XYZ", "XYZ"}))); // [1, 1]
        System.out.println(Arrays.toString(sol.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}))); // [1, 5]
    }

}
