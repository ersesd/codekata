public class Solution5 {
    public int solution(String s) {
        // 문자열의 최종적인 수
        int answer = 0;
        
        // 문자열의 두 가지를 플러스 마이너스 하는 총합 입니다.
        int balance = 0;
        
        // 첫 글자를 읽습니다.
        char currentChar = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 새로운 부분 문자열의 시작인 경우, 현재 문자를 설정하고 balance 변수를 1 증가시킵니다.
            if (balance == 0) {
                currentChar = c;
                balance = 1;
            } else {
                // 현재 문자가 일치하는 경우 balance 변수를 증가시키고 그렇지 않으면 감소시킵니다.
                if (c == currentChar) {
                    balance++;
                } else {
                    balance--;
                }
            }
            
            // balance변수기 0에 도달하면 문자열을 분리 합니다.
            if (balance == 0) {
                answer++;
            }
        }
        
        // 만약 문자열의 끝에 도달한 경우 마지막으로 분리합니다.
        if (balance > 0) {
            answer++;
        }
        
        // 문자열의 총 개수를 반환합니다.
        return answer;
    }
}