package com.sparta.code.level2;

import java.util.HashSet;

public class Solution {
    
    public static int solution(String dirs) {
        HashSet<String> visited = new HashSet<>();
        int curX = 0, curY = 0;

        for (char direction : dirs.toCharArray()) {
            int newX = curX, newY = curY;

            switch (direction) {
                case 'L': newX--; break;
                case 'R': newX++; break;
                case 'U': newY++; break;
                case 'D': newY--; break;
            }

            if (newX < -5 || newX > 5 || newY < -5 || newY > 5) continue;

            String moveForward = curX + "," + curY + "->" + newX + "," + newY;
            String moveBackward = newX + "," + newY + "->" + curX + "," + curY;

            if (!visited.contains(moveForward) && !visited.contains(moveBackward)) {
                visited.add(moveForward);
            }

            curX = newX;
            curY = newY;
        }

        return visited.size();
    }
    
}
