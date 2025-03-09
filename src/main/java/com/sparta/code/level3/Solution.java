package com.sparta.code.level3;

import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int n = points.length;  // 포인트 개수
        int x = routes.length;  // 로봇 개수

        // 포인트 번호 → (r, c) 매핑
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pointMap.put(i + 1, points[i]);  // 포인트 번호는 1부터 시작
        }

        // 각 로봇의 이동 경로 저장
        List<List<int[]>> robotPaths = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            robotPaths.add(getRobotPath(pointMap, routes[i]));
        }

        // 충돌 위험 체크
        return countCollisions(robotPaths);
    }

    // 주어진 경로에 따라 최단 경로 이동을 계산하는 함수
    private List<int[]> getRobotPath(Map<Integer, int[]> pointMap, int[] route) {
        List<int[]> path = new ArrayList<>();

        for (int i = 0; i < route.length - 1; i++) {
            int[] start = pointMap.get(route[i]);
            int[] end = pointMap.get(route[i + 1]);

            int r1 = start[0], c1 = start[1];
            int r2 = end[0], c2 = end[1];

            while (r1 != r2 || c1 != c2) {
                path.add(new int[]{r1, c1});
                if (r1 != r2) r1 += (r1 < r2 ? 1 : -1);  // r 우선 이동
                else if (c1 != c2) c1 += (c1 < c2 ? 1 : -1);  // c 이동
            }
        }
        path.add(pointMap.get(route[route.length - 1])); // 마지막 도착점 추가
        return path;
    }

    private int countCollisions(List<List<int[]>> robotPaths) {
        Map<String, Integer> positionCount = new HashMap<>();
        int collisionCount = 0;
        int maxTime = robotPaths.stream().mapToInt(List::size).max().orElse(0);

        for (int t = 0; t < maxTime; t++) {
            positionCount.clear();
            
            for (List<int[]> path : robotPaths) {
                if (t < path.size()) {
                    int[] pos = path.get(t);
                    String key = pos[0] + "," + pos[1];

                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                }
            }

            for (int count : positionCount.values()) {
                if (count > 1) {
                    collisionCount += (count * (count - 1)) / 2;  // 기존 count - 1 수정
                }
            }
        }
        return collisionCount;
    }

}
