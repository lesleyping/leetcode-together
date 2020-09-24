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