package com.sparta.code.level2;

class Solution75 {
    
    public int solution(String[] board) {
        int success = 1, fail = 0;
        
        char[][] realBoard = new char[board.length][board.length];

        int cnt_o = 0, cnt_x = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                char c = board[i].charAt(j);
                if(c == 'O')        cnt_o++;
                else if(c == 'X')   cnt_x++;
                realBoard[i][j] = c;
            }
        }
        
        if(cnt_x > cnt_o || cnt_o-cnt_x > 1)    return fail;
        boolean vic_o = isBingo(realBoard, 'O');
        boolean vic_x = isBingo(realBoard, 'X');
        
        if(vic_o && vic_x)          return fail;
        if(vic_o && cnt_o != cnt_x + 1) return fail;
        if(vic_x && cnt_x != cnt_o) return fail; 
        
        return success;
    }
    
    public boolean isBingo(char[][] realBoard, char target){
        return isLineBingo(realBoard, target) || isDiagonalBingo(realBoard, target);
    }
    
    private boolean isLineBingo(char[][] board, char target) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == target && board[i][1] == target && board[i][2] == target) {
                return true;
            }
            if (board[0][i] == target && board[1][i] == target && board[2][i] == target) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalBingo(char[][] board, char target) {
        if (board[0][0] == target && board[1][1] == target && board[2][2] == target) {
            return true;
        }
        return board[0][2] == target && board[1][1] == target && board[2][0] == target;
    }
    
}
