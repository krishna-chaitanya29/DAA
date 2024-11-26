/*
 * Given a binary tree root, a node X in the tree is named Great if in the path 
from root to X there are no nodes with a value greater than or equals X.

Return the number of Great nodes in the binary tree.

You will be given root node of a binary tree return total number of nodes which satisfies above statement.

Input format: 
-------------
Line-1: Space seperated integers

Output format:
---------------
Line-1: An integer

Sample Input-1:
---------------
3 1 4 3 -1 1 5

Sample Output-1:
----------------
4

Explanation: 
Root Node (3) is always a Great node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Sample Input-2:
---------------
3 5 1 6 2 9 8 -1 -1 7 4

Sample Output-2:
----------------
6
 */

package day 23;

public class DAA_Day23_AP32_Great_Nodes {
    
}
