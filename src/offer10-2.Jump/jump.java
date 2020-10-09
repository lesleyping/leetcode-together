public class Solution {
    public int JumpFloor(int target) {
        int step1 = 1;
        int step2 = 2;
        if(target <= 2){
            return target;
        }
        for(int i = 3; i <= target; i++){
            step2 += step1;
            step1 = step2 - step1;
        }
        return step2;
    }
}