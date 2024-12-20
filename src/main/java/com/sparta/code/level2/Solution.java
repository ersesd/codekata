package com.sparta.code.level2;

import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<int[]> points = new ArrayList<>();

        // 모든 직선의 조합에서 교점을 찾음
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long C = line[i][2];
                long D = line[j][0];
                long E = line[j][1];
                long F = line[j][2];

                long denominator = A * E - B * D;
                if (denominator == 0) continue; // 평행하거나 일치하는 경우

                // 교점 계산
                long xNumerator = B * F - C * E;
                long yNumerator = C * D - A * F;

                if (xNumerator % denominator == 0 && yNumerator % denominator == 0) {
                    int x = (int) (xNumerator / denominator);
                    int y = (int) (yNumerator / denominator);
                    points.add(new int[]{x, y});
                }
            }
        }

        // 교점이 없는 경우
        if (points.isEmpty()) {
            return new String[]{};
        }

        // 최소 및 최대 x, y값 찾기
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            minY = Math.min(minY, point[1]);
            maxY = Math.max(maxY, point[1]);
        }

        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        char[][] grid = new char[height][width];

        // 격자판 초기화
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        // 별 찍기
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            grid[maxY - y][x - minX] = '*';
        }

        // 문자열로 변환
        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new int[][]{
            {2, -1, 4},
            {-2, -1, 4},
            {0, -1, 1},
            {5, -8, -12},
            {5, 8, 12}
        })));

        System.out.println(Arrays.toString(sol.solution(new int[][]{
            {0, 1, -1},
            {1, 0, -1},
            {1, 0, 1}
        })));

        System.out.println(Arrays.toString(sol.solution(new int[][]{
            {1, -1, 0},
            {2, -1, 0}
        })));

        System.out.println(Arrays.toString(sol.solution(new int[][]{
            {1, -1, 0},
            {2, -1, 0},
            {4, -1, 0}
        })));
    }
}
