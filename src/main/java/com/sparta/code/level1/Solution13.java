class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int result = gcd(Math.max(n, m), Math.min(n, m)); 
        
        answer[0] = result;
        answer[1] = n * m / result;
        
        return answer;
    }
    
    public int gcd(int m, int n) {
        if (m % n == 0) return n;
        return gcd(n, m % n);
    }
}
