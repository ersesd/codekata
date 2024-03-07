import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        // 세로 길이를 저장할 변수 n을 oard의 길이로 초기화
        int n = board.length;
        // 같은 색으로 색칠된 칸의 개수를 저장할 변수
        int count = 0;
        // 현재 위치에서 상,하,좌,우로 이동할 때의 세로 길이의 변화
        int[] dh = {0, 1, -1, 0}; 
        // 현재 위치에서 상,하,좌,우로 이동할 때의 가로 길이의 변화
        int[] dw = {1, 0, 0, -1};

        for(int i = 0; i < 4; i++) {
            //가로 위치 w_check와 세로 위치 h_check
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            
            //이동할 위치가 보드 내에서 어디에 위치하는지 확인
            //세로 위치 h_check와 가로 위치 w_check가 마이너스가 아니고 n보다 큰지 확인
            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < board[h_check].length) {
                // 현재 칸과 이동할 칸의 색상이 같은지 확인
                // 같으면 count++
                if(board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }
        //count를 반환
        return count;
    }
}
