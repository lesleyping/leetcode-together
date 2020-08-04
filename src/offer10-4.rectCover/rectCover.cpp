class Solution {
public:
    int rectCover(int number) {
        if (number <= 2) return number;
        int p = 1;
        int q = 2;
        for(int i = 3; i <= number; i++){
            q = q + p;
            p = q - p;
        }
        return q;
    }
};