package com.sparta.code.level3;

import java.util.*;

class Solution51 {
    
    static class Node {
        int x, y, cost, direction;

        Node(int x, int y, int cost, int direction) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        for (int[][] row : cost) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }

        int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dy = {0, 0, -1, 1};

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, -1));

        for (int i = 0; i < 4; i++) {
            cost[0][0][i] = 0;
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int newCost = current.cost + 100;

                if (current.direction != -1 && current.direction != i) {
                    newCost += 500; // 코너 비용 추가
                }

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0) {
                    if (newCost < cost[nx][ny][i]) {
                        cost[nx][ny][i] = newCost;
                        queue.add(new Node(nx, ny, newCost, i));
                    }
                }
            }
        }

        return Arrays.stream(cost[n - 1][n - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        Solution51 sol = new Solution51();

        int[][] board1 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println(sol.solution(board1)); // 900

        int[][] board2 = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(sol.solution(board2)); // 3800

        int[][] board3 = {
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 1, 0, 1},
            {1, 0, 0, 0}
        };
        System.out.println(sol.solution(board3)); // 2100
    }
    
}
