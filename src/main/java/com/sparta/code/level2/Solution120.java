package com.sparta.code.level2;

import java.util.*;

class Solution120 {
    
    public int solution(int N, int[][] road, int K) {
        // 그래프 초기화
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프에 도로 정보 추가
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        // 최소 거리 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; // 시작점 거리 0

        // 우선순위 큐 (다익스트라 알고리즘)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0}); // {현재 노드, 누적 거리}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int nowDist = current[1];

            if (nowDist > dist[now]) continue;

            for (int[] neighbor : graph.get(now)) {
                int next = neighbor[0];
                int cost = neighbor[1];

                if (dist[now] + cost < dist[next]) {
                    dist[next] = dist[now] + cost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        // K 이하 거리의 마을 개수 계산
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution120 sol = new Solution120();

        System.out.println(sol.solution(5, new int[][]{
            {1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));

        System.out.println(sol.solution(6, new int[][]{
            {1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }
    
}
