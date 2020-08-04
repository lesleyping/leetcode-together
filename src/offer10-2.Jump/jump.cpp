class Solution {
public:
    int jumpFloor(int number) {
        int p = 1;
        int q = 2;
        if (number <= 2){
            return number;
        }
        for(int i = 3; i <= number; i++){
            q = p + q;
            p = q - p;
        }
        return q;
    }
};