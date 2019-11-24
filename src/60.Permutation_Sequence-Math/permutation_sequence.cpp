#include<iostream>
#include<string>
#include<vector>
using namespace std;

class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> board(10,1);
        vector<int> ilabel(n+1,0);
        string res;
        n = n;
        k = k - 1;
        
        for(int i = 1; i < 10; i++){
            board[i] = board[i-1] * i;
        }

        while(n){
            int bit = k / board[n-1];
            k = k % board[n-1];
            int flag = 0;
            int i;
            for(i = 1; flag <= bit; i++){
                if(ilabel[i] == 0)flag++;
            }
            res = res + to_string(i-1);
            ilabel[i-1] = 1;
            n--;
        }
        return res;    
    }
};

int main()
{
    Solution S;
    int n = 3;
    int k = 4;
    string res = S.getPermutation(n, k);
    cout << res << endl;
    return 0;
}