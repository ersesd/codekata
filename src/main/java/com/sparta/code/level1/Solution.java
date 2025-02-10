package com.sparta.code.level1;

import java.util.*;

public class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sumSet = new HashSet<>();
        
        // 서로 다른 인덱스의 두 수를 뽑아 더한 결과를 집합에 저장
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]);
            }
        }
        
        // 집합을 리스트로 변환 후 오름차순 정렬
        List<Integer> sumList = new ArrayList<>(sumSet);
        Collections.sort(sumList);
        
        // 정렬된 리스트를 배열로 변환하여 반환
        int[] answer = new int[sumList.size()];
        for (int i = 0; i < sumList.size(); i++) {
            answer[i] = sumList.get(i);
        }
        
        return answer;
    }
    
}
