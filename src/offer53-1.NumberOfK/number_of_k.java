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

//_____second
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int ind1 = findLeftIndex(array, 0, array.length-1, k);
        if(ind1 == -1){
            return 0;
        }
        int ind2 = findRightIndex(array, 0, array.length-1, k);
        return ind2 - ind1 + 1;
    }
    private int findLeftIndex(int[] arr, int l, int r, int k){
        while(l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid] < k){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        if(arr[l] == k){
            return l;
        }
        return -1;
    }
    private int findRightIndex(int[] arr, int l, int r, int k){
        while(l < r){
            int mid = l + (r - l + 1) / 2;
            if(arr[mid] > k){
                r = mid - 1;
            }else{
                l = mid;
            }
        }
        return l;
    }
}