package com.sparta.code.level1;

import java.util.*;

public class Solution47 {
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            // commands[i] = [i, j, k] (1-indexed)
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            
            // 배열의 인덱스는 0부터 시작하므로 start-1부터 end까지 복사 (end는 exclusive)
            int[] subArray = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(subArray);
            answer[i] = subArray[k - 1]; // k번째 수는 (k-1) 인덱스에 위치
        }
        
        return answer;
    }
    
    // 테스트용 메서드
    public static void main(String[] args) {
        Solution47 sol = new Solution47();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
            {2, 5, 3},
            {4, 4, 1},
            {1, 7, 3}
        };
        System.out.println(Arrays.toString(sol.solution(array, commands)));
        // 예상 값 [5, 6, 3]
    }
    
}
