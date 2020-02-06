# Problem
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

# Analyze
有思路 但是while循环写不出来感觉自己很智障.。。。。
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int m = matrix.size();
        vector<int> res;
        if(m == 0) return res;
        int n = matrix[0].size();
        int left = 0, up = 0;
        int right = n-1;
        int down = m-1;
        while(true){
            for(int i = left; i <= right; i++)res.push_back(matrix[up][i]);
            if(++up > down)break;
            for(int i = up; i <= down; i++)res.push_back(matrix[i][right]);
            if(--right < left)break;
            for(int i = right; i>= left; i--)res.push_back(matrix[down][i]);
            if(--down < up)break;
            for(int i = down; i >= up; i--)res.push_back(matrix[i][left]);
            if(++left > right)break;
        }
            
        return res;
    }
};
