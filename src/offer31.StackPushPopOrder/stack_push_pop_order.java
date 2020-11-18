//1 -- ?好像不对
// 最后的循环对于[2,1,0] [1,2,0]的结果有问题
import java.util.ArrayList;
import java.util.*;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0){
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for(Integer num : pushA){
            if(num != popA[i]){
                stack.push(num);
            }else{
                i++;
            }
        }
        for(int j = i; j < popA.length; j++){
            if(stack.peek() == popA[j]){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
//2
import java.util.ArrayList;
import java.util.*;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0){
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for(Integer num : pushA){
            stack.push(num);
            while(!stack.isEmpty() && popA[i] == stack.peek()){
                stack.pop();
                i++;
            }
        }
        
        return stack.isEmpty();
    }
}