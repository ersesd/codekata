package com.sparta.code.level3;

class Solution21 {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength = toSeconds(video_len);
        int currentPosition = toSeconds(pos);
        int openingStart = toSeconds(op_start);
        int openingEnd = toSeconds(op_end);

        if (openingStart <= currentPosition && currentPosition <= openingEnd) {
            currentPosition = openingEnd;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                currentPosition = Math.max(0, currentPosition - 10);
            } else if (command.equals("next")) {
                currentPosition = Math.min(videoLength, currentPosition + 10);
            }
            
            if (openingStart <= currentPosition && currentPosition <= openingEnd) {
                currentPosition = openingEnd;
            }
        }

        return toTimeFormat(currentPosition);
    }

    private int toSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    // Convert seconds back to "mm:ss"
    private String toTimeFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    
}
