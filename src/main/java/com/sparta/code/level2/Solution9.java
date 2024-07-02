package com.sparta.code.level2;

import java.util.Arrays;
import java.util.StringTokenizer;

class Solution9 {
    
    private static String[][] parkGrid;

    public static void main(String[] args) {
        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }

    public static int[] solution(String[] park, String[] routes) {
        initializeParkGrid(park);
        int[] startPosition = findStartPosition();
        int[] finalPosition = followRoutes(startPosition, routes);

        return finalPosition;
    }

    private static void initializeParkGrid(String[] park) {
        int rows = park.length;
        int cols = park[0].length();
        parkGrid = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            parkGrid[i] = park[i].split("");
        }
    }

    private static int[] findStartPosition() {
        int[] startPosition = new int[2];
        for (int i = 0; i < parkGrid.length; i++) {
            for (int j = 0; j < parkGrid[i].length; j++) {
                if (parkGrid[i][j].equals("S")) {
                    startPosition[0] = i;
                    startPosition[1] = j;
                    return startPosition;
                }
            }
        }
        return startPosition;
    }

    private static int[] followRoutes(int[] position, String[] routes) {
        int x = position[0];
        int y = position[1];

        for (String route : routes) {
            StringTokenizer st = new StringTokenizer(route);
            String direction = st.nextToken();
            int steps = Integer.parseInt(st.nextToken());

            switch (direction) {
                case "E":
                    y = moveEast(x, y, steps);
                    break;
                case "W":
                    y = moveWest(x, y, steps);
                    break;
                case "S":
                    x = moveSouth(x, y, steps);
                    break;
                case "N":
                    x = moveNorth(x, y, steps);
                    break;
            }
        }

        return new int[]{x, y};
    }

    private static int moveEast(int x, int y, int steps) {
        for (int j = y + 1; j <= y + steps; j++) {
            if (j >= parkGrid[x].length || parkGrid[x][j].equals("X")) {
                return y;
            }
        }
        return y + steps;
    }

    private static int moveWest(int x, int y, int steps) {
        for (int j = y - 1; j >= y - steps; j--) {
            if (j < 0 || parkGrid[x][j].equals("X")) {
                return y;
            }
        }
        return y - steps;
    }

    private static int moveSouth(int x, int y, int steps) {
        for (int i = x + 1; i <= x + steps; i++) {
            if (i >= parkGrid.length || parkGrid[i][y].equals("X")) {
                return x;
            }
        }
        return x + steps;
    }

    private static int moveNorth(int x, int y, int steps) {
        
        for (int i = x - 1; i >= x - steps; i--) {
            if (i < 0 || parkGrid[i][y].equals("X")) {
                return x;
            }
        }
        
        return x - steps;
        
    }
    
}