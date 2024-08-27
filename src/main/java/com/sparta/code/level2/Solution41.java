package com.sparta.code.level2;

import java.util.Arrays;

class Solution41 {

    public String[] solution(String[] files) {
        Arrays.sort(files, (file1, file2) -> {
            // 각 파일명을 HEAD, NUMBER, TAIL로 분리
            String[] file1Parts = parseFile(file1);
            String[] file2Parts = parseFile(file2);

            // HEAD를 사전 순으로 비교
            int headComparison = file1Parts[0].compareToIgnoreCase(file2Parts[0]);
            if (headComparison != 0) {
                return headComparison;
            }

            // HEAD가 같으면 NUMBER를 숫자 순으로 비교
            int num1 = Integer.parseInt(file1Parts[1]);
            int num2 = Integer.parseInt(file2Parts[1]);
            if (num1 != num2) {
                return Integer.compare(num1, num2);
            }

            return 0;
        });

        return files;
    }

    private String[] parseFile(String file) {
        String head = "";
        String number = "";
        String tail = "";

        int i = 0;

        // HEAD 추출
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }

        // NUMBER 추출
        while (i < file.length() && Character.isDigit(file.charAt(i)) && number.length() < 5) {
            number += file.charAt(i);
            i++;
        }

        // TAIL 추출 (이후 부분은 다 TAIL)
        tail = file.substring(i);

        return new String[]{head, number, tail};
    }

}
    