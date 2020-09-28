//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int res = 0;
        for(int num : array){
            res ^= num;
        }
        //把异或结果的最后一位1的那位找出来
        int h = 1;
        while((h & res) == 0){
            h <<= 1;
        }
        //也可以用res & (-res)
        for(int i = 0; i < array.length; i++){
            if((h & array[i]) == 0){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
}