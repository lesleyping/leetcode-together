#include<stdlib.h>
#include<iostream>
#include<string>
using namespace std;

#define max(a,b) (((a) > (b)) ? (a) : (b))

class Solution {
public:
    string longestPalindrome(string s) {
        int times = 0;
        if(s.length() == 0)
        {
            return "";
        }
        int flag;
        int n = 0;
        int maxlen = 0;
        string maxstring = "";
        for(int i = 0; i < s.length()-1; i++)
        {
            flag = 0;
            n = i;
            while(isequal(s, n-flag, n+flag+1))
            {
                flag++;
                times++;
            }
            if(((flag * 2) > maxlen) && flag != 0)
            {
                maxlen = 2 * flag;
                maxstring = s.substr(n-flag+1, flag * 2);
            }
            flag = 0;
            while(isequal(s, n-flag-1, n+flag+1))
            {
                flag++;
                times++;
            }
            if(((flag * 2 + 1) > maxlen) && flag != 0)
            {
                maxlen = 2 * flag + 1;
                maxstring = s.substr(n-flag, flag * 2 + 1);
            }
        }
        if(maxstring.length() == 0)
            maxstring = s[0];
        cout << times << endl;
        return maxstring;
    }

    bool isequal(string s, int p, int q)
    {
        if(p >= 0 && q < s.length() && p < q && s[p] == s[q])
        {
            return true;
        }
        return false;
    }
};

class Solutiontwo {
public:
    string longestPalindrome2(string s)
    {
        int times = 0;
        if(s.length() == 0) return "";
        if(s.length() == 1) return s;
        int left = 0;
        int right = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int len1 = ExpandAroundCenter(s, i, i+1, times);
            int len2 = ExpandAroundCenter(s, i, i, times);
            int tmp = max(len1, len2);
            if(tmp > len)
            {
                len = tmp;
                left = i - (tmp - 1)/2;
                right = i + tmp/2;
                cout << left << right << len << endl;
            }
        }
        cout << times  << endl;
        return s.substr(left, len);

    }
    int ExpandAroundCenter(string s, int left, int right, int &times)
    {
        int ll = left;
        int rr = right;
        while(ll >= 0 && rr < s.length() && s[ll] == s[rr])
        {
            ll--;
            rr++;
            times++;
        }
        return (rr-ll-1);
    }
};

int main()
{
    string s = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
    Solutiontwo A;
    string res = A.longestPalindrome2(s);
    cout << res << endl;
    return 0;
}