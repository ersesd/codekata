import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 연속된 인형들이 제거된 횟수.
        int answer = 0;
        // 인형을 담을 stack
        Stack<Integer> stack = new Stack<>();       
        
        // 크레인의 총 이동횟수.
        for(int i = 0; i < moves.length; i++){
            // 보드의 행을 탐색
            for(int j = 0; j < board.length; j++){
                //moves의 크레인위치 열에 해당하는 값에 인형이 있다면
                if(board[j][moves[i]-1] != 0 ) {                   
                    if(!stack.empty() && stack.peek() == board[j][moves[i]-1]){
                        // 인형을 제거하는 횟수++
                        answer++;
                        // 인형을 제거
                        stack.pop();
                        // 크레인으로 뽑은 인형을 없앰
                        board[j][moves[i]-1] = 0;
                        break;
                    //나머지에는 인형을 바구니에 담은 후 0으로 없앰    
                    } else {
                        stack.push(board[j][moves[i]-1]);                      
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                }                        
            }
        }
        
       
        //없앤 인형의 수는 인형을 없앤 수 * 2이다.
        return answer * 2;
    }
}