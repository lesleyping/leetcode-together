import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0){
            return res;
        }
        int l = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            l = i - size + 1;
            if(!q.isEmpty() && l > q.peekFirst()){
                q.pollFirst();
            }
            while(!q.isEmpty() && num[q.peekLast()] <= num[i]){
                q.pollLast();
            }
            q.add(i);
            if(l >= 0){
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}

//------太难了