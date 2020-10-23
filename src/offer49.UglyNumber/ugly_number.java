public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0){
            return 0;
        }
        int a = 0, b = 0, c = 0;
        int[] list = new int[index];
        list[0] = 1;
        for(int i = 1; i < index; i++){
            int n2 = list[a] * 2, n3 = list[b] * 3, n5 = list[c] * 5;
            list[i] = Math.min(Math.min(n2,n3), n5);
            //以下部分不能使用else if
            //因为当填写6的时候，两个下标需要移动
            if(list[i] == n2) a++;
            if(list[i] == n3) b++;
            if(list[i] == n5) c++;
        }
        return list[index-1];
    }
}