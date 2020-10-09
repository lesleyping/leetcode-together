import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(array[mid] < array[right]){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        return array[left];
    }
}