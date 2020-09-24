//1
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for(int i = 0; i < s.length(); i++){
            int index = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            tmp = (tmp < i - index) ? tmp + 1 : i - index;
            res = Math.max(tmp, res);
        }
        return res;
    }
}
//2
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int ll = -1;
        Map<Character,Integer> map = new HashMap<>();
        for(int rr = 0; rr < s.length(); rr++){
            ll = Math.max(ll, map.getOrDefault(s.charAt(rr),-1));
            map.put(s.charAt(rr), rr);
            res = Math.max(res, rr-ll);
        }
        return res;
    }
}