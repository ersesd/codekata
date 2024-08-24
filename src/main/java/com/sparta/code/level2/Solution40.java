package com.sparta.code.level2;

import java.util.LinkedHashSet;

class Solution40 {
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedHashSet<String> cache = new LinkedHashSet<>(cacheSize);

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toUpperCase();

            if (cache.contains(city)) {
                cache.remove(city); // 기존 항목을 삭제 후 추가
                cache.add(city);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) { // 캐시가 꽉 차 있으면
                    cache.iterator().next(); // 가장 오래된 항목을 제거
                    cache.remove(cache.iterator().next());
                }
                cache.add(city);
                answer += 5;
            }
        }

        return answer;
    }
    
}
