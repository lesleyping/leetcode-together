import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] ss = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(ss[i]);
        }
        partition(arr);
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb.append(num).append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
    public static void partition(int[] arr){
        int l = 0, i = 1;
        //[0,l]是满足条件的数组
        //[l+1,i]是升序但不保证不同
        while(i < arr.length){
            if(arr[i] != arr[l]){
                swap(arr, ++l, i++);
            }else{
                i++;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}