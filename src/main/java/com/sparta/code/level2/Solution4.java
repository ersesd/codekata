import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> deploymentCounts = new ArrayList<>();
        int daysUntilDeployment = 0;
        int deployCount = 0;

        for (int i = 0; i < progresses.length; i++) {
            int daysRequired = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if (daysRequired > daysUntilDeployment) {

                if (deployCount > 0) {
                    deploymentCounts.add(deployCount);
                }
                daysUntilDeployment = daysRequired;
                deployCount = 1;
            } else {

                deployCount++;
            }
        }


        deploymentCounts.add(deployCount);

    
        int[] answer = new int[deploymentCounts.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deploymentCounts.get(i);
        }

        return answer;
    }
}