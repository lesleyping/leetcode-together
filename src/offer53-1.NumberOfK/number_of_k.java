public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int leftIndex = getFirstNum(array, k);
        int rightIndex = getLastNum(array, k);
        if(leftIndex != -1 && rightIndex != -1){
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }
    private int getFirstNum(int[] arr, int target){
        int left = 0, right = arr.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] == target){
                right = mid;
            }else{
                right = mid - 1;
            }
        }
        if(arr[left] == target){
            return left;
        }
        return -1;
    }
    private int getLastNum(int[] arr, int target){
        int left = 0, right = arr.length-1;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] == target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        if(arr[left] == target){
            return left;
        }
        return -1;
    }
}