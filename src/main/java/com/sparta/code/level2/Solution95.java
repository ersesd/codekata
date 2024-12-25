package com.sparta.code.level2;

class Solution95 {
    
    public long solution(int r1, int r2) {
        long count = 0;

        for (int x = 0; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt((long) r2 * r2 - (long) x * x));
            long minY = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));

            if (x < r1) {
                count += maxY - minY + 1;
            } else {
                count += maxY + 1;
            }
        }

        return count * 4 - (r2 - r1 + 1) * 4L;
    }

    public static void main(String[] args) {
        Solution95 sol = new Solution95();

        // 테스트 케이스
        System.out.println(sol.solution(2, 3)); // 20
        System.out.println(sol.solution(1, 5)); // 104
        System.out.println(sol.solution(3, 7)); // 216
    }
    
}
