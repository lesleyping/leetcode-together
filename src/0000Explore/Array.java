//1
class Solution {
    public int pivotIndex(int[] nums) {
        int sumTotal = 0;
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++){
            sumTotal += nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            if (sumLeft * 2 == sumTotal - nums[i]){
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }
}
//2
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }
            else if (nums[mid] > target){
                right = mid;
            }
            else if(nums[mid] == target){
                return mid;
            }
        }
        return left;
    }
}
//3
class Solution {
    void exchange(int[][] intervals, int i, int j){
        for (int t = 0; t < 2; t++){
            int tmp = intervals[i][t];
            intervals[i][t] = intervals[j][t];
            intervals[j][t] = tmp;
        }
    }

    int partition(int[][] intervals, int low, int high){
        int i = low;
        int j = high+1;
        int tmp = low;
        while(true){
            while(intervals[++i][0] < intervals[tmp][0]){
                if (i == high) break;
            }
            while(intervals[--j][0] > intervals[tmp][0]){
                if (j == low) break;
            }
            if (i >= j) break;
            exchange(intervals, i, j);
        }
        exchange(intervals, tmp, j);
        return j;
    }

    void quicksort(int[][] intervals, int low, int high){
        if (low >= high) return ;
        int j = partition(intervals, low, high);
        quicksort(intervals, low, j-1);
        quicksort(intervals, j+1, high);
    }

    public int[][] merge(int[][] intervals) {
        quicksort(intervals, 0, intervals.length-1);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] tmp : intervals){
            if (idx == -1 || tmp[0] > res[idx][1]){
                res[++idx] = tmp;
            }
            else{
                res[idx][1] = Math.max(res[idx][1], tmp[1]);
            }
        }
        return Arrays.copyOf(res, idx+1);
    }
}
//4
class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++){
            for (int j = i; j < length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            for (int j = 0; j < length/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][length-j-1];
                matrix[i][length-j-1] = tmp;
            }
        }
    }
}
//5
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean shu = false;
        boolean heng = false;
        for (int i = 0; i < matrix.length; i++){
            for ( int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    if (i == 0){
                        heng = true;
                    }
                    if (j == 0){
                        shu = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                for (int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                for (int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if (heng){
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if (shu){
            for ( int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
//6
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        if (n == 0) return new int[0];
        int[] res = new int[m * n];
        int sum = 0;
        int index = 0;
        int x, y;
        while (sum < m + n){
            if (sum % 2 == 0){
                x = sum < m ? sum : m-1;
                y = sum - x;
                while(x >= 0 && y < n){
                    res[index++] = matrix[x][y];
                    x--;
                    y++;
                }
            }
            else if (sum % 2 == 1){
                y = sum < n ? sum : n-1;
                x = sum - y;
                while (y >= 0 && x < m){
                    res[index++] = matrix[x][y];
                    x++;
                    y--;
                }
            }
            sum++;
        }
        return res;
    }
}

//7
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(res) != 0){
                res = res.substring(0,res.length()-1);
            }
            i++;
        }
        return res;
    }
}
//8-1
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length-1; i++){
            for (int j = i+1; j < str.length; j++){
                if (j-i+1 > maxLen && isPalindrome(str, i, j)){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
    public boolean isPalindrome(char[] str, int begin, int end){
        int l = begin;
        int r = end;
        while(l < r ){
            if(str[l] != str[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//8-2
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++){
            for (int i = 0; i < j; i++){
                if (str[j] != str[i]){
                    dp[i][j] = false;
                }
                else
                {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && (j-i+1)>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
}
//8-3
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0,1);
        for(int i = 0; i < s.length()-1; i++){
            String even = centerSpread(s, i, i);
            String odd = centerSpread(s, i, i+1);
            String max = (even.length() > odd.length()) ? even : odd;
            if(max.length() > maxLen){
                maxLen = max.length();
                res = max;
            }
        }
        return res;
    }
    public String centerSpread(String str, int left, int right){
        int l = left;
        int r = right;
        while(r < str.length() && l >= 0){
            if(str.charAt(l) != str.charAt(r)){
                break;
            }
            else{
                r++;
                l--;
            }
        }
        return str.substring(l+1,r);
    }
}
//9
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> str = Arrays.asList(s.split("\\s+"));
        Collections.reverse(str);
        return String.join(" ", str);
    }
}
//10
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        int[] next = new int[n];
        next[0] = -1;
        //get next
        int i = 0;
        int j = -1;
        while (i < n-1){
            if (j == -1 || needle.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
        //match
        i = 0;
        j = 0;
        while(i < m && j < n){
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if (j == n){
            return i-j;
        }
        return -1;
    }
}
//11
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
//12
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 2;
        int sum = 0;
        while (i < j){
            sum += nums[i] + nums[j];
            i += 2;
            j -= 2;
        }
        if (i == j) sum += nums[i];
        return sum;
    }
}
//13
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            if (numbers[i] + numbers[j] < target){
                i++;
            }
            else if (numbers[i] + numbers[j] > target){
                j--;
            }
            else{
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }
}
//14
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
}
//15
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0;
        int max = 0;
        while(j < nums.length){
            if (nums[j++] == 0){
                max = Math.max(max, j - 1 - i);
                i = j;
            }
        }
        return Math.max(max, j - i);
    }
}
//16
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0, r = 0;
        while (r < nums.length){
            sum += nums[r];
            r++;
            while(sum >= s){
                min = Math.min(min, r - l);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
//17
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            res.add(new ArrayList<>());
            for (int j = 0; j < i+1; j++){
                if (j == 0 || j == i){
                    res.get(i).add(1);
                }
                else{
                    res.get(i).add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
        }

        return res;
    }
}
//18.
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++){
            for (int j = i - 1; j > 0; j--){
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}
