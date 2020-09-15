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
