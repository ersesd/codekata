package com.sparta.code.level2;

import java.util.HashSet;
import java.util.Set;

class Solution76 {
    
    private final Set<Integer> primeSet = new HashSet<>();

    public int solution(String numbers) {
        // 모든 가능한 숫자 조합 찾기
        boolean[] visited = new boolean[numbers.length()];
        generateCombinations(numbers, "", visited);
        
        // 소수 개수 카운트
        int count = 0;
        for (int num : primeSet) {
            if (isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }

    private void generateCombinations(String numbers, String current, boolean[] visited) {
        if (!current.isEmpty()) {
            primeSet.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateCombinations(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
