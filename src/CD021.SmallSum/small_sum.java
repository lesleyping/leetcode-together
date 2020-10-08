import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        long res = getRes(arr);
        System.out.print(res);
    }
    private static long getRes(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        return sort(arr, 0, arr.length-1);
    }
    private static long sort(int[] arr, int left, int right){
        if(left >= right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        return sort(arr, left, mid) + sort(arr, mid+1, right) + merge(arr, left, mid, right);
    }
    private static long merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int i = left, j = mid+1;
        long sum = 0;
        int index = 0;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                sum += arr[i] * (right - j + 1);
                help[index++] = arr[i++];
            } else{
                help[index++] = arr[j++];
            }
        }
        if(i > mid){
            while(j <= right){
                help[index++] = arr[j++];
            }
        }else if(j > right){
            while(i <= mid){
                help[index++] = arr[i++];
            }
        }
        for(int t = 0; t < right-left+1; t++){
            arr[t+left] = help[t];
        }
        return sum;
    }
}