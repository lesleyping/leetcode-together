class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> str = Arrays.asList(s.split("\\s+"));
        Collections.reverse(str);
        return String.join(" ", str);
    }
}
//C++版本可以参考
class Solution {
public:
    string reverseWords(string s) {
        string word,res;
        stringstream ss(s);
        while(ss >> word){
            res.insert(0, word + " ");
        }
        return res.size() ? string(res.begin(), res.end()-1) : "";
    }
};

//C++版本可以参考
//原地反转的方法：

class Solution {
public:
    string reverseWords(string s) {
        reverse(s.begin(), s.end());
        int start = 0, end = s.length() - 1;
//deal with space 
        while(s[start] == ' ' && start < s.length()) start++;
        while(s[end] == ' ' && end >= 0) end--;
        if(start > end) return "";
        
        for(int i = start; i <= end; ){
            while(s[i] == ' ' && i <= end) i++;
            int j = i;
            while(s[j] != ' ' && j <= end) j++;
            reverse(s.begin()+i, s.begin()+j);
            i = j;
        }
        
        int k = start;
        for(int i = start; i <= end; i++){
            if(s[i] == ' ' && s[i-1] == ' ')continue;
            s[k++] = s[i];            
        }
        
        return s.substr(start, k - start);
    }
};
