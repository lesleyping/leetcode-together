import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = array.length-1;
        while(left < right){
            if(array[left] + array[right] == sum){
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }else if(array[left] + array[right] > sum){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}