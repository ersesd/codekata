package com.sparta.code.level2;

class Solution17 {
    
    public int solution(int[] numbers, int target) {  
        return dfs(0, numbers, target, 0);  
    }  
  
    private int dfs(int depth, int[] numbers, int target, int sum) {  
        if (depth == numbers.length) {  
            return sum == target ? 1 : 0;  
        }  
        return dfs(depth + 1, numbers, target, sum + numbers[depth])  
             + dfs(depth + 1, numbers, target, sum - numbers[depth]);  
    }  
    
}
