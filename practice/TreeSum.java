package practice;

import java.util.ArrayList;

class Tn {
    int val = 0;
    Tn left = null;
    Tn right = null;

    public Tn(int val) {
        this.val = val;

    }

}

public class TreeSum {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(Tn root,int target) {
        if(root == null || target < root.val) return res;
        list.add(root.val);
        target -= root.val;
   		if(target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size() - 1);
        return res;
    }
}