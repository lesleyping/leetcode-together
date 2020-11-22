//1
class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = str.length() - 2; i >= 0; i--){
            int c = (str.substring(i,i+2).compareTo("10") >= 0 
            && str.substring(i,i+2).compareTo("25") <= 0) ? a+b : a;

           b = a;
           a = c;
        }
        return a;
    }
}
//2
class Solution {
    public int translateNum(int num) {
        int a = 1, b = 1;
        int x, y = num % 10;
        while(num > 0){
            num /= 10;
            x = num % 10;
            int tmp = x * 10 + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}

//------third
class Solution {
    public int translateNum(int num) {
        int res = 0;
        res = dfs(String.valueOf(num), 0);
        return res;
    }
    private int dfs(String num, int idx) {
        if (idx == num.length()) {
            return 1;
        }
        if (num.charAt(idx) != '0' && (idx + 1) < num.length() && Integer.valueOf(num.substring(idx, idx + 2)) < 26) {
            return dfs(num, idx + 1) + dfs(num, idx + 2);
        } else {
            return dfs(num, idx + 1);
        }
    }
}