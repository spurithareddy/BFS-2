// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/*
 Do dfs traversal and track if we found x , y and parents of x and y and thier level we check if we have 
 x and y with different pants on same level
*/
class Solution {

    boolean findX = false;
    boolean findY = false;
    int xParent = 0;
    int yParent = 0;
    int xLevel = 0;
    int yLevel = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, root, 0, x, y);
        return findX && findY && (xLevel == yLevel) && (xParent != yParent);
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        if (root == null)
            return;
        if (root.val == x) {
            this.findX = true;
            this.xLevel = level;
            this.xParent = parent.val;
        }
        if (root.val == y) {
            this.findY = true;
            this.yLevel = level;
            this.yParent = parent.val;
        }
        dfs(root.left, root, level + 1, x, y);
        dfs(root.right, root, level + 1, x, y);
    }
}



// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/*
 Do level order traversal and track if we found x , y and parents of x and y and after each level we check if we have 
 x and y with different parents on same level
*/
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            boolean findX = false;
            boolean findY = false;
            int xParent = 0;
            int yParent = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = que.poll();
                if (temp.left != null) {
                    if (temp.left.val == x) {
                        findX = true;
                        xParent = temp.val;
                    }
                    if (temp.left.val == y) {
                        findY = true;
                        yParent = temp.val;
                    }
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    if (temp.right.val == x) {
                        findX = true;
                        xParent = temp.val;
                    }
                    if (temp.right.val == y) {
                        findY = true;
                        yParent = temp.val;
                    }
                    que.add(temp.right);
                }
                if (findX == true && findY == true && xParent != yParent) {
                    return true;
                }
            }

        }

        return false;
    }
}