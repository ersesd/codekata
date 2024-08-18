package com.sparta.code.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution36 {

    public List<Integer> solution(String s) {
        // 문자열에서 중괄호를 제거한 이후 집합을 "-"로 분리
        s = s.replaceAll("[{}]", "").replace("},{", "-");
        String[] sArr = s.split("-");

        // 배열을 길이순으로 정렬
        Arrays.sort(sArr, (a, b) -> a.length() - b.length());

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // 각 집합을 순회하여 정수로 변환
        for (String el : sArr) {
            String[] check = el.split(",");
            for (String str : check) {
                int num = Integer.parseInt(str);
                // 중복된 값이 없는 경우 리스트에 추가
                if (!set.contains(num)) {
                    set.add(num);
                    list.add(num);
                }
            }
        }

        return list;
    }
}