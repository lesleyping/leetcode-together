public class Solution {
    public int RectCover(int target) {
        int p = 1;
        int q = 2;
        if(target <= 2){
            return target;
        }
        for(int i = 3; i <= target; i++){
            q += p;
            p = q - p;
        }
        return q;
    }
}