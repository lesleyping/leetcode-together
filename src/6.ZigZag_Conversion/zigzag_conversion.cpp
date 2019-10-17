#include<iostream>
#include<stdlib.h>
#include<vector>
#include<string>

using namespace std;
#define min(a,b) (((a) < (b)) ? (a) : (b))
class Solution {
public:
    string convert(string s, int numRows) {
        if (s.length() == 0)
        {
            return "";
        }
        if(s.length() == 1)
        {
            return s;
        }
        if(numRows == 1)
        {
            return s;
        }
        vector<vector<char> > nrows(numRows);
        string result = "";
        int len = s.length();
        int index = 0;
        int num = numRows-1;
        for(int i = 0; i < len; i++)
        {
            if(i%num == 0)
            {
                if((i/num)%2 == 0)
                {
                    index = 0;
                }
                else
                {
                    index = num;
                }
                
            }
            else
            {
                if((i/num)%2 == 0)
                {
                    index = i%num;
                }
                else
                {
                    index = num - (i%num);
                }
                
            }           
            nrows[index].push_back(s[i]);
        }
        for (int j = 0; j<numRows; j++)
        {
            for(int p = 0; p<nrows[j].size(); p++)
            {
                result = result + nrows[j][p];
            }
        }
        return result;
    }
};


class Solution2
{
public:
    string convert(string s, int numRows){
        if(numRows == 1)return s;
        int len = s.length();
        int curRow = 0;
        int rows = min(s.length(),numRows);
        vector<string> nrows(rows);
        bool Downwords = false;
        
        for(char c : s)
        {
            nrows[curRow] += c;
            if(curRow == (numRows - 1) || curRow == 0)Downwords = ! Downwords;
            curRow += (Downwords ? 1 : -1);
        }
        string result = "";
        for(string s : nrows)
        {
            result += s;
        }
        return result;
    }
};

class Solution3
{
public:
    string convert(string s, int numRows){
        string res = "";
        cyclenum = 2 * (numRows - 1)；
        int len = s.length();
        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j+i < len; j = j+cyclenum)
            {
                res += s[i+j];
                if(i != 0 && i != (numRows-1) && (j+cyclenum-i)<len)
                {
                    res += s[j+cyclenum-i];
                }
            }
        }
        return res;
    }
};

int main()
{
    string s = "ADFGHYJKLU";
    int rowNum = 4;
    Solution2 A;
    string res = A.convert(s, rowNum);
    cout << res << endl;
    return 0;
}