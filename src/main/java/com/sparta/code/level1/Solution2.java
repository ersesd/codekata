import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        //오름차 순으로 정렬        
        Arrays.sort(reserve);
        Arrays.sort(lost);
    
        // 여분의 체육복을 빌려줬는지 여부를 표시함
        boolean[] isLent = new boolean[reserve.length]; 
        
        //전체에서 체육복이 없는 학생의 수를 빼준다.
        answer = n - lost.length;
        
        // 여벌 체육복은 가져온 체육복이 도난된 학생을 계산한다.
        for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j] && !isLent[j]) {
					answer++;
					lost[i] = -1;
					isLent[j] = true;
                    break;
				}
			}
		}
        
        // if 조건식을 통해서 여분의 체육복을 가진 학생의 번호가 근처라면 전체학생수를 더하고 없앤다.
        for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if ((lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) && !isLent[j]) {
					answer++;
					isLent[j] = true;
					break;
				}
			}
		}
        
        return answer;
    }
}