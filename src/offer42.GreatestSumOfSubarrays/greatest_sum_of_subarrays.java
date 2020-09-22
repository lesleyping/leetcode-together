//1
import java.util.*;
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(curSum <= 0){
                curSum = array[i];
            }else{
                curSum += array[i];
            }
            if(curSum > greatestSum){
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }
}
//2
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            max = Math.max(max + array[i], array[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}