//动态规划
//倒着递推
//按最后一位为./*/regular，分为三种情况
/**
f[0][0] = true;
f[n][0] = false;
f[0][n]需要计算

*:
    看*：
        匹配 / 不匹配但为.
    不看*：
        或｜运算
!*:
    .
    匹配
 */
public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        int lenStr = str.length, lenPatt = pattern.length;
        boolean[][] arr = new boolean[lenStr+1][lenPatt+1];
        for(int i = 0; i <= lenStr; i++){
            for(int j = 0; j <= lenPatt; j++){
                if(j == 0){
                    arr[i][j] = i == 0;   //妙！！！！！！
                }else{
                    if(pattern[j-1] == '*'){
                        if(i >= 1 && j >= 2 && (pattern[j-2] == str[i-1] || pattern[j-2] == '.')){
                            arr[i][j] = arr[i-1][j];
                        }
                        if(j >= 2){
                            arr[i][j] |= arr[i][j-2];
                        }
                    }else{
                        if(i >= 1 && (pattern[j-1] == '.' || str[i-1] == pattern[j-1])){
                            arr[i][j] = arr[i-1][j-1];
                        }
                    }
                }
            }
        }
        return arr[lenStr][lenPatt];
    }
}

//递归
//边界条件很烦
public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        return matchCore(str, pattern, 0, 0);
    }
    private boolean matchCore(char[] str, char[] pattern, int i, int j){
        if(i == str.length && j == pattern.length){
            return true;
        }
        if(str.length != i && pattern.length == j){
            return false;
        }
        if(j+1 < pattern.length && pattern[j+1] == '*'){
            if(i < str.length && (pattern[j] == str[i] || pattern[j] == '.')){
                return matchCore(str, pattern, i+1, j+2) || 
                    matchCore(str, pattern, i+1, j) ||
                    matchCore(str, pattern, i, j+2);
            }else{
                return matchCore(str, pattern, i, j+2);
            }
        }
        if(i < str.length && (pattern[j] == str[i] || pattern[j] == '.')){
            return matchCore(str, pattern, i+1, j+1);
        }

        return false;
    }
}