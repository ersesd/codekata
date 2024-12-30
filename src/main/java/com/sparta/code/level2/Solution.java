package com.sparta.code.level2;

import java.util.*;

class Solution {

    public int[] checkDistancing(String[][] places) {
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            result[i] = isValid(places[i]) ? 1 : 0;
        }

        return result;
    }

    private boolean isValid(String[] place) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (place[row].charAt(col) == 'P' && !isSafe(place, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(String[] place, int row, int col) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isInBounds(newRow, newCol) && place[newRow].charAt(newCol) == 'P') {
                return false;
            }

            if (isInBounds(newRow, newCol) && place[newRow].charAt(newCol) == 'O') {
                for (int[] dir2 : directions) {
                    int nextRow = newRow + dir2[0];
                    int nextCol = newCol + dir2[1];

                    if (nextRow == row && nextCol == col) continue;

                    if (isInBounds(nextRow, nextCol) && place[nextRow].charAt(nextCol) == 'P') {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 수식 최대화 테스트 케이스
        System.out.println(sol.solution("100-200*300-500+20")); // 60420
        System.out.println(sol.solution("50*6-3*2")); // 300

        // 거리두기 확인 테스트 케이스
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        System.out.println(Arrays.toString(sol.checkDistancing(places))); // [1, 0, 1, 1, 1]
    }
}
