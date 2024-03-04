class Solution {
    public int solution(int n) {
        int answer = 1;
        boolean trust = true;
    while(trust){
        if(n % answer == 1){
            trust = false;
        } else {
            answer++;
        }
    }
        return answer;
    }
}