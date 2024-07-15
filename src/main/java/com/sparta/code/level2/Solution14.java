package com.sparta.code.level2;

import java.util.*;

class Solution14 {
    
    public static void main(String[] args) {
        String today = "2024.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> resultArr = new ArrayList<>();

        int todayDate = convertDateToNumber(today);

        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            String termType = st.nextToken();
            int termDuration = Integer.parseInt(st.nextToken());
            termMap.put(termType, termDuration);
        }

        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i], " ");
            String privacyDateStr = st.nextToken();
            String termType = st.nextToken();

            int privacyDate = convertDateToNumber(privacyDateStr);
            int termDuration = termMap.get(termType);

            int expirationDate = addMonthsToDate(privacyDate, termDuration);

            if (todayDate >= expirationDate) {
                resultArr.add(i + 1);
            }
        }

        return resultArr.stream().mapToInt(Integer::intValue).toArray();
        
    }

    // 날짜를 YYYYMMDD 형식의 숫자로 변환
    private static int convertDateToNumber(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return year * 10000 + month * 100 + day;
    }

    // 날짜에 개월 수를 더하는 함수
    private static int addMonthsToDate(int date, int monthsToAdd) {
        int year = date / 10000;
        int month = (date % 10000) / 100;
        int day = date % 100;

        month += monthsToAdd;
        while (month > 12) {
            month -= 12;
            year += 1;
        }

        return year * 10000 + month * 100 + day;
            
    }
    
}
