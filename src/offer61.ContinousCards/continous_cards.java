import java.util.*;
import java.lang.*;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        int[] isCurrent = new int[14];
        int zero_num = 0;
        int gap_num = 0;
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0){
                zero_num++;
            }else{
                if(isCurrent[numbers[i]] != 0){
                    return false;
                }
                isCurrent[numbers[i]] = 1;
                if(i != 0 && numbers[i-1] != 0){
                    gap_num += numbers[i] - numbers[i-1] - 1;
                }
            }
        }
        if(zero_num == 5 || zero_num < gap_num){
            return false;
        }
        return true;
    }
}
//-------second
import java.util.*;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        Arrays.sort(numbers);
        int zeroCnt = 0, gapCnt = 0;
        int[] list = new int[14];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0){
                zeroCnt++;
            }else{
                if(list[numbers[i]] != 0){
                    return false;
                }else{
                    list[numbers[i]] = 1;
                    if(i != 0 && numbers[i-1] != 0){
                        gapCnt += numbers[i] - numbers[i-1] - 1;
                    }
                }
            }
        }
        return gapCnt > zeroCnt ? false : true;
    }
}