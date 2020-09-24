import java.util.*;
public class Solution {
    Map<Character,Integer> map = new LinkedHashMap<>();
    
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        map.put(ch, map.getOrDefault(ch, -1) + 1);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 0){
                return entry.getKey();
            }
        }
        return '#';
    }
}