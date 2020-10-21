//=======first
//1
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 0 || input.length == 0 || k > input.length) {
            return res;
        }
        int start = 0, end = input.length-1;
        int index = partition(input, start, end);
        k = k-1;
        while(index != k){
            if(index < k){
                start = index + 1;
                index = partition(input, start, end);
            }else{
                end = index - 1;
                index = partition(input, start, end);
            }
        }
        
        for(int i = 0 ; i <= index; i++){
            res.add(input[i]);
        }
        return res;
    }
    private int partition(int[] arr, int low, int high){
        int i = low, j = high+1;
        int tmp = low;
        while(true){
            while(++i < high && arr[i] < arr[tmp]);
            while(--j > low && arr[j] > arr[tmp]);
            if(i >= j){
                break;
            }
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
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || k <= 0 || input.length < k){
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return (b - a); // 大顶堆
            }
        });
        for(int i = 0; i < input.length; i++){
            if(pq.size() < k){
                pq.offer(input[i]);
            }else{
                int tmp = pq.peek();
                if(input[i] < tmp){
                    pq.poll();
                    pq.add(input[i]);
                }
            }
        }
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
}


//==========second
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || input.length == 0 || input.length < k || k == 0){
            return res;
        }
        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);
        while(index != k-1){
            if(index < (k-1)){
                start = index + 1;
                index = partition(input, start, end);
            }else{
                end = index - 1;
                index = partition(input, start, end);
            }
        }
        for(int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }
    public int partition(int[] arr, int l, int r){
        int less = l-1, more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]){
                swap(arr, --more, l);
            }else{
                l++;
            }
        }
        swap(arr, l, r);
        return l;
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

