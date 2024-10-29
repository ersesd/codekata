package com.sparta.code.level1;

class n22 {
    
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 지갑과 지폐의 크기를 정렬하여 항상 작은 값이 앞에 오도록 설정
        int walletWidth = Math.min(wallet[0], wallet[1]);
        int walletHeight = Math.max(wallet[0], wallet[1]);
        int billWidth = Math.min(bill[0], bill[1]);
        int billHeight = Math.max(bill[0], bill[1]);
        
        // 지갑에 지폐가 들어갈 수 있을 때까지 접기
        while (billWidth > walletWidth || billHeight > walletHeight) {
            if (billHeight > billWidth) {
                billHeight /= 2;
            } else {
                billWidth /= 2;
            }
            answer++;

            // 지폐를 90도 회전시켜서 지갑에 넣을 수 있는지 확인
            int temp = billWidth;
            billWidth = Math.min(billWidth, billHeight);
            billHeight = Math.max(temp, billHeight);
        }
        
        return answer;
    }
    
}
