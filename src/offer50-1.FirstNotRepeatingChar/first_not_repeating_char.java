public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        int[] arr = new int[58];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'A'] += 1;
        }
        for(int i = 0; i < str.length(); i++){
            if(arr[str.charAt(i) - 'A'] == 1){
                return i;
            }
        }
        return -1;
    }
}

//--------second
//hashmap效率没有数组高
import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = str.length();
        for(int i = 0; i < len; i++){
            if(map.containsKey(str.charAt(i) - 'a')){
                map.put(str.charAt(i) - 'a', -1);
            }else{
                map.put(str.charAt(i) - 'a', i);
            }
        }
        for(int i = 0; i < len; i++){
            if(map.get(str.charAt(i) - 'a') != -1){
                return i;
            }
        }
        return -1;
    }
}