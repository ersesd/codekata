package com.sparta.code.level2;

import java.util.*;

class Solution103 {
    
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infoMap = new HashMap<>();

        // info 데이터 처리
        for (String i : info) {
            String[] parts = i.split(" ");
            String[] langs = {parts[0], "-"};
            String[] roles = {parts[1], "-"};
            String[] exps = {parts[2], "-"};
            String[] foods = {parts[3], "-"};
            int score = Integer.parseInt(parts[4]);

            for (String lang : langs) {
                for (String role : roles) {
                    for (String exp : exps) {
                        for (String food : foods) {
                            String key = lang + role + exp + food;
                            infoMap.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
                        }
                    }
                }
            }
        }

        // 점수 리스트 정렬
        for (List<Integer> scores : infoMap.values()) {
            Collections.sort(scores);
        }

        int[] result = new int[query.length];

        // query 처리
        for (int q = 0; q < query.length; q++) {
            String[] parts = query[q].replaceAll(" and ", "").split(" ");
            String key = parts[0];
            int targetScore = Integer.parseInt(parts[1]);

            if (!infoMap.containsKey(key)) {
                result[q] = 0;
                continue;
            }

            List<Integer> scores = infoMap.get(key);
            result[q] = binarySearch(scores, targetScore);
        }

        return result;
    }

    private int binarySearch(List<Integer> scores, int target) {
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return scores.size() - left;
    }

    public static void main(String[] args) {
        Solution103 sol = new Solution103();

        String[] info = {
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        };

        String[] query = {
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        };

        System.out.println(Arrays.toString(sol.solution(info, query))); // [1, 1, 1, 1, 2, 4]
    }
    
}
