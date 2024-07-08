class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            if (func(skill, tree)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean func(String skill, String tree) {
        int skillIndex = 0;
        
        for (char c : tree.toCharArray()) {
            int indexInSkill = skill.indexOf(c);
            if (indexInSkill == -1) continue;
            if (indexInSkill == skillIndex) {
                skillIndex++;
            } else if (indexInSkill > skillIndex) {
                return false;
            }
        }        
        return true;
    }
}