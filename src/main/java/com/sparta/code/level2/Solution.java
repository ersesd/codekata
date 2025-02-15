package com.sparta.code.level2;

import java.util.*;

public class Solution {
    
    public int[] solution(String msg) {
        // 초기 사전: A~Z, 인덱스 1~26
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        int dictIndex = 27;  // 새 단어 등록 시 부여할 색인 번호
        List<Integer> result = new ArrayList<>();
        int i = 0;
        
        while (i < msg.length()) {
            String w = "";
            int j = i;
            // 사전에 존재하는 가장 긴 문자열 w 찾기
            while (j < msg.length() && dict.containsKey(msg.substring(i, j + 1))) {
                w = msg.substring(i, j + 1);
                j++;
            }
            
            // w에 해당하는 사전 색인 번호 출력
            result.add(dict.get(w));
            
            // 아직 처리되지 않은 문자가 있다면, w에 이어지는 문자 c를 포함한 새로운 문자열 w+c를 사전에 등록
            if (j < msg.length()) {
                String newEntry = w + msg.charAt(j);
                dict.put(newEntry, dictIndex++);
            }
            
            // w의 길이만큼 포인터 이동
            i += w.length();
        }
        
        // 결과 리스트를 배열로 변환하여 반환
        int[] answer = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k);
        }
        return answer;
    }
    
    // 테스트용 메서드
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String msg1 = "KAKAO";
        System.out.println(Arrays.toString(sol.solution(msg1)));  
        // 예상 출력: [11, 1, 27, 15]
        
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(Arrays.toString(sol.solution(msg2)));  
        // 예상 출력: [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        
        String msg3 = "ABABABABABABABAB";
        System.out.println(Arrays.toString(sol.solution(msg3)));  
        // 예상 출력: [1, 2, 27, 29, 28, 31, 30]
    }
    
}
