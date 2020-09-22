//1
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length <= 0){
            return 0;
        }
        int index = partition(array, 0, array.length - 1);
        int middle = array.length / 2;
        int start = 0;
        int end = array.length - 1;
        while(index != middle){
            if(index < middle){
                start = index + 1;
                index = partition(array, start, end);
            }else{
                end = index - 1;
                index = partition(array, start, end);
            }
        }
        int res = array[middle];
        boolean moreThanHalf = checkMoreThanHalf(array, res);
        return moreThanHalf ? res : 0;
    }
    private boolean checkMoreThanHalf(int[] arr, int num){
        int times = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                times++;
            }
        }
        if(times * 2 <= arr.length){
            return false;
        }
        return true;
    }
    private int partition(int[] arr, int low, int high){
        /*if(low == high){
            return low;
        }*/
        int tmp = low;
        int i = low, j = high+1;
        while(true){
            while(++i < high && arr[i] < arr[tmp]);
            while(--j > low && arr[j] > arr[tmp]);
            if(i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, tmp, j);
        return j;
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
//2
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int target = array[0];
        int votes = 1;
        for(int i = 1; i < array.length; i++){
            if(votes == 0){
                target = array[i];
                votes = 1;
            }else if(array[i] == target){
                votes++;
            }else{
                votes--;
            }
        }
        boolean flag = moreThanHalf(array, target);
        return flag ? target : 0;
    }
    private boolean moreThanHalf(int[] arr, int target){
        int times = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                times++;
            }
        }
        if(2 * times <= arr.length){
            return false;
        }
        return true;
    }
}