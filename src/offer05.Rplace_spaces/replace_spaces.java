public class Solution {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                spaceNum++;
            }
        }
        int oldIndex = str.length() - 1;
        int newlen = str.length() + 2 * spaceNum;
        int newIndex = newlen - 1;
        str.setLength(newlen);
        while(oldIndex >= 0 && newIndex >= 0){
            if(str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }else{
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
            oldIndex--;
        }
        return str.toString();
    }
}