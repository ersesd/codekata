package com.sparta.code.level2;

class Solution96 {

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1; // 최소 숙련도
        int right = 100_000; // 최대 숙련도
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canSolveAll(diffs, times, mid, limit)) {
                answer = mid; // 조건을 만족하므로 더 낮은 숙련도를 탐색
                right = mid - 1;
            } else {
                left = mid + 1; // 조건을 만족하지 않으면 더 높은 숙련도를 탐색
            }
        }

        return answer;
    }

    private boolean canSolveAll(int[] diffs, int[] times, int level, long limit) {
        long totalTime = 0; // 총 소요 시간
        long prevTime = 0; // 이전 퍼즐의 소요 시간

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            long timeCur = times[i];

            if (diff <= level) {
                totalTime += timeCur; // 숙련도가 충분하면 바로 해결
            } else {
                long failCount = diff - level; // 틀리는 횟수
                totalTime += failCount * (timeCur + prevTime) + timeCur; // 실패 횟수 반영
            }

            prevTime = timeCur;

            if (totalTime > limit) {
                return false; // 제한 시간 초과
            }
        }

        return totalTime <= limit;
    }

    public static void main(String[] args) {
        Solution96 sol = new Solution96();

        // 테스트 케이스
        System.out.println(sol.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30)); // 3
        System.out.println(sol.solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59)); // 2
        System.out.println(sol.solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723)); // 294
        System.out.println(sol.solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L)); // 39354
    }

}
