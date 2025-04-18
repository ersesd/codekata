package com.sparta.code.level2;

class Solution111 {
    
    public String solution(String new_id) {
        // 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();

        // 알파뱃, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // .가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        new_id = new_id.replaceAll("\\.+", ".");

        // .가 처음이나 끝에 위치한다면 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        // 빈 문자열이라면, "a"를 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", ""); // 끝에 위치한 마침표 제거
        }

        // 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }

    public static void main(String[] args) {
        Solution132 sol = new Solution132();

        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm")); // "bat.y.abcdefghi"
        System.out.println(sol.solution("z-+.^.")); // "z--"
        System.out.println(sol.solution("=.=")); // "aaa"
        System.out.println(sol.solution("123_.def")); // "123_.def"
        System.out.println(sol.solution("abcdefghijklmn.p")); // "abcdefghijklmn"
    }
    
}
