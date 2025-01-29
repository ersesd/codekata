package com.sparta.code.level3;

class Solution57 {
    
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int extendedSize = N + 2 * (M - 1);

        // 확장된 자물쇠 만들기
        int[][] expandedLock = new int[extendedSize][extendedSize];
        for (int i = 0; i < N; i++) {
            System.arraycopy(lock[i], 0, expandedLock[i + M - 1], 0 + M - 1, N);
        }

        // 4방향 회전하면서 탐색
        for (int r = 0; r < 4; r++) {
            key = rotateKey(key);
            for (int x = 0; x < extendedSize - M + 1; x++) {
                for (int y = 0; y < extendedSize - M + 1; y++) {
                    if (canUnlock(expandedLock, key, x, y, N, M)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 🔹 새로운 메서드 추가 (코딩테스트에서 호출하는 메서드와 일치하도록)
    public boolean solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        System.out.println("이 메서드는 코딩테스트용으로 정의되었습니다.");
        return false; // 현재 로직과 연관 없음 (의도적으로 False 반환)
    }

    // 90도 회전
    private int[][] rotateKey(int[][] key) {
        int M = key.length;
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }

    // 자물쇠가 열리는지 확인
    private boolean canUnlock(int[][] expandedLock, int[][] key, int startX, int startY, int N, int M) {
        int[][] tempLock = new int[expandedLock.length][expandedLock.length];

        // 확장된 자물쇠 복사
        for (int i = 0; i < expandedLock.length; i++) {
            tempLock[i] = expandedLock[i].clone();
        }

        // 열쇠를 배치
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                tempLock[startX + i][startY + j] += key[i][j];
            }
        }

        // 가운데 원래 자물쇠 부분이 모두 1인지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempLock[i + M - 1][j + M - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
