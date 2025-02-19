package com.sparta.code.level2;

import java.util.*;

public class Solution167 {
    
    public int[] solution(int rows, int columns, int[][] queries) {
        // rows x columns 크기의 행렬 초기화: 1부터 rows*columns까지 채움.
        int[][] matrix = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        int qCount = queries.length;
        int[] answer = new int[qCount];
        
        // 각 회전(query)을 순서대로 처리
        for (int q = 0; q < qCount; q++) {
            // 쿼리 값은 [x1, y1, x2, y2]로 주어지며, 1-indexed이므로 0-indexed로 변환
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;
            
            int temp = matrix[x1][y1];  // 시작 위치의 값을 저장
            int minVal = temp;          // 회전 과정에서 최솟값 추적
            
            // 왼쪽 열 - 위에서 아래로 당겼던 값을 위로 끌어올림
            for (int i = x1; i < x2; i++) {
                matrix[i][y1] = matrix[i+1][y1];
                minVal = Math.min(minVal, matrix[i][y1]);
            }
            
            // 하단 행 - 왼쪽에서 오른쪽으로 당겼던 값을 왼쪽으로 당김
            for (int j = y1; j < y2; j++) {
                matrix[x2][j] = matrix[x2][j+1];
                minVal = Math.min(minVal, matrix[x2][j]);
            }
            
            // 오른쪽 열 - 아래에서 위로 당겼던 값을 아래로 끌어내림
            for (int i = x2; i > x1; i--) {
                matrix[i][y2] = matrix[i-1][y2];
                minVal = Math.min(minVal, matrix[i][y2]);
            }
            
            //  상단 행 - 오른쪽에서 왼쪽으로 당겼던 값을 오른쪽으로 당김
            for (int j = y2; j > y1 + 1; j--) {
                matrix[x1][j] = matrix[x1][j-1];
                minVal = Math.min(minVal, matrix[x1][j]);
            }
            
            // 맨 처음 저장해두었던 값(temp)을 채워넣음
            matrix[x1][y1+1] = temp;
            
            // 이번 회전에서 이동한 숫자들 중 최솟값을 결과 배열에 저장
            answer[q] = minVal;
        }
        
        return answer;
    }
    
    // 테스트를 위한 메서드
    public static void main(String[] args) {
        Solution167 sol = new Solution167();
        
        int rows = 6;
        int columns = 6;
        int[][] queries = { 
            {2, 2, 5, 4}, 
            {3, 3, 6, 6}, 
            {5, 1, 6, 3} 
        };
        System.out.println(Arrays.toString(sol.solution(rows, columns, queries)));
        // 예상 출력: [8, 10, 25]
    }
    
}
