class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++){
            for (int j = i - 1; j > 0; j--){
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}