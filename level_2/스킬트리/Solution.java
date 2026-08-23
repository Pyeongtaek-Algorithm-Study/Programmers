class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            
            if (isOrderRight(tree, skill)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isOrderRight(String tree, String skill) {
        
        int matchIdx = 0;
        
        for (char ch : tree.toCharArray()) {
                
                // 현재 스킬트리 순서와 맞을 경우
                if (skill.indexOf(ch) == matchIdx) {
                    matchIdx++;
                // 이전 스킬트리로 이미 배운 경우
                } else if (skill.indexOf(ch) < matchIdx) {
                    continue;
                // 순서 스킬트리를 따르지 못할 경우
                } else {
                    return false;
                }   
            }
        
        return true;
    }
}