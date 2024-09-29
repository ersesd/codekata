package com.sparta.code.level2;

class Solution61 {
    
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = findGCD(arrayA);
        int gcdB = findGCD(arrayB);
        int answer = 0;

        if (!isDivisible(arrayB, gcdA)) {
            answer = gcdA;
        }

        if (!isDivisible(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    private int findGCD(int[] array) {
        int gcdValue = array[0];
        for (int i = 1; i < array.length; i++) {
            gcdValue = gcd(array[i], gcdValue);
        }
        return gcdValue;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private boolean isDivisible(int[] array, int value) {
        for (int num : array) {
            if (num % value == 0) {
                return true;
            }
        }
        return false;
    }
    
}
