import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum < 3){
            return res;
        }
        int small = 1, big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while(small < middle){
            if(curSum == sum){
                ArrayList tmp = new ArrayList<Integer>();
                for(int t = small; t <= big; t++){
                    tmp.add(t);
                }
                res.add(tmp);
                curSum -= small;
                small++;
                big++;
                curSum += big;
            }else if(curSum < sum){
                big++;
                curSum += big;
            }else{
                curSum -= small;
                small++;
            }
        }
        return res;
    }
}
//--------second
import java.util.ArrayList;
public class Solution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int left = 1, right = 2;
        while(right <= (sum + 1) / 2){
            int curSum = getSum(left, right);
            if(curSum == sum){
                ArrayList<Integer> cur = new ArrayList<>();
                for(int i = left; i <= right; i++){
                    cur.add(i);
                }
                res.add(cur);
                left++;
            }else if(curSum < sum){
                right++;
            }else{
                left++;
            }
        }
        return res;
    }
    private int getSum(int left, int right){
        int res = (left + right) * (right - left + 1) / 2;
        return res;
    }
}