class Solution {
    int count = 0;
    public int[] printNumbers(int n) {
        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int[] res = new int[(int)Math.pow(10,n) - 1];
        helper(n, res, nums, new StringBuilder(), 0);
        return res;
    }
    private void helper(int n, int[] res, char[] nums, StringBuilder sb, int idx) {
        if (idx == n) {
            String tmp = sb.toString();
            int firstNotZero = 0;
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '0') {
                    firstNotZero++;
                } else {
                    break;
                }
            }
            tmp = tmp.substring(firstNotZero);
            if ("".equals(tmp)) {
                return ;
            }
            res[count] = Integer.parseInt(tmp);
            count++;
            return ;
        }
        for (char num : nums) {
            sb.append(num);
            helper(n, res, nums, sb, idx+1);
            sb.deleteCharAt(idx);
        }
    }
}