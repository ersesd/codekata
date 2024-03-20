import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int rotation = 0; rotation < s.length(); rotation++) {
            stack.clear();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt((i + rotation) % s.length());
                
                if (c == '[' || c == '(' || c == '{') {
                    stack.push(c);
                }
                else {
                    if (stack.isEmpty()) {
                        break;
                    }
                    char top = stack.peek();
                    if ( (top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']') ) {
                        stack.pop();
                    }
                    else {
                        break;
                    }
                }
                
                if (i == s.length() - 1 && stack.isEmpty()) {
                    answer++;
                }
            }
        }
        return answer;
    }
}