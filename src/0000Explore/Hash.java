//1
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int n : nums){
            if (hash.contains(n)){
                return true;
            }
            hash.add(n);
        }
        return false;
    }
}
//2-1
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)){
                set.remove(n);
            }else{
                set.add(n);
            }
        }
        int res = 0;
        for(int n : set){
            res = n;
        }
        return res;
    }
}
//2-2
class Solution {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}
//2-3
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0, j=1; j < nums.length; i=i+2, j=j+2){
            if(nums[i] != nums[j]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
//3-1
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();
        for(int n : nums1){
            n1.add(n);
        }
        for(int n : nums2){
            if(n1.contains(n)){
                n2.add(n);
            }
        }
        int[] res = new int[n2.size()];
        int i = 0;
        for(int n : n2){
            res[i++] = n;
        }
        return res;
    }
}
//3-2
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }
        }
        int[] res = new int[set.size()];
        int t = 0;
        for(int n : set){
            res[t++] = n;
        }
        return res;
    }
}
//4-1
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = n;
        while(sum != 1){
            if(set.contains(sum)){
                return false;
            }else{
                set.add(sum);
                int tmp = 0;
                while(sum > 0){
                    tmp += Math.pow(sum%10, 2);
                    sum /= 10;
                }
                sum = tmp;
            }
        }
        return true;
    }
}
//4-2
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = next(slow);
            fast = next(fast);
            fast = next(fast);
        }while(slow != fast);
        return slow == 1;
    }
    int next(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }
}
//5-1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
//5-2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]) && i != map.get(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
        }
        return new int[]{-1, -1};
    }
}
//5-3
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]) && i != map.get(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
//6
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        for(int i = 0; i < str1.length; i++){
            if(maps.containsKey(str1[i])){
                if(str2[i] != maps.get(str1[i])){
                    return false;
                }
            }else if(mapt.containsKey(str2[i])){
                if(str1[i] != mapt.get(str2[i])){
                    return false;
                }
            }else{
                maps.put(str1[i], str2[i]);
                mapt.put(str2[i], str1[i]);
            }
        }
        return true;
    }
}
//7
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        List<String> str = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                if(min == i + map.get(list2[i])){
                    str.add(list2[i]);
                }else if(i + map.get(list2[i]) < min){
                    min = i + map.get(list2[i]);
                    str.clear();
                    str.add(list2[i]);
                }
            }
        }
        String[] res = (String[])str.toArray(new String[str.size()]);
        return res;
    }
}
//8
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){
            if(map.containsKey(str[i])){
                map.put(str[i], map.get(str[i]) + 1);
            }else{
                map.put(str[i], 1);
            }
        }
        for(int i = 0; i < str.length; i++){
            if(map.get(str[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
//9-1
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i])+1);
            }else{
                map.put(nums1[i], 1);
            }
        }
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }
}
//9-2
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int ll = 0, rr = 0;
        while(ll < nums1.length && rr < nums2.length){
            if(nums1[ll] < nums2[rr]){
                ll++;
            }else if(nums1[ll] > nums2[rr]){
                rr++;
            }else if(nums1[ll] == nums2[rr]){
                res.add(nums1[ll]);
                ll++;
                rr++;
            }
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }
}
//10-1
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)){
                return true;
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
//10-2
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
//11
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String root = new String(tmp);
            if(map.containsKey(root)){
                map.get(root).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(root, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
//12
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int index = (i/3) * 3 + j/3;
                int val = board[i][j] - '1';
                if(row[i][val] == 0 && col[j][val] == 0 && box[index][val] == 0){
                    row[i][val] = 1;
                    col[j][val] = 1;
                    box[index][val] = 1;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
//13
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        dfs(root);
        return res;
    }
    private String dfs(TreeNode root){
        if(root == null){
            return "";
        } 
        String tmp = String.valueOf(root.val) + "," + 
            dfs(root.left) + "," + dfs(root.right);
        
        if(map.containsKey(tmp)){
            if(map.get(tmp) == 1){
                res.add(root);
            } 
            map.put(tmp, map.get(tmp) + 1);
        }else{
            map.put(tmp, 1);
        }
        return tmp;
    }
}
//14
class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        char[] strj = J.toCharArray();
        char[] strs = S.toCharArray();
        int count = 0;
        for(int i = 0; i < strj.length; i++){
            set.add(strj[i]);
        }
        for(int i = 0; i < strs.length; i++){
            if(set.contains(strs[i])){
                count++;
            }
        }
        return count;
    }
}
//15
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s)) return 0;
        int ll = 0;
        int maxlen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        char[] strs = s.toCharArray();
        for(int i = 0; i < strs.length; i++){
            while(set.contains(strs[i])){
                set.remove(strs[ll]);
                ll++;
            }
            maxlen = Math.max(maxlen, i - ll + 1);
            set.add(strs[i]);
        }
        return maxlen;
    }
}
//可以用charAt！！！！
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int ll = 0;
        int maxlen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(ll));
                ll++;
            }
            maxlen = Math.max(maxlen, i - ll + 1);
            set.add(s.charAt(i));
        }
        return maxlen;
    }
}
//16
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumAB = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int sum = A[i] + B[j];
                if(sumAB.containsKey(sum)){
                    sumAB.put(sum, sumAB.get(sum) + 1);
                }else{
                    sumAB.put(sum, 1);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int tmp = -(C[i] + D[j]);
                if(sumAB.containsKey(tmp)){
                    res += sumAB.get(tmp);
                }
            }
        }
        return res;
    }
}
//17-1
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return map.get(a) - map.get(b);
            }
        });
        for(Integer key : map.keySet()){
            if(pq.size() < k){
                //System.out.println("1:"+key);
                pq.offer(key);
            }else if(map.get(key) > map.get(pq.peek())){
                //System.out.println("2:"+key);
                pq.poll();
                pq.offer(key);
            }
        }
        int size = pq.size();
        int[] res = new int[size];
        for(int i = 0; i < size; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
//17-2
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer>[] freqList = new List[nums.length+1];
        for(int i = 0; i < nums.length+1; i++){
            freqList[i] = new ArrayList<>();
        }
        for(int key : map.keySet()){
            freqList[map.get(key)].add(key);
        }
        int idx = 0;
        int[] res = new int[k];
        for(int i = nums.length; i >= 0; i--){
            if(freqList[i] == null){
                continue;
            }
            for(int num : freqList[i]){
                res[idx++] = num;
                if(idx == k){
                    return res;
                }
            }
        }
        return res;
    }
}


//18
class RandomizedSet {
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> value = new ArrayList<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, value.size());
        value.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int size = value.size();
        int loc = map.get(val);
        map.put(value.get(size-1),loc);
        map.remove(val);
        value.set(loc, value.get(size-1));
        value.remove(size-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return value.get(rand.nextInt(value.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 *izedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 */