public class Solution {
    public int cutRope(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int timesOf3 = target / 3;
        if(target - timesOf3 * 3 == 1){
            timesOf3 -= 1;
        }
        int timesOf2 = (target - 3 * timesOf3) / 2;
        return (int)(Math.pow(2,timesOf2) * Math.pow(3,timesOf3));
    }
}

public class Solution {
    public int cutRope(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int[] k = new int[target + 1];
        k[0] = 0;
        k[1] = 1;
        k[2] = 2;
        k[3] = 3;
        int max = Integer.MIN_VALUE;
        for(int i = 4; i <= target; i++){
            max = 0;
            for(int j = 1; j <= i/2; j++){
                int tmp = k[j] * k[i-j];
                if(tmp > max){
                    max = tmp;
                }
            }
            k[i] = max;
        }
        return k[target];
    }
}