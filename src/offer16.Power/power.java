//非递归
public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0){
            return 0;
        }
        double res = 1.0;
        for(int i = 0; i < Math.abs(exponent); i++){
            res *= base;
        }
        return exponent < 0 ? 1.0/res : res;
  }
}

//递归
public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0){
            return 0;
        }
        if(exponent < 0){
            return 1.0/getPower(base, -exponent);
        }
        return getPower(base, exponent);
  }
    private double getPower(double base, int exponent){
        if(exponent == 0){
            return 1.0;
        } else if(exponent == 1){
            return base;
        }
        double res = getPower(base, exponent>>1);
        res *= res;
        if((exponent & 1) != 0){
            res *= base;
        }
        return res;
    }
}