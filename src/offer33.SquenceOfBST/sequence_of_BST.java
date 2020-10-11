//1
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return VerifyCore(sequence, 0, sequence.length - 1);
    }
    private boolean VerifyCore(int[] sequence, int l, int r){
        if(l > r){
            return false;
        }
        int root = sequence[r];
        int i;
        for(i = 0; i < r; i++){
            if(sequence[i] > root){
                break;
            }
        }
        for(int j = i; j < r; j++){
            if(sequence[j] < root){
                return false;
            }
        }
        boolean left = true;
        if(i-1 > l){
            left = VerifyCore(sequence, l, i-1);
        }
        boolean right = true;
        if(r-1 > i){
            right = VerifyCore(sequence, i, r-1);
        }
        return left && right;
    }
}
//2
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        int len = sequence.length;
        while((--len) > 0){
            int i = 0;
            while(sequence[i] < sequence[len]){
                i++;
            }
            while(sequence[i] > sequence[len]){
                i++;
            }
            if(i < len){
                return false;
            }
        }
        return true;
    }
}