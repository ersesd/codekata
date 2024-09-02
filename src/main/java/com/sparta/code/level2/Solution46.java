package com.sparta.code.level2;

import java.util.*;

class Solution46 {
    HashSet<Integer> numbersSet = new HashSet<>();

    public int solution(String numbers) {
        generateCombinations("", numbers);

        int count = 0;
        for (int number : numbersSet) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void generateCombinations(String current, String remaining) {
        if (!current.equals("")) {
            numbersSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < remaining.length(); i++) {
            generateCombinations(current + remaining.charAt(i), 
                                 remaining.substring(0, i) + remaining.substring(i + 1));
        }
    }
}
