package com.sparta.code.level3;

import java.util.*;

class Solution12 {
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int costValue = cost[2];
            
            if (findParent(parent, from) != findParent(parent, to)) {
                unionParent(parent, from, to);
                totalCost += costValue;
                edgesUsed++;
                if (edgesUsed == n - 1) break;
            }
        }
        
        return totalCost;
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent, parent[node]);
    }

    private void unionParent(int[] parent, int node1, int node2) {
        int root1 = findParent(parent, node1);
        int root2 = findParent(parent, node2);
        if (root1 < root2) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }
    }
    
}
