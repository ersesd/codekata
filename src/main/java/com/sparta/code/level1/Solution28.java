package com.sparta.code.level1;

class Solution28 {
    
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] strArr = s.split("");
        int idx = 0;
        
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(" ")) {
                idx = 0;  // 공백 이후는 새로운 단어로 간주하므로 idx를 0으로 초기화
            } else {
                answer.append(idx % 2 == 0 ? strArr[i].toUpperCase() : strArr[i].toLowerCase());
                idx++;
            }
            answer.append(strArr[i].equals(" ") ? " " : "");
        }
        
        return answer.toString();
    }
    
}
