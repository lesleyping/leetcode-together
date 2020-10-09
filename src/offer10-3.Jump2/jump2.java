public class Solution {
    public int JumpFloorII(int target) {
        int t = 1;
        for(int i = 1; i < target; i++){
            t *= 2;
        }
        return t;
    }
}