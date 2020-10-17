class Solution {
    public int mySqrt(int x) {
        long ll = 0;
        long rr = x/2+1;
        while(ll < rr){
            long mid = ll + (rr -ll + 1) / 2;
            long square = mid * mid;
            if(square > x){        //这种情况不是解
                rr = mid - 1;
            }else{
                ll = mid;
            }
        }
        return (int)ll;
    }
}