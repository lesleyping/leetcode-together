#include <iostream>
#include <stdlib.h>

using namespace std;

//time out
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            int flag = 0;
            for (int j = i + 1; j < s.length(); ++j)
            {
                if(flag == 1) continue;
                if(isunique(s, i, j)) ans = max(ans, j - i + 1);
                else
                {
                    flag = 1;
                    continue;
                }
            }
        }
        if(s.length() && ans == 0) ans = 1;
        return ans;
    }
    bool isunique(string s, int start, int end)
    {
        int j = end;
        for(int i = start; i < end; ++i)
        {
            if(s[i] == s[j])
            {
                return false;
            }
        }
        
        return true;
    }
};

class Solution2{
public:
    int lengthOfLongestSubstring2(string s){
        int left = 0;
        int right = 1;
        int maxlen = 0;
        while(right < s.length())
        {
            for(int i = left; i < right; ++i)
            {
                if(s[right] == s[i])
                {
                    
                    left = i + 1;
                    break;
                }
                
                //cout << left << right << maxlen << endl;
            }
            maxlen = max(maxlen, right - left + 1);
            ++right;
        }
        if(s.length() && maxlen == 0) maxlen = 1;
        return maxlen;
    }
};
int main()
{
    string s = "bbbbbb";
    int res = 0;
    Solution2 A;
    res = A.lengthOfLongestSubstring2(s);
    cout << res << endl;
    return 0;
}