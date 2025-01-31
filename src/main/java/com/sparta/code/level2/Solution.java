package com.sparta.code.level2;

import java.util.*;

class Solution {
    
    private final List<Set<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int colCount = relation[0].length;
        int rowCount = relation.length;

        // 모든 컬럼의 부분 집합을 비트마스킹을 통해 생성 (1부터 2^colCount-1까지)
        for (int subset = 1; subset < (1 << colCount); subset++) {
            if (!isUnique(relation, subset)) continue; // 유일성을 만족하지 않으면 제외
            if (!isMinimal(subset)) continue; // 최소성을 만족하지 않으면 제외
            candidateKeys.add(convertToSet(subset));
        }

        return candidateKeys.size();
    }

    // 유일성(uniqueness) 체크: 해당 컬럼 조합이 중복 없이 유일한지 확인
    private boolean isUnique(String[][] relation, int subset) {
        Set<String> tuples = new HashSet<>();
        int rowCount = relation.length;
        int colCount = relation[0].length;

        for (int i = 0; i < rowCount; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < colCount; j++) {
                if ((subset & (1 << j)) != 0) { // 해당 컬럼이 포함되어 있으면 추가
                    key.append(relation[i][j]).append(",");
                }
            }
            if (!tuples.add(key.toString())) return false; // 중복 발생 시 유일성 X
        }
        return true;
    }

    // 최소성(minimality) 체크: 기존 후보키의 부분집합인지 확인
    private boolean isMinimal(int subset) {
        for (Set<Integer> key : candidateKeys) {
            int bitKey = convertToBitmask(key);
            if ((bitKey & subset) == bitKey) return false; // 부분집합이면 최소성 위배
        }
        return true;
    }

    // 비트마스크 → Set 변환
    private Set<Integer> convertToSet(int bitmask) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            if ((bitmask & (1 << i)) != 0) {
                set.add(i);
            }
        }
        return set;
    }

    // Set → 비트마스크 변환
    private int convertToBitmask(Set<Integer> set) {
        int bitmask = 0;
        for (int col : set) {
            bitmask |= (1 << col);
        }
        return bitmask;
    }

    // 실행 예제
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] relation = {
            {"100", "ryan", "music", "2"},
            {"200", "apeach", "math", "2"},
            {"300", "tube", "computer", "3"},
            {"400", "con", "computer", "4"},
            {"500", "muzi", "music", "3"},
            {"600", "apeach", "music", "2"}
        };
        System.out.println(sol.solution(relation)); // 출력: 2
    }
    
}
