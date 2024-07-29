package com.sparta.code.level2;

import java.util.*;

class Solution {
    private char[][] map;
    private boolean[][] visited;
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};

    // 현재 위치에서 이동 가능한 위치를 찾는 메서드
    private Pos getPos(int direction, Pos current) {
        int x = current.x, y = current.y;
        int moveX = dx[direction];
        int moveY = dy[direction];

        // 이동 가능한 위치까지 이동
        while (x + moveX >= 0 && x + moveX < map.length 
              && y + moveY >= 0 && y + moveY < map[0].length
              && map[x + moveX][y + moveY] != 'D') 
        {
            x += moveX;
            y += moveY;
        }

        return new Pos(x, y, current.level + 1);
    }

    // 최단 거리 찾기
    private int bfs(Pos start, Pos goal) {
        Queue<Pos> queue = new LinkedList<>();
        visited[start.x][start.y] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            if (current.x == goal.x && current.y == goal.y) {
                return current.level;
            }

            for (int i = 0; i < 4; i++) {
                Pos next = getPos(i, current);
                if (!visited[next.x][next.y]) {
                    visited[next.x][next.y] = true;
                    queue.add(next);
                }
            }
        }

        return -1; // 목표의 도달할 수 없는 경우
    }

    public int solution(String[] board) {
        map = new char[board.length][board[0].length()];
        visited = new boolean[map.length][map[0].length];
        Pos start = null, goal = null;

        // 맵 초기화 및 지점 찾기
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    start = new Pos(i, j, 0);
                }
                if (map[i][j] == 'G') {
                    goal = new Pos(i, j, 0);
                }
            }
        }

        return bfs(start, goal);
    }
    
}

class Pos {
    int x;
    int y;
    int level;
    
    Pos(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
    
}
