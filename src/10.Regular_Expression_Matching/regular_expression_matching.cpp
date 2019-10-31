#include <iostream>
#include<string>
using namespace std;


class Solution {
public:
    bool isMatch(string s, string p) {
        int lenp = p.size();
        int lens = s.size();
        cout<<s<<endl;
        cout<<p<<endl;
        if (p.empty()) return s.empty();
        bool first_match = (lens > 0) && ((p[0] == s[0]) || (p[0] == '.'));
        if((p.size() >= 2) && p[1] == '*')
        {

            return (isMatch(s, p.substr(2,lenp-2)) || (first_match && isMatch(s.substr(1, lens-1), p)));
        }
        else
            return first_match && isMatch(s.substr(1, lens-1), p.substr(1, lenp-1));
    }
};

int main()
{
    string s = "aa";
    string p = "a";
    Solution A;
    bool res = A.isMatch(s,p);
    cout << res << endl;
    return 0;
}
