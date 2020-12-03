/*
给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复元素且升序，而不用保证右部分是否有序
例如，arr = [1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9]，调整之后arr=[1, 2, 3, 4, 5, 6, 7, 8, 9, .....]。

[要求]

时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
*/

/*
- 快排的思路
[0,l]该范围内，满足题目要求的递增且不重复
[l+1, i]该范围内，满足递增但不满足不重复

i不断向后遍历，直至到达数组终点
*/
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