package com.sparta.code.level2;

import java.util.Arrays;

class Solution30 {
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int min_index = 0; 
        int max_index = people.length - 1; 
        
        while (max_index >= min_index) {
            if (people[max_index] + people[min_index] <= limit) {
                min_index++;
            }
            max_index--;
            answer++;
        }
        
        return answer;
    }
    
}
