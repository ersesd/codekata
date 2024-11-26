package com.sparta.code.level3;

class Solution10 {
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftPos = 10; // '*' 위치를 10으로 표현
        int rightPos = 12; // '#' 위치를 12로 표현
        
        for (int number : numbers) {
            if (number == 0) number = 11; // 숫자 0을 11로 표현
            
            if (number == 1 || number == 4 || number == 7) {
                answer.append('L');
                leftPos = number;
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append('R');
                rightPos = number;
            } else {
                int leftDistance = getDistance(leftPos, number);
                int rightDistance = getDistance(rightPos, number);
                
                if (leftDistance < rightDistance || (leftDistance == rightDistance && hand.equals("left"))) {
                    answer.append('L');
                    leftPos = number;
                } else {
                    answer.append('R');
                    rightPos = number;
                }
            }
        }
        
        return answer.toString();
    }

    private int getDistance(int from, int to) {
        int fromX = (from - 1) % 3;
        int fromY = (from - 1) / 3;
        int toX = (to - 1) % 3;
        int toY = (to - 1) / 3;
        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }
    
}
