class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] arr = digits.toCharArray();
        String[] s = {"*", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(arr, s, new StringBuilder(), 0);
        return res;
    }
    private void helper(char[] arr, String[] s, StringBuilder sb, int idx) {
        if (idx == arr.length) {
            res.add(sb.toString());
            return;
        }
        String tmp = s[arr[idx] - '0'];
        for (int i = 0; i < tmp.length(); i++) {
            sb.append(tmp.charAt(i));
            helper(arr, s, sb, idx+1);
            sb.deleteCharAt(idx);
        }
    }
}