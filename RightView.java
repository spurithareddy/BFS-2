// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/*
 Do level order traversal and add the last element to the result
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
        return res;
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    root = que.poll();
                    //add the last element in the level to the result
                    if (i == size - 1) {
                        res.add(root.val);
                    }
                    if (root.left != null) {
                        que.add(root.left);
                    }
                    if (root.right != null) {
                        que.add(root.right);
                    }
                }
            }
        
        return res;
    }
}



// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/*
 Take the level variable in DFS and when the size is level that means it is the last element , so store it
*/


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;
        if (res.size() == level)
            res.add(root.val);
        dfs(root.right, res, level + 1);
        dfs(root.left, res, level + 1);
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/*
 Take the level variable in DFS and when the size is less than level that means it is the last element , so store it
 if there is a previous element since we are traversing left first, overwrite it
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;
        if (res.size() <= level) {
            res.add(root.val); // First value at this level
        } else {
            res.set(level, root.val); // Overwrite with the latest seen value at this level
        }
       
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}