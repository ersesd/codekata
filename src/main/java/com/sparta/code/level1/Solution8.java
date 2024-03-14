import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int row = wallpaper.length;
        int column = wallpaper[0].length();
        
        int MaxLeft = column;
        int MaxRight = 0;
        int MaxTop = row;
        int MaxBottom = 0;
        
        for (int i = 0 ; i < row ; i++ ) { 
            for (int j = 0 ; j < column ; j++ ) { 
                
                char space = wallpaper[i].charAt(j);
                
                if (space == '#') {
                    //좌우를 비교한다.
                    if (j < MaxLeft) 
                        MaxLeft = j;
                    if (MaxRight < j)
                        MaxRight = j;
                    
                    //상하를 비교한다.
                    if(i < MaxTop)
                        MaxTop = i;
                    if(MaxBottom < i)
                        MaxBottom = i;
                }
            } 
        }
        
        int[] answer = {MaxTop, MaxLeft, MaxBottom + 1, MaxRight + 1};
        
        return answer;
    }
}