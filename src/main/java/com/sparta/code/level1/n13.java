package com.sparta.code.level1;

public class n13 {
    public int solution(int n) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        if(n <= 100000000){
            while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
            
        }

        return answer;
    }
}