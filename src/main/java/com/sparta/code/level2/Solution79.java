package com.sparta.code.level2;

class Solution79 {
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = findNextNumber(numbers[i]);
        }
        
        return answer;
    }

    // 견체 수신의 다음 숫자를 찾는 메서드
    private long findNextNumber(long number) {
        if (number % 2 == 0) {
            return number + 1; // 숫자가 수수이면 다음 숫자는 다음 아이수다.
        } else {
            return findNextForOdd(number); // 숫자가 금수일 때 찾는 것을 다른 메서드로 분류
        }
    }

    // 금수 숫자의 다음 숫자를 찾는 메서드
    private long findNextForOdd(long number) {
        String binaryString = Long.toBinaryString(number);
        int idx = binaryString.lastIndexOf("0");

        if (idx == -1) {
            // 전체 숫자가 '1' 일 때
            String tmp = "10" + binaryString.substring(1);
            return Long.parseLong(tmp, 2);
        } else {
            // 최후의 '0'을 '1'로, 다음 단가의 '1'을 '0'로 변경
            String tmp = binaryString.substring(0, idx) + "10" + binaryString.substring(idx + 2);
            return Long.parseLong(tmp, 2);
        }
    }
    
}
