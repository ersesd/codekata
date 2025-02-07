package com.sparta.code.level3;

public class Solution61 {
    
    // 할인율 후보 (10%, 20%, 30%, 40%)
    private static final int[] DISCOUNT_RATES = {10, 20, 30, 40};
    
    // 전역 변수: 최적의 이모티콘 플러스 가입자 수와 판매액
    private int maxPlusSubscribers = 0;
    private int maxSales = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int m = emoticons.length;
        // 각 이모티콘에 적용할 할인율을 담을 배열 (길이 m)
        int[] discountAssignment = new int[m];
        // DFS를 통해 모든 할인율 조합 탐색
        dfs(0, discountAssignment, users, emoticons);
        return new int[]{maxPlusSubscribers, maxSales};
    }
    
    // idx: 현재 이모티콘 인덱스, discountAssignment: 각 이모티콘별 할인율 할당
    private void dfs(int idx, int[] discountAssignment, int[][] users, int[] emoticons) {
        if (idx == emoticons.length) {
            evaluate(discountAssignment, users, emoticons);
            return;
        }
        
        // 가능한 할인율(10,20,30,40)을 각각 할당하고 다음 이모티콘으로 진행
        for (int discount : DISCOUNT_RATES) {
            discountAssignment[idx] = discount;
            dfs(idx + 1, discountAssignment, users, emoticons);
        }
    }
    
    // 현재 할인율 할당(discountAssignment)에 따른 사용자 평가
    private void evaluate(int[] discountAssignment, int[][] users, int[] emoticons) {
        int plusSubscribers = 0;
        int sales = 0;
        
        // 각 사용자에 대해 구매액 계산
        for (int[] user : users) {
            int userDiscountThreshold = user[0];   // 사용자가 구매하는 최소 할인율
            int spendingThreshold = user[1];         // 이 금액 이상이면 구매 취소 후 플러스 서비스 가입
            int totalCost = 0;
            
            // 모든 이모티콘에 대해 사용자가 구매 조건을 만족하면 할인 가격을 합산
            for (int i = 0; i < emoticons.length; i++) {
                if (discountAssignment[i] >= userDiscountThreshold) {
                    // 할인 적용 가격: 원가 * (100 - 할인율) / 100
                    totalCost += emoticons[i] * (100 - discountAssignment[i]) / 100;
                }
            }
            
            // 구매 총액이 사용자의 기준 이상이면 플러스 서비스 가입, 아니면 판매액에 합산
            if (totalCost >= spendingThreshold) {
                plusSubscribers++;
            } else {
                sales += totalCost;
            }
        }
        
        // 목표: 플러스 가입자 수 최대화, 그 후 판매액 최대화
        if (plusSubscribers > maxPlusSubscribers) {
            maxPlusSubscribers = plusSubscribers;
            maxSales = sales;
        } else if (plusSubscribers == maxPlusSubscribers && sales > maxSales) {
            maxSales = sales;
        }
    }
    
    // 테스트를 위한 main 메서드
    public static void main(String[] args) {
        Solution61 sol = new Solution61();
        
        int[][] users1 = { {40, 10000}, {25, 10000} };
        int[] emoticons1 = {7000, 9000};
        int[] result1 = sol.solution(users1, emoticons1);
        System.out.println("가입자: " + result1[0] + ", 판매액: " + result1[1]);  // 예상: [1, 5400]
        
        int[][] users2 = { {40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900} };
        int[] emoticons2 = {1300, 1500, 1600, 4900};
        int[] result2 = sol.solution(users2, emoticons2);
        System.out.println("가입자: " + result2[0] + ", 판매액: " + result2[1]);  // 예상: [4, 13860]
    }
    
}
