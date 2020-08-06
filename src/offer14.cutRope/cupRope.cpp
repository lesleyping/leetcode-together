class Solution1 {
public:
    int cutRope(int number) {
        if(number <= 2)
            return number;
        if(number == 3)
            return 2;
        int* res = new int[number+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;
        int max = 0;
        for(int i = 4; i <= number; i++){
            max = 0;
            for(int j = 1; j <= i/2; j++){
                int tmp = res[j] * res[i-j];
                if(tmp > max)
                    max = tmp;
            }
            res[i] = max;
        }
        return res[number];
    }
};

class Solution2 {
public:
    int cutRope(int number) {
        if(number < 2)
            return 0;
        if(number == 2)
            return 1;
        if(number == 3)
            return 2;
        int timesOf3 = number/3;
        if(number - timesOf3 * 3 == 1){
            timesOf3 -= 1;
        }
        int timesOf2 = (number - timesOf3*3)/2;
        return (int)(pow(3,timesOf3)) * (int)(pow(2,timesOf2));
    }
};