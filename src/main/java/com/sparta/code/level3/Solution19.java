package com.sparta.code.level3;

class Solution19 {
    
    public int solution(int n, int[][] results) {
        // 그래프 초기화: 0 = 관계 없음, 1 = 승리, -1 = 패배
        int[][] graph = new int[n + 1][n + 1];

        // results 데이터를 그래프에 기록
        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            graph[win][lose] = 1;  // win이 lose를 이김
            graph[lose][win] = -1; // lose가 win에게 짐
        }

        // 승리/패배 관계 추론
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1; // i가 k를 이기고, k가 j를 이기면 i가 j를 이김
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1; // i가 k에게 지고, k가 j에게 지면 i가 j에게 짐
                    }
                }
            }
        }

        // 순위를 매길 수 있는 선수의 수 계산
        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean known = true;
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] == 0) { // 승패 관계가 확실하지 않은 경우
                    known = false;
                    break;
                }
            }
            if (known) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution19 sol = new Solution19();
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(sol.solution(n, results)); // 출력: 2
    }
    
}
