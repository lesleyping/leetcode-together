public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0){
            return false;
        }
        int r = array.length;
        int c = array[0].length;
        int i = 0, j = c - 1;
        while(i < r && j >= 0){
            if(array[i][j] == target){
                return true;
            } else if(array[i][j] > target){
                j--;
            } else{
                i++;
            }
        }
        return false;
    }
}