#include<iostream>
#include<vector>
using namespace std;

class Solution{
public:
    int uniquePaths(int m, int n){
        vector<int> a(n,1);
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                a[j] += a[j-1];
            }
        }
        return a[n-1];
    }
};

int main()
{
    int m = 7;
    int n = 3;
    Solution S;
    int res = S.uniquePaths(m ,n);
    cout << res << endl;
    return 0;
}