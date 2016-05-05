package practice;
import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class TreeCengCiBianLi {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);//将根节点入队;
        while(!q.isEmpty()){ 
            TreeNode tmp = q.poll();//每次弹出一个节点，把该节点的左右孩子入队;
            if(tmp.left != null){
                q.offer(tmp.left);
            }
            if(tmp.right != null){
                q.offer(tmp.right);
            }
            list.add(tmp.val);//再将该节点存入list中;
        }
        return list;
    }
}