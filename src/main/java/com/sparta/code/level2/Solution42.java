package com.sparta.code.level2;

import java.util.*;

class Solution42
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        // 배열 A와 B를 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}