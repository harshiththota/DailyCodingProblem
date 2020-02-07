
/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 05/02/20, Wed
 **/


/*
Link to problem statement: https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
 */

public class MaxSumPath {

    static int maxSum = 0;

    public static int maxPathSum(Node root)
    {
        maxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxSum;
    }

    public static int findMaxPathSum(Node root) {

        if (root == null)
            return 0;

        int left = findMaxPathSum(root.left);
        int right = findMaxPathSum(root.right);

        int pathSum = left+root.data+right;

        if(pathSum > maxSum)
            maxSum = pathSum;

        return Math.max(left, right)+root.data;
    }
}
