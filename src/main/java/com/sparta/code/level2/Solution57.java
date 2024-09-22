package com.sparta.code.level2;

class Solution57 {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            String filteredSkillTree = skillTree.replaceAll("[^" + skill + "]", "");
            int skillIndex = 0; 

            boolean isValid = true;

            for (char c : filteredSkillTree.toCharArray()) {
                if (skillIndex >= skill.length() || c != skill.charAt(skillIndex)) {
                    isValid = false;
                    break;
                }
                skillIndex++; 
            }
            
            if (isValid) {
                answer++;
            }
        }
        
        return answer;
    }
    
}
