class Solution {
public:
    bool g_InvalidInput = false;
    double Power(double base, int exponent) {
        g_InvalidInput = false;
        if(equal(base, 0.0) && exponent < 0){
            g_InvalidInput = true;
            return 0.0;
        }
        unsigned int absExponent = (unsigned int)(exponent);
        if (exponent < 0)
            absExponent = (unsigned int)(-exponent);
        double res = getPower(base, absExponent);
        if (exponent < 0)
            res = 1.0 / res;
        return res;
    }
    bool equal(double num1, double num2){
        if(num1-num2 > -0.000001 && num1-num2 < 0.000001)
            return true;
        return false;
    }
    double getPower(double base, unsigned int exponent){
        double res = 1.0;
        for(int i = 0; i < exponent; i++){
            res *= base;
        }
        return res;
    }
};
// 自己的优化
class Solution {
public:
    bool g_InvalidInput = false;
    double Power(double base, int exponent) {
        g_InvalidInput = false;
        if (equal(base, 0.0) && exponent < 0){
            g_InvalidInput = true;
            return 0.0;
        }
        unsigned int absExponent = (unsigned int)(exponent);
        if (exponent < 0)
            absExponent = (unsigned int)(-exponent);
        double res = getPower(base, absExponent);
        if (exponent < 0)
            res = 1.0 / res;
        return res;
    }
    bool equal(double num1, double num2){
        if (num1-num2 > -0.000001 && num1-num2 < 0.000001)
            return true;
        return false;
    }
    double getPower(double base, unsigned int exponent){
        double res = 1.0;
        if (exponent == 0)
            return 1.0;
        else if (exponent == 1){
            return base;
        }
        else if (exponent % 2 == 0){
            res = getPower(base, exponent>>1);
            res = res * res;
        }
        else if (exponent % 2 == 1){
            res = getPower(base, exponent/2);
            res *= res;
            res *= base;
        }
        return res;
    }
};

//学习书上的优化
class Solution {
public:
    bool g_InvalidInput = false;
    double Power(double base, int exponent) {
        g_InvalidInput = false;
        if (equal(base, 0.0) && exponent < 0){
            g_InvalidInput = true;
            return 0.0;
        }
        unsigned int absExponent = (unsigned int)(exponent);
        if (exponent < 0)
            absExponent = (unsigned int)(-exponent);
        double res = getPower(base, absExponent);
        if (exponent < 0)
            res = 1.0 / res;
        return res;
    }
    bool equal(double num1, double num2){
        if (num1-num2 > -0.000001 && num1-num2 < 0.000001)
            return true;
        return false;
    }
    double getPower(double base, unsigned int exponent){
        if (exponent == 0)
            return 1.0;
        else if (exponent == 1){
            return base;
        }
        double res = getPower(base, exponent>>1);
        res *= res;
        if(exponent & 0x1 == 1)
            res *= base;
        return res;
    }
};