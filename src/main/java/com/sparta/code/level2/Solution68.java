package com.sparta.code.level2;

import java.util.*;

class Solution68 {
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];

        int totalPick = dia + iron + stone;

        int n = minerals.length;

        int[][] mineralGroup = new int[totalPick][6];

        for (int i = 0; i < Math.min(totalPick * 5, n); i += 5) {
            int sum = 0; 
            int damage = 0; 

            for (int j = i; j < Math.min(i + 5, n); j++) {
                switch (minerals[j]) {
                    case "diamond":
                        damage = 25; // 다이아몬드
                        break;
                    case "iron":
                        damage = 5; // 철
                        break;
                    case "stone":
                        damage = 1; // 돌
                        break;
                }

                sum += damage; // 총 피해도
                mineralGroup[i / 5][j % 5 + 1] = damage; // 그룹의 광물 피해
            }

            mineralGroup[i / 5][0] = sum; // 그룹의 총 피해도
        }

        // 내림차순 정렬
        Arrays.sort(mineralGroup, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0]; // 피로도가 큰 순서로 정렬
            }
        });

        // 광물의 피로도 계산
        for (int i = 0; i < totalPick; i++) {
            int[] temp = mineralGroup[i]; // 현재 그룹의 정보
            String pick = ""; // 사용할 픽 종류

            // 현재 사용할 픽 결정
            if (dia > 0) {
                dia -= 1;
                pick = "diamond"; // 다이아몬드
            } else if (iron > 0) {
                iron -= 1;
                pick = "iron"; // 철
            } else if (stone > 0) {
                stone -= 1;
                pick = "stone"; // 돌
            }

            // 광물별 피로도 계산 
            for (int j = 1; j < 6; j++) {
                switch (pick) {
                    case "diamond":
                        answer += (int) Math.ceil(temp[j] / 25.0);
                        break;
                    case "iron":
                        answer += (int) Math.ceil(temp[j] / 5.0);
                        break;
                    case "stone":
                        answer += temp[j];
                        break;
                }
            }
        }

        return answer;
    }
    
}
