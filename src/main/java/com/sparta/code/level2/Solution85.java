package com.sparta.code.level2;

class Solution85 {
    
    public int solution(String name) {
        int totalMoves = 0;
        int length = name.length();
        int minLeftRightMoves = length - 1; // 최악의 경우: 오른쪽으로만 이동

        for (int i = 0; i < length; i++) {
            char currentChar = name.charAt(i);
            // 위/아래로 이동하는 최소 조작 횟수 계산
            totalMoves += Math.min(currentChar - 'A', 'Z' - currentChar + 1);

            // 연속된 A의 최대 길이를 계산하여 좌우 이동 최적화
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 현재 위치에서 앞/뒤로 돌아가는 이동 횟수 계산
            int movesToAvoidA = i + i + (length - nextIndex);
            minLeftRightMoves = Math.min(minLeftRightMoves, movesToAvoidA);
        }

        return totalMoves + minLeftRightMoves;
    }
    
}
