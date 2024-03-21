import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 배열을 내림차순으로 정렬한다.
        Arrays.sort(citations);
        int n = citations.length;
        int answer = 0;
        
        // 배열을 반복문으로 처리한다.
        for (int i = 0; i < n; i++) {
            // 현재 인용 횟수보다 더 많은 논문의 수를 계산한다.
            // 현재 citation과 배열 끝에서부터의 위치 중 최솟값을 사용한다.
            int h = Math.min(citations[i], n - i); // 현재 인용 수와 끝에서의 위치 중 최솟값
            
            // 현재 h가 저장된 답보다 크면 업데이트한다.
            if (h > answer) {
                answer = h;
            }
        }
        
        return answer;
    }
}