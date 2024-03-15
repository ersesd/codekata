import java.util.*;

class Solution {
  public String[] solution(String[] players, String[] callings) {
    // players 배열의 각 플레이어와 그들의 인덱스를 맵핑함
    HashMap<String, Integer> playerIndices = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
      playerIndices.put(players[i], i);
    }

    for (String calling : callings) {
      if (playerIndices.containsKey(calling)) {
        int index = playerIndices.get(calling);
        if (index > 0) { // 첫 번째 요소가 아니라면 위치 교환
          // 플레이어와 바로 앞의 플레이어 위치 교환
          String temp = players[index - 1];
          players[index - 1] = calling;
          players[index] = temp;

          // 해시맵 업데이트 하기
          playerIndices.put(calling, index - 1);
          playerIndices.put(temp, index);
        }
      }
    }
    return players;
  }
}