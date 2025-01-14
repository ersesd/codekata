package com.sparta.code.level3;

import java.util.*;

class Solution24 {
    
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // 그래프 생성
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        List<String> route = new ArrayList<>();
        dfs("ICN", graph, route);

        Collections.reverse(route);
        return route.toArray(new String[0]);
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> route) {
        PriorityQueue<String> destinations = graph.getOrDefault(airport, new PriorityQueue<>());

        while (!destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next, graph, route);
        }

        route.add(airport);
    }

    public static void main(String[] args) {
        Solution24 sol = new Solution24();

        String[][] tickets1 = {
            {"ICN", "JFK"},
            {"HND", "IAD"},
            {"JFK", "HND"}
        };

        String[][] tickets2 = {
            {"ICN", "SFO"},
            {"ICN", "ATL"},
            {"SFO", "ATL"},
            {"ATL", "ICN"},
            {"ATL", "SFO"}
        };

        System.out.println(Arrays.toString(sol.solution(tickets1))); // ["ICN", "JFK", "HND", "IAD"]
        System.out.println(Arrays.toString(sol.solution(tickets2))); // ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
    }
    
}
