package com.sparta.code.level2;

import java.util.*;

class Solution114 {
    
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> menuCount = new HashMap<>();

        // 각 주문 정렬 및 조합 생성
        for (String order : orders) {
            char[] items = order.toCharArray();
            Arrays.sort(items);
            String sortedOrder = new String(items);
            
            for (int c : course) {
                generateCombinations(sortedOrder, c, 0, new StringBuilder(), menuCount);
            }
        }

        List<String> result = new ArrayList<>();

        // 코스별 최다 주문 조합 찾기
        for (int c : course) {
            int maxCount = 0;
            List<String> candidates = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : menuCount.entrySet()) {
                if (entry.getKey().length() == c && entry.getValue() >= 2) {
                    if (entry.getValue() > maxCount) {
                        maxCount = entry.getValue();
                        candidates.clear();
                        candidates.add(entry.getKey());
                    } else if (entry.getValue() == maxCount) {
                        candidates.add(entry.getKey());
                    }
                }
            }

            result.addAll(candidates);
        }

        // 결과 정렬 후 반환
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void generateCombinations(String order, int size, int start, StringBuilder current, Map<String, Integer> menuCount) {
        if (current.length() == size) {
            String combination = current.toString();
            menuCount.put(combination, menuCount.getOrDefault(combination, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            current.append(order.charAt(i));
            generateCombinations(order, size, i + 1, current, menuCount);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution114 sol = new Solution114();

        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2, 3, 4};
        System.out.println(Arrays.toString(sol.solution(orders1, course1))); // ["AC", "ACDE", "BCFG", "CDE"]

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};
        System.out.println(Arrays.toString(sol.solution(orders2, course2))); // ["ACD", "AD", "ADE", "CD", "XYZ"]

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2, 3, 4};
        System.out.println(Arrays.toString(sol.solution(orders3, course3))); // ["WX", "XY"]
    }
    
}
