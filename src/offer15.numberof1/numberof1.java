public class Solution {
    public int NumberOf1(int n) {
        int bit = 1;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((bit & n) != 0){
                count++;
            }
            bit <<= 1;
        }
        return count;
    }
}

public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){       //!! 不是大于0
            int n1 = n - 1;
            n = n1 & n;
            count++;
        }
        return count;
    }
}