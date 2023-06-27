package Algorithm;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        TreeNode tmp = root.right;
        tmp.left = new TreeNode(6);
        tmp.right = new TreeNode(4);

        String res = getDirections(root, 3,6);
        System.out.println("res"+res);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        res = getDirections(root2, 2,1);
        System.out.println("res"+res);


        System.out.println("LCA "+getLca(root,3,6).val);
        System.out.println("path  "+getDirections2(root,3,6));

    }





     /*
    SOLUTOIN 2 pass
     */
    public static TreeNode getLca(TreeNode root, int startValue,int destValue){
        if (root==null)
            return root;
        if(root.val ==startValue || root.val ==destValue)
            return root;

        TreeNode left = getLca(root.left, startValue,destValue);
        TreeNode right = getLca(root.right, startValue,destValue);

        if(left!=null && right!=null)
            return  root;

        if(left!=null)
            return  left;
        return  right;

    }

    public static boolean getPath(TreeNode root, int destVal, StringBuilder path){
        if(root==null)
            return false;
        if(root.val == destVal)
            return true;

        path.append("L");
        if(getPath(root.left, destVal, path))
            return true;
        path.deleteCharAt(path.length()-1);

        path.append("R");
        if(getPath(root.right, destVal, path))
            return true;
        path.deleteCharAt(path.length()-1);

        return false;
    }

    public static  String getDirections2(TreeNode root, int startValue, int destValue) {
        TreeNode lca = getLca(root,startValue,destValue);

        StringBuilder pathToStart = new StringBuilder();
        getPath(lca, startValue, pathToStart);

        StringBuilder pathToDest = new StringBuilder();
        getPath(lca, destValue, pathToDest);

        //replace all  char to U  in pathToStart -> startToLCA
        String pToStart = pathToStart.toString().replace("L", "U");
        pToStart = pToStart.replace("R", "U");
        return pToStart+pathToDest.toString();

    }


    /*
    solution 2 end
     */







    /*
    SOLUTOIN 1 DIDNT pass LTE
     */

    static  String start="";
    static String end="";
    public static  String  getDirections(TreeNode root, int startValue, int destValue) {
        String res = helper(root,startValue,destValue);
        return res.substring(1,res.length()-1);
    }

    public static String helper(TreeNode root, int startValue, int destValue) {
        if(root ==  null)
            return "";


        if(root.val == startValue){
            start = "S";
        }
        if(root.val == destValue ){
            end= "D";
        }
        String left = helper(root.left,startValue,destValue);

        String right = helper(root.right,startValue,destValue);

        System.out.println(" nood "+root.val+" left "+left+" right "+right);
        if(left.contains("S") && left.contains("D")){
            return left;
        }else if(right.contains("S") && right.contains("D")){
            return right;
        }

        if(left.contains("S") && !left.contains("D")){
            start=left+"U";
        } else if (left.contains("D") && !left.contains("S")){
            end = "L"+left;
        }
        if(right.contains("S") && !right.contains("D")){
            start=right+"U";
        } else if (right.contains("D") && !right.contains("S")){
            end = "R"+right;
        }
        return start+end;
    }

/*
    SOLUTOIN 1 END
     */




    public static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}



/*
 soluition 3
 public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder leftPath = new StringBuilder();
        StringBuilder rightPath = new StringBuilder();

        getPath(root, startValue, leftPath);
        getPath(root, destValue, rightPath);

        //if( left char == right char )-> LCA
        while(!leftPath.isEmpty() && !rightPath.isEmpty() && leftPath.charAt(leftPath.length()-1) == rightPath.charAt(rightPath.length()-1))
        {
            leftPath.deleteCharAt(leftPath.length()-1);
            rightPath.deleteCharAt(rightPath.length()-1);
        }

        for(int i=0; i < leftPath.length(); i++)
        {
            leftPath.setCharAt(i, 'U');
        }

        return leftPath.append(rightPath.reverse()).toString();
    }


    private boolean getPath(TreeNode root, int value, StringBuilder path)
    {
        if(root == null){
            return false;
        }

        if(root.val == value){
            return true;
        }

        if(root.left != null && getPath(root.left, value, path))
        {
            path.append('L');
            return true;
        }

        if(root.right != null && getPath(root.right, value, path)){
            path.append('R');
            return true;
        }

        return false;
    }
 */