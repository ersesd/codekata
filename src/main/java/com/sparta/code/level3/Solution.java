package com.sparta.code.level3;

public class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 붕대 감기 시전 시간(연속 성공해야 하는 초 수)
        int x = bandage[1]; // 매초 회복량
        int y = bandage[2]; // t초 연속 성공 시 추가 회복량
        
        int maxHP = health;
        int currentHP = health;
        
        // 공격 정보는 공격 시간을 기준으로 오름차순 정렬되어 있음.
        // 시뮬레이션은 1초부터 마지막 공격 시간까지 진행합니다.
        int lastTime = attacks[attacks.length - 1][0];
        // 시간 1~lastTime까지 각 초에 발생하는 공격의 피해량을 기록할 배열
        int[] attackDamage = new int[lastTime + 1]; // 인덱스 0은 사용하지 않음.
        for (int i = 0; i < attacks.length; i++) {
            int time = attacks[i][0];
            int damage = attacks[i][1];
            attackDamage[time] = damage;
        }
        
        // 현재까지 연속으로 붕대 감기에 성공한 초 수
        int consecutive = 0;
        // 1초부터 마지막 공격 시간까지 초 단위로 시뮬레이션
        for (int time = 1; time <= lastTime; time++) {
            // 해당 초에 몬스터의 공격이 있다면: 공격 당한 순간은 회복하지 않고, 연속 성공 카운트 초기화
            if (attackDamage[time] > 0) {
                currentHP -= attackDamage[time];
                consecutive = 0;
                if (currentHP <= 0) {
                    return -1;
                }
            } else {
                // 공격이 없는 초는 붕대 감기로 체력을 회복합니다.
                // 회복 시 최대 체력을 넘지 않도록 합니다.
                currentHP = Math.min(maxHP, currentHP + x);
                consecutive++;
                // 만약 t초 연속 성공했다면 추가 회복 후 연속 성공 카운트 초기화
                if (consecutive == t) {
                    currentHP = Math.min(maxHP, currentHP + y);
                    consecutive = 0;
                }
            }
        }
        
        return currentHP;
    }
    
    // 테스트용 main 메서드 (실행하지 않아도 됩니다)
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] bandage1 = {5, 1, 5};
        int health1 = 30;
        int[][] attacks1 = { {2, 10}, {9, 15}, {10, 5}, {11, 5} };
        System.out.println(sol.solution(bandage1, health1, attacks1)); // 예상 결과: 5

        int[] bandage2 = {3, 2, 7};
        int health2 = 20;
        int[][] attacks2 = { {1, 15}, {5, 16}, {8, 6} };
        System.out.println(sol.solution(bandage2, health2, attacks2)); // 예상 결과: -1

        int[] bandage3 = {4, 2, 7};
        int health3 = 20;
        int[][] attacks3 = { {1, 15}, {5, 16}, {8, 6} };
        System.out.println(sol.solution(bandage3, health3, attacks3)); // 예상 결과: -1

        int[] bandage4 = {1, 1, 1};
        int health4 = 5;
        int[][] attacks4 = { {1, 2}, {3, 2} };
        System.out.println(sol.solution(bandage4, health4, attacks4)); // 예상 결과: 3
    }
    
}
