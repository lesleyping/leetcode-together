//有右子树
//无右子数
    //当前是最左子孩子，返回他的父节点
    //当前不是最左子孩子，向上找
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
        {
            return null;
        }
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next != null){
            TreeLinkNode root = pNode.next;
            if(root.left == pNode){
                return root;
            }
            pNode = pNode.next;
        }
        return null;
    }
}