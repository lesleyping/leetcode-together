import java.util.ArrayList;
import java.util.*;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                String s1 = a + "" + b;
                String s2 = b + "" + a;
                return s1.compareTo(s2);
            }
        });
        for(int n : list){
            s += n;
        }
        return s;
    }
}