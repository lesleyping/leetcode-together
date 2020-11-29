// 回溯法 + 剪枝
class Solution {
    boolean[] used;
    int[] factorial;
    int n;
    int k;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n+1];
        factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }
    private void dfs(int index, StringBuilder sb) {
        if (index == n) {
            return ;
        }
        int res = factorial[n-index-1];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (k > res) {
                k -= res;
                continue;
            }
            sb.append(i);
            used[i] = true;
            dfs(index+1, sb);
            return ;
        }
    }
}