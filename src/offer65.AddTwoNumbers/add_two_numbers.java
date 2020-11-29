//1
class Solution {
    public int add(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1; // 进位
            a ^= b; //非进位
            b = c;
        }
        return a;
    }
}
public class Solution {
    public int Add(int num1,int num2) {
        do{
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return num1;
    }
}