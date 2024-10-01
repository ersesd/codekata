package com.sparta.code.level2;

import java.util.Arrays;

public class Solution63 {
    
    public static void main(String[] args) {
        System.out.println(solution(new int[] {6, 10, 2}));
        System.out.println(solution(new int[] {0, 0, 0}));
    }

    public static String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        return String.join("", strNumbers);
    }
    
}
