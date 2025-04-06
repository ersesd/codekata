package com.sparta.code.level1;

import java.util.*;

public class Solution77 {
    
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String s1, String s2) {
                char c1 = s1.charAt(n);
                char c2 = s2.charAt(n);
                if (c1 == c2) {
                    return s1.compareTo(s2);
                }
                return c1 - c2;
            }
        });
        return strings;
    }
    
}
