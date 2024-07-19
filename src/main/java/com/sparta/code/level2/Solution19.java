package com.sparta.code.level2;

import java.util.*;

class Solution19 {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 필드 이름 배열
        String[] dataArr = {"code", "date", "maximum", "remain"};
        
        // 인덱스 찾기
        int extNum = getIndex(dataArr, ext);
        int sort_by_Num = getIndex(dataArr, sort_by);
        
        // 데이터를 저장을 위한 리스트
        List<int[]> dataList = new ArrayList<>();
        for (int[] row : data) {
            if (row[extNum] < val_ext) {
                dataList.add(row);
            }
        }
        
        // 데이터 정렬
        dataList.sort(Comparator.comparingInt(o -> o[sort_by_Num]));

        // 배열로 변환
        int[][] answer = new int[dataList.size()][dataArr.length];
        for (int i = 0; i < dataList.size(); i++) {
            answer[i] = dataList.get(i);
        }
        
        return answer;
    }

    private int getIndex(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        throw new IllegalArgumentException("잘못된 키 입니다.: " + key);
    }
    
}
