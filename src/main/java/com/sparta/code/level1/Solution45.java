package com.sparta.code.level1;

import java.util.*;

class Solution45 {
    
    public String solution(String[] survey, int[] choices) {
        // 성격 유형별 점수를 저장할 Map
        Map<Character, Integer> scores = new HashMap<>();
        
        // 초기화 (모든 유형을 0점으로)
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char type : types) {
            scores.put(type, 0);
        }

        // 점수 계산
        for (int i = 0; i < survey.length; i++) {
            char disagreeType = survey[i].charAt(0);
            char agreeType = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) { // 비동의 선택
                scores.put(disagreeType, scores.get(disagreeType) + (4 - choice));
            } else if (choice > 4) { // 동의 선택
                scores.put(agreeType, scores.get(agreeType) + (choice - 4));
            }
        }

        // 결과 조합
        String result = String.valueOf(scores.get('R') >= scores.get('T') ? 'R' : 'T') +
                (scores.get('C') >= scores.get('F') ? 'C' : 'F') +
                (scores.get('J') >= scores.get('M') ? 'J' : 'M') +
                (scores.get('A') >= scores.get('N') ? 'A' : 'N');

        return result;
    }

    public static void main(String[] args) {
        Solution45 sol = new Solution45();

        System.out.println(sol.solution(
            new String[]{"AN", "CF", "MJ", "RT", "NA"}, 
            new int[]{5, 3, 2, 7, 5}
        )); // "TCMA"

        System.out.println(sol.solution(
            new String[]{"TR", "RT", "TR"}, 
            new int[]{7, 1, 3}
        )); // "RCJA"
    }
    
}
