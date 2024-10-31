package com.sparta.code.level2;

import java.util.*;

class Solution80 {
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTimes = new HashMap<>();
        Map<String, String> inTimes = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];

            if (action.equals("IN")) {
                inTimes.put(carNumber, time);
            } else if (action.equals("OUT")) {
                String inTime = inTimes.remove(carNumber);
                int parkedMinutes = calculateMinutes(inTime, time);
                parkingTimes.put(carNumber, parkingTimes.getOrDefault(carNumber, 0) + parkedMinutes);
            }
        }

        // 23:59에 출차된 것으로 간주해야 하는 차량 처리
        for (Map.Entry<String, String> entry : inTimes.entrySet()) {
            String carNumber = entry.getKey();
            String inTime = entry.getValue();
            int parkedMinutes = calculateMinutes(inTime, "23:59");
            parkingTimes.put(carNumber, parkingTimes.getOrDefault(carNumber, 0) + parkedMinutes);
        }

        // 요금 계산
        List<String> carNumbers = new ArrayList<>(parkingTimes.keySet());
        Collections.sort(carNumbers);
        int[] result = new int[carNumbers.size()];
        
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int totalMinutes = parkingTimes.get(carNumber);
            result[i] = calculateFee(fees, totalMinutes);
        }
        
        return result;
    }

    private int calculateMinutes(String inTime, String outTime) {
        String[] inParts = inTime.split(":"), outParts = outTime.split(":");
        int inHours = Integer.parseInt(inParts[0]), inMinutes = Integer.parseInt(inParts[1]);
        int outHours = Integer.parseInt(outParts[0]), outMinutes = Integer.parseInt(outParts[1]);
        return (outHours * 60 + outMinutes) - (inHours * 60 + inMinutes);
    }

    private int calculateFee(int[] fees, int totalMinutes) {
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        if (totalMinutes <= baseTime) {
            return baseFee;
        } else {
            return baseFee + (int) Math.ceil((double) (totalMinutes - baseTime) / unitTime) * unitFee;
        }
    }
    
}
