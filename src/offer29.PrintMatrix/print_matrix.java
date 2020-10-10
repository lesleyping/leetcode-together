import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null){
            return res;
        }
        int t = 0, b = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;
        while(true){
            for(int i = l; i <= r; i++){
                res.add(matrix[t][i]);
            }
            if(++t > b) break;
            
            for(int i = t; i <= b; i++){
                res.add(matrix[i][r]);
            }
            if(--r < l) break;
            
            for(int i = r; i >= l; i--){
                res.add(matrix[b][i]);
            }
            if(--b < t) break;
            
            for(int i = b; i >= t; i--){
                res.add(matrix[i][l]);
            }
            if(++l > r) break;
        }
        return res;
    }
}