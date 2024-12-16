package com.sparta.code.level2;

class Solution86 {

    public int solution(String name) {
        int totalMoves = 0; // 위/아래 이동 횟수
        int length = name.length();
        int minMove = length - 1; // 최악의 경우: 오른쪽으로만 이동
        
        for (int i = 0; i < length; i++) {
            // 위/아래 이동 계산
            char currentChar = name.charAt(i);
            totalMoves += Math.min(currentChar - 'A', 'Z' - currentChar + 1);
            
            // 연속된 A를 처리하기 위한 좌/우 이동 최적화
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            
            // 현재 위치에서 다음 문자로 이동하는 비용 계산
            int moveCost = i + length - nextIndex + Math.min(i, length - nextIndex);
            minMove = Math.min(minMove, moveCost);
        }
        
        return totalMoves + minMove;
    }
    
}
