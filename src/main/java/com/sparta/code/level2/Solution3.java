import java.util.*;

class Solution3 {
    public int solution(String[][] clothes) {
        int answer = 0;

        
        HashMap<String, Integer> map = new HashMap<>();
        String[] str = new String[clothes.length];

        // key에 value의 숫자 1을 넣음
        // key가 겹치면 value++
        for (int i = 0; i < clothes.length; i++) {
            str[i] = clothes[i][1];
            // 중복이 아니면 value에 1을 넣고
            if (map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);
            }
            // 중복이면 value + 1 을 해줌
            else if (map.get(clothes[i][1]) != null) {
                int x = map.get(clothes[i][1]);
                map.put(clothes[i][1], x+1);
            }
        }

        String[] str2 =  Arrays.stream(str).distinct().toArray(String[]::new);

        // value 값들을 더해주는 로직
        int value = 1;
        for (int i = 0; i < str2.length; i++) {
            value *= (map.get(str2[i])+1);
        }

        answer = value - 1;
        


        return answer;
    }
}