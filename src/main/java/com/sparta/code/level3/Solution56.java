package com.sparta.code.level3;

import java.util.*;

class Solution56 {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 이름을 인덱스와 매핑하기 위한 HashMap
        Map<String, Integer> nameIndexMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            nameIndexMap.put(enroll[i], i);
        }

        // 이익 배열
        int[] profits = new int[enroll.length];

        for (int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int profit = amount[i] * 100; // 판매 수익 계산

            while (!currentSeller.equals("-") && profit > 0) {
                int sellerIndex = nameIndexMap.get(currentSeller);
                int toParent = profit / 10; // 10%는 추천인에게
                profits[sellerIndex] += profit - toParent; // 나머지는 본인이 가짐

                profit = toParent; // 부모로 전송
                currentSeller = referral[sellerIndex]; // 추천인으로 이동
            }
        }

        return profits;
    }

    public static void main(String[] args) {
        Solution56 sol = new Solution56();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(sol.solution(enroll, referral, seller, amount)));
    }
    
}
