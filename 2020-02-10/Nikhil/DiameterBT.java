package trees;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 10/02/20, Mon
 **/

/*
Link: https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
 */
public class DiameterBT {

    static int maxDiameter = 0;

    public static int diameter(Node node)
    {
        maxDiameter = Integer.MIN_VALUE;
        getMaxDiameter(node);
        return maxDiameter;

    }

    public static int getMaxDiameter(Node root){

        if (root == null)
            return 0;

        int left = getMaxDiameter(root.left);
        int right = getMaxDiameter(root.right);

        int diameter = left+right+1;

        if(diameter > maxDiameter)
            maxDiameter = diameter;

        return Math.max(left, right)+1;
    }

}
