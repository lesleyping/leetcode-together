class Solution {
public:
    int jumpFloorII(int number) {
        int f=1, fn=1;
        for(int i = 2; i <= number; i++){
            fn = 2 * f;
            f = fn;
        }
        return fn;
    }
};