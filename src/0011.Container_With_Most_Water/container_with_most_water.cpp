#include<iostream>
#include<vector>

using namespace std;
#define max(a,b) (((a) > (b)) ? (a) : (b))
#define min(a,b) (((a) < (b)) ? (a) : (b))

class Solution{
public:
    int maxArea(vector<int>& height){
        int x = 0;
        int y = height.size()-1;
        int maxarea = 0;
        int tmp = 0;
        while(x < y)
        {
            tmp = (y-x) * min(height[x], height[y]);
            if(tmp > maxarea)
            {
                maxarea = tmp;
            }
            if(height[x] < height[y])
            {
                x++;
            }
            else
            {
                y--;
            }
        }
        return maxarea;
    }
};

int main()
{
    vector<int> height = {1,8,6,2,5,4,8,3,7};
    Solution A;
    int res = A.maxArea(height);
    cout << res << endl;
    return 0;
}