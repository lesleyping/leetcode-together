class Solution {
    public String decodeString(String s) {
        Stack<Integer> intSta = new Stack<>();
        Stack<String> strSta = new Stack<>();
        String res = "";
        int multi = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '['){
                intSta.push(multi);
                strSta.push(res);
                multi = 0;
                res = "";
            }
            else if(s.charAt(i) == ']'){
                StringBuilder tmp = new StringBuilder();
                int cur_multi = intSta.pop();
                for (int j = 0; j < cur_multi; j++){
                    tmp.append(res);
                }
                res = strSta.pop() + tmp;
            }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                multi = multi * 10 + Integer.parseInt(s.charAt(i) + "");
            }
            else{
                res += s.charAt(i);
            }
        }
        return res;
    }
}
//13-2
class Solution {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int left){
        int multi = 0;
        StringBuilder str = new StringBuilder();
        while(left < s.length()){
            if (s.charAt(left) >= '0' && s.charAt(left) <= '9'){
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(left)));
            }else if(s.charAt(left) == '['){
                String[] tmp = dfs(s, left+1);
                left = Integer.parseInt(tmp[0]);
                while(multi > 0){
                    str.append(tmp[1]);
                    multi--;
                }
            }else if(s.charAt(left) == ']'){
                return new String[]{String.valueOf(left), str.toString()};
            }else{
                str.append(s.charAt(left));
            }
            left++;
        }
        return new String[]{str.toString()};
    }
}