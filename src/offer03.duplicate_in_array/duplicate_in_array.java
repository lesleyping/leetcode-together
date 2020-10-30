//————————不修改数组
//hashmap
//空间复杂度高
//可以改为hashset！
//找第一个
import java.util.*;
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : numbers){
            if(map.containsKey(num)){
                duplication[0] = num;
                return true;
            }else{
                map.put(num, map.getOrDefault(num,0) + 1);
            }
        }
        return false;
    }
}

//二分查找
//找任意一个
//找不全，有的样例过不了
class Solution {
    public int findRepeatNumber(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int count = getCount(nums, start, mid);
            if(start == end){
                if(count > 1){
                    return start;
                }else{
                    break;
                }
            }
            if(count > (mid - start + 1)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    private int getCount(int[] nums, int start, int end){
        int count = 0;
        for(int num : nums){
            if(num >= start && num <= end){
                count++;
            }
        }
        return count;
    }
}

//——————————————修改数组
//原地修改数组的方法
//适合找任意一个，不是第一个
import java.util.*;
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        for(int i = 0; i < length; i++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }
    private void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}                                                                             

//还可以给数组排序
//然后遍历数组