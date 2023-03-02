/**
 * Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.
 * 
 * Return the root of the Quad-Tree representing the grid.
 * 
 * Notice that you can assign the value of a node to True or False when isLeaf is False, and both are accepted in the answer.
 * A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
 * 1. val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
 * 2. isLeaf: True if the node is leaf node on the tree or False if the node has the four children.
 * 
 * We can construct a Quad-Tree from a two-dimensional area using the following steps:
 * 1. If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
 * 2. If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
 * 3. Recurse for each of the children with the proper sub-grid.
 * 
 * If you want to know more about the Quad-Tree, you can refer to the wiki.
 * 
 * Quad-Tree format:
 * The output represents the serialized format of a Quad-Tree using level order traversal, where null signifies a path terminator where no node exists below.
 * It is very similar to the serialization of the binary tree. The only difference is that the node is represented as a list [isLeaf, val].
 * If the value of isLeaf or val is True we represent it as 1 in the list [isLeaf, val] and if the value of isLeaf or val is False we represent it as 0.
 * 
 * Example 1:
 * Input: grid = [[0,1],[1,0]]
 * Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
 * Explanation: The explanation of this example is shown below:
 * 
 * Example 2:
 * Input: grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
 * Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
 * Explanation: All values in the grid are not the same. We divide the grid into four sub-grids.
 * The topLeft, bottomLeft and bottomRight each has the same value.
 * The topRight have different values so we divide it into 4 sub-grids where each has the same value.
 */

package al.leetcode.medium;

import ds.QuadTreeNode;

public class problem_0427 {

    public QuadTreeNode solution(int[][] grid) {
        return solution(grid, 0, grid.length, 0, grid.length);
    }

    public QuadTreeNode solution(int[][] grid, int rs, int re, int cs, int ce) {
        if (rs + 1 < re && cs + 1 < ce) {
            QuadTreeNode tL = solution(grid, rs, (rs + re) / 2, cs, (cs + ce) / 2);
            QuadTreeNode tR = solution(grid, rs, (rs + re) / 2, (cs + ce) / 2, ce);
            QuadTreeNode bL = solution(grid, (rs + re) / 2, re, cs, (cs + ce) / 2);
            QuadTreeNode bR = solution(grid, (rs + re) / 2, re, (cs + ce) / 2, ce);
            boolean isLeaf = tL.isLeaf() && tR.isLeaf() && bL.isLeaf() && bR.isLeaf();
            boolean sameVal = (tL.isVal() == tR.isVal()) && (tR.isVal() == bL.isVal()) && 
                              (bL.isVal() == bR.isVal()) && (bR.isVal() == tL.isVal());
            if (isLeaf && sameVal) {
                return new QuadTreeNode(tL.isVal(), isLeaf);
            } else {
                return new QuadTreeNode(true, false, tL, tR, bL, bR);
            }
        } else {
            return new QuadTreeNode(grid[rs][cs] == 1, true);
        }
    }
    
}
