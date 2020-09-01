/*
早期写的c++版本
*/
class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m == 0) return 0;
        for(int i = 0; i <= n - m; i++){
            int j = 0;
            for(j = 0; j < m; j++){
                if(needle[j] != haystack[i+j])
                    break;
            }
            if(j == m) return i;
        }
        return -1;
    }
};
//暴力解法

//2.dp

class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m == 0) return 0;
        int dp[m][256] = {0};
        dp[0][needle[0]] = 1;
        int X = 0;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < 256; j++){
                dp[i][j] = dp[X][j];
            }
            dp[i][needle[i]] = i+1;
            X = dp[X][needle[i]];
        }
        int s;
        for(int i = 0; i < n; i++){
            s = dp[s][haystack[i]];
            if(s == m) return i-m+1;
        }
        
        return -1;
    }
};


//3.传统KMP算法


class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m == 0) return 0;
        int next[m];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < m-1){
            if(j == -1 || needle[i] == needle[j]){
                ++i;
                ++j;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
        i = 0;
        j = 0;
        while(i < n && j < m){
            if(j == -1 || needle[j] == haystack[i]){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if(j == m) return i - j;
        return -1;
    }
};

/*
Java版本
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m-n; i++){
            if (haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        int[] next = new int[n];
        next[0] = -1;
        //get next
        int i = 0;
        int j = -1;
        while (i < n-1){
            if (j == -1 || needle.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
        //match
        i = 0;
        j = 0;
        while(i < m && j < n){
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if (j == n){
            return i-j;
        }
        return -1;
    }
}