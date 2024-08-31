package com.sparta.code.level2;

import java.util.ArrayList;
import java.util.List;

class Solution44 {
    
    public int solution(String str1, String str2) {
        // 두 문자열을 소문자로 변환이후 2글자씩 리스트에 저장
        List<String> list1 = stringSplit(str1);
        List<String> list2 = stringSplit(str2);

        // 두 리스트가 모두 비어있을 경우
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        List<String> union = new ArrayList<>(list1);  // 합집합
        List<String> inter = new ArrayList<>();       // 교집합

        // 리스트 순회후 교집합, 합집합 계산
        for (String s : list1) {
            if (list2.remove(s)) {  // 두 번째 리스트의 같은 것을 교집합에 추가
                inter.add(s);
            }
        }

        union.addAll(list2);

        // 자카드 유사도(교집합 크기 / 합집합 크기)
        double jacquard = (double) inter.size() / union.size();

        return (int) (jacquard * 65536);
    }

    // 문자열을 2글자씩 끊어서 리스트에 저장하는 함수
    private List<String> stringSplit(String str) {
        List<String> list = new ArrayList<>();
        str = str.toLowerCase(); // 소문자로 변환

        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);

            if (Character.isLetter(first) && Character.isLetter(second)) {
                list.add("" + first + second);
            }
        }

        return list;
    }
}
