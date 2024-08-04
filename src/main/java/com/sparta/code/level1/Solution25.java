package com.sparta.code.level1;

class Solution25 {
    
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        // 각 숫자의 빈도수 계산
        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }

        StringBuilder answerBuilder = new StringBuilder();

        // 숫자를 9부터 0까지 확인하여 공통으로 존재하는 숫자를 추가
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(xCount[i], yCount[i]);
            while (count-- > 0) {
                answerBuilder.append(i);
            }
        }

        String answer = answerBuilder.toString();

        // 공통 숫자가 없는 경우
        if (answer.isEmpty()) {
            return "-1";
        }

        // 모든 숫자가 0인 경우
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
    
}
