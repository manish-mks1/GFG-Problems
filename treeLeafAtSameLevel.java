class Solution
{
    int count =0;
    int c1 = 0;
    int level(Node root){
        if(root == null)return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
//Count all leaf node in tree
    void find(Node root){
        if(root == null)return;
        if(root.left == null && root.right == null)count++;
        find(root.left);
        find(root.right);
    }
//count all nodes at last level
    void find1(Node root,int n){
        if(root == null)return;
        if(n == 1)c1++;
        find1(root.left,n-1);
        find1(root.right,n-1);
    }
    boolean check(Node root)
    {
	// Your code here	
	int n = level(root);
	find(root);
	find1(root,n);
//if node will be same at last level to the total leaf node then return true else return false
	if(count == c1)return true;
	else return false;
    }
}