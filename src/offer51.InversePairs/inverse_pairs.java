public class Solution {
    public int InversePairs(int [] array) {
        if(array == null){
            return 0;
        }
        int[] tmp = new int[array.length];
        return inverse_pairs(array, tmp, 0, array.length-1);
    }
    private int inverse_pairs(int[] arr, int[] tmp, int start, int end){
        if(start >= end){
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = inverse_pairs(arr, tmp, start, mid);
        left = left % 1000000007;
        int right = inverse_pairs(arr, tmp, mid+1, end);
        right = right % 1000000007;
        int merge = merge_pairs(arr, tmp, start, mid, end);
        merge = merge % 1000000007;
        return (left+right+merge) % 1000000007;
    }
    private int merge_pairs(int[] arr, int[] tmp, int low, int mid, int high){
        int i = mid, j = high;
        for(int t = low; t <= high; t++){
            tmp[t] = arr[t];
        }
        int count = 0;
        for(int k = high; k >= low; k--) {
            if(i < low){
                arr[k] = tmp[j--];
            }else if(j < mid + 1){
                arr[k] = tmp[i--];
            }else if(tmp[i] > tmp[j]){
                arr[k] = tmp[i--];
                count += j - mid;
                count = count % 1000000007;
            }else {
                arr[k] = tmp[j--];
            }
        }
        return count;
    }
}