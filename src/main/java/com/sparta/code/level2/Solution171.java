package com.sparta.code.level2;

public class Solution171 {
    
    int maxDiff = 0;        // 현재까지의 최대 점수 차이
    int[] best;             // 최대 점수 차이일 때의 라이언 화살 분배

    public int[] solution(int n, int[] info) {
        best = new int[11];             // 초기 best: 모두 0
        int[] candidate = new int[11];  // DFS로 탐색할 후보 배열
        dfs(0, n, info, candidate);
        // 만약 라이언이 이길 방법이 없다면
        if (maxDiff == 0) {
            return new int[]{-1};
        }
        return best;
    }
    
    void dfs(int idx, int arrowsLeft, int[] info, int[] candidate) {
        // 마지막 점수대(0점, idx==10)에서는 남은 모든 화살을 할당
        if (idx == 10) {
            candidate[idx] = arrowsLeft;
            // 두 선수의 점수 계산
            int ryanScore = 0, apeachScore = 0;
            for (int i = 0; i < 11; i++) {
                int score = 10 - i;
                // 라이언이 해당 점수를 얻으려면 candidate[i] > info[i]
                if (candidate[i] > info[i]) {
                    ryanScore += score;
                } else if (info[i] > 0) {
                    apeachScore += score;
                }
            }
            int diff = ryanScore - apeachScore;
            if (diff > maxDiff) {
                maxDiff = diff;
                best = candidate.clone();
            } else if (diff == maxDiff) {
                // 같은 점수 차이면, 낮은 점수(배열의 뒤쪽 인덱스)부터 더 많이 맞힌 경우를 우선
                for (int i = 10; i >= 0; i--) {
                    if (candidate[i] > best[i]) {
                        best = candidate.clone();
                        break;
                    } else if (candidate[i] < best[i]) {
                        break;
                    }
                }
            }
            return;
        }
        
        // 현재 점수대 (score = 10-idx)를 라이언이 이기기 위해 필요한 화살 수
        int needed = info[idx] + 1;
        // 해당 점수를 따기 위해 필요한 화살을 사용 
        if (arrowsLeft >= needed) {
            candidate[idx] = needed;
            dfs(idx + 1, arrowsLeft - needed, info, candidate);
            candidate[idx] = 0; // 백트래킹
        }
        
        // 해당 점수를 포기하고 0발 사용
        candidate[idx] = 0;
        dfs(idx + 1, arrowsLeft, info, candidate);
    }
    
}
