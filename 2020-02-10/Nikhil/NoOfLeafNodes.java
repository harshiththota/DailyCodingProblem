package trees;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 10/02/20, Mon
 **/

/*
Link: https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
 */
public class NoOfLeafNodes {

    int countLeaves(Node node)
    {
        if(node.left == null && node.right == null)
            return 1;

        int left = node.left != null?countLeaves(node.left):0;
        int right = node.right != null?countLeaves(node.right):0;

        return left+right;
    }

}
