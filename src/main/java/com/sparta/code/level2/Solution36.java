package com.sparta.code.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution36 {

    public int[] solution(String s) {
        // 중괄호 제거한 이후 집합을 분리
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] sArr = s.split("-");

        // 배열을 길이 순으로 정렬
        Arrays.sort(sArr, (a, b) -> a.length() - b.length());

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        //집합을 순회하여 정수로 변환후 중복되지 않은 숫자를 리스트의 추가
        for (String el : sArr) {
            String[] check = el.split(",");
            for (String str : check) {
                int num = Integer.parseInt(str);
                if (set.add(num)) {
                    list.add(num);
                }
            }
        }

        // List를 int[]로 변환하여 반환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
