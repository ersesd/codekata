package com.sparta.code.level2;

import java.util.LinkedList;
import java.util.Queue;

class Solution77 {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeightOnBridge = 0;
        int time = 0;
        int index = 0;

        // 다리의 길이만큼 큐를 초기화 (다리 위에 아무 트럭도 없음을 의미)
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (index < truck_weights.length) {
            time++;
            // 다리에서 트럭을 하나 내려서 무게를 갱신
            totalWeightOnBridge -= bridge.poll();

            // 다음 트럭이 다리 위에 올라갈 수 있는지 확인
            if (totalWeightOnBridge + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]);
                totalWeightOnBridge += truck_weights[index];
                index++;
            } else {
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        time += bridge_length;

        return time;
    }
    
}
