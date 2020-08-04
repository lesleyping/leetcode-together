# Problem
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
'''
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
'''

# Analyze
回溯算法

（与动态规划一起看）

题目举例：

回溯问题就是决策树遍历过程。
1、路径：已经做出的选择
2、选择列表：也就是当前可以做的选择
3、结束条件：到达决策树底层，无法再做选择的条件

result = [ ]
Def backtrack(路径，选择列表）:
    If 满足结束条件：
        result.add(path)
        Return
    For choice in choice_list:
        Do choice
            （将该选择从选择列表移除）
            （路径.add（选择））
            
        Backtrack(path, choice_list)
        撤销选择
            （路径.remove（选择））
            （将该选择再加入选择列表）

核心在于在递归调用之前做选择，递归调用之后撤销选择

一、全排列问题
N个数字的全排列有n!个
多叉树的遍历问题
Void traverse(TreeNode root){
    for （TreeNode child : root.children)
    //前序遍历需要的操作
    Traverse(child)
    //后序遍历需要的操作

二、N皇后问题
O( N^(N+1))复杂度很高
vector<vector<string>> res;


/* 输入棋盘边长 n，返回所有合法的放置 */
vector<vector<string>> solveNQueens(int n) {
    // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
    vector<string> board(n, string(n, '.'));
    backtrack(board, 0);
    return res;
}


// 路径：board 中小于 row 的那些行都已经成功放置了皇后
// 选择列表：第 row 行的所有列都是放置皇后的选择
// 结束条件：row 超过 board 的最后一行
void backtrack(vector<string>& board, int row) {
    // 触发结束条件
    if (row == board.size()) {
        res.push_back(board);
        return;
    }
    
    int n = board[row].size();
    for (int col = 0; col < n; col++) {
        // 排除不合法选择
        if (!isValid(board, row, col)) 
            continue;
        // 做选择
        board[row][col] = 'Q';
        // 进入下一行决策
        backtrack(board, row + 1);
        // 撤销选择
        board[row][col] = '.';
    }
}

/* 是否可以在 board[row][col] 放置皇后？ */
bool isValid(vector<string>& board, int row, int col) {
    int n = board.size();
    // 检查列是否有皇后互相冲突
    for (int i = 0; i < n; i++) {
        if (board[i][col] == 'Q')
            return false;
    }
    // 检查右上方是否有皇后互相冲突
    for (int i = row - 1, j = col + 1; 
            i >= 0 && j < n; i--, j++) {
        if (board[i][j] == 'Q')
            return false;
    }
    // 检查左上方是否有皇后互相冲突
    for (int i = row - 1, j = col - 1;
            i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q')
            return false;
    }
    return true;
}


