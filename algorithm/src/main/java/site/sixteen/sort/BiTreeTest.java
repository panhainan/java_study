package site.sixteen.sort;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public class BiTreeTest {

    boolean isBST(TreeNode treeNode) {
        boolean lflag = false,rflag = false;
        if (treeNode != null) {
            if (treeNode.getLeft() != null) {
                if (treeNode.getLeft().getNum() < treeNode.getNum()) {
                    lflag = isBST(treeNode.getLeft());
                }
            }else{
                lflag = true;
            }
            if (treeNode.getRight() != null) {
                if (treeNode.getRight().getNum() > treeNode.getNum()) {
                    rflag = isBST(treeNode.getRight());
                }
            }else {
                rflag = true;
            }
            return lflag && rflag;
        }
        return true;
    }

    class TreeNode {
        private int num;
        private TreeNode left;
        private TreeNode right;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
