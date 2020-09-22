import java.util.ArrayList;
import java.util.*;
public class Solution {
    ArrayList<String> res = new ArrayList<>();
    char[] arr;
    public ArrayList<String> Permutation(String str) {
        arr = str.toCharArray();
        if(str == null || str.length() == 0){
            return res;
        }
        
        dfs(0);
        Collections.sort(res);
        return res;
    }
    private void dfs(int index){
        if(index == arr.length - 1){
            res.add(new String(arr));
        }
        Set<Character> set = new HashSet<>();
        for(int i = index; i < arr.length; i++){
            if(set.contains(arr[i])){
                continue;
            }
            set.add(arr[i]);
            swap(i,index);
            dfs(index+1);
            swap(i,index);
        }
    }
    private void swap(int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}