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
        q.offer(root);//�����ڵ����;
        while(!q.isEmpty()){ 
            TreeNode tmp = q.poll();//ÿ�ε���һ���ڵ㣬�Ѹýڵ�����Һ������;
            if(tmp.left != null){
                q.offer(tmp.left);
            }
            if(tmp.right != null){
                q.offer(tmp.right);
            }
            list.add(tmp.val);//�ٽ��ýڵ����list��;
        }
        return list;
    }
}