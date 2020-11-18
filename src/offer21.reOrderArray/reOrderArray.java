//稳定-插入排序？
public class Solution {
    public void reOrderArray(int [] array) {
        int len = array.length;
        for(int i = 1; i < len; i++){
            int tmp = array[i];
            if(array[i] % 2 != 0){
                int j;
                for(j = i-1; j >= 0 && (array[j] % 2 == 0); j--){
                    array[j+1] = array[j];
                }
                array[j+1] = tmp;
            }
        }
    }
}
//lc-不稳定-双指针
class Solution {
    public int[] exchange(int[] nums) {
        int ll = 0, rr = nums.length - 1;
        while(ll < rr){
            while((nums[ll] % 2 != 0) && ll < rr){
                ll++;
            }
            while((nums[rr] % 2 == 0) && ll < rr){
                rr--;
            }
            int tmp = nums[ll];
            nums[ll] = nums[rr];
            nums[rr] = tmp;
        }
        return nums;
    }
}
