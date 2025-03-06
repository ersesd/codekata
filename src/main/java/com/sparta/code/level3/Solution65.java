package com.sparta.code.level3;

import java.util.*;

public class Solution65 {
    
    // 정렬된 제재 아이디 조합을 하나의 문자열로 표현하여 저장
    private static final Set<String> resultSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        resultSet.clear();
        boolean[] used = new boolean[user_id.length];
        dfs(0, banned_id, user_id, used, new ArrayList<>());
        return resultSet.size();
    }
    
    private void dfs(int idx, String[] banned, String[] users, boolean[] used, List<String> list) {
        if (idx == banned.length) {
            // 후보 조합은 순서에 상관없이 동일하면 같은 조합으로 처리해야 하므로, 정렬 후 문자열로 변환하여 저장
            List<String> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);
            String key = String.join(",", sortedList);
            resultSet.add(key);
            return;
        }
        
        // banned[idx]에 매칭되는 모든 user_id 후보를 탐색
        for (int i = 0; i < users.length; i++) {
            if (!used[i] && isMatch(users[i], banned[idx])) {
                used[i] = true;
                list.add(users[i]);
                dfs(idx + 1, banned, users, used, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
    
    private boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            char c1 = user.charAt(i);
            char c2 = banned.charAt(i);
            if (c2 == '*') continue;
            if (c1 != c2) return false;
        }
        return true;
    }
    
}
