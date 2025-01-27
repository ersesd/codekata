package com.sparta.code.level3;

class Solution55 {
    
    public int solution(String s) {
        int minLength = s.length();

        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, len);
            int count = 1;

            for (int i = len; i < s.length(); i += len) {
                int endIdx = Math.min(i + len, s.length());
                String current = s.substring(i, endIdx);

                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }

    public static void main(String[] args) {
        Solution55 sol = new Solution55();
        System.out.println(sol.solution("aabbaccc")); // 7
        System.out.println(sol.solution("ababcdcdababcdcd")); // 9
        System.out.println(sol.solution("abcabcdede")); // 8
        System.out.println(sol.solution("abcabcabcabcdededededede")); // 14
        System.out.println(sol.solution("xababcdcdababcdcd")); // 17
    }
    
}
