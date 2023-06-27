package Algorithm;

public class LargestBSTSubtree {
    class Node{
        Node left;
        Node right;
        int val;

        Node(int val ){
            this.val = val;
        }
    }

    //state [ min, max , curSize, ansSize]
    static int[]  getState(Node root){
        if(root==null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE,0,0};

        int[] leftAns = getState(root.left);
        int[] rightAns = getState(root.right);

        if(root.val<leftAns[1] || root.val> rightAns[0]){
            //failed
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE,-1,  Math.max(leftAns[3], rightAns[3])};
        }
        else {//(root.val>leftAns[1] &&  root.val<rightAns[0]){

            return new int[] { Math.min(leftAns[0], root.val), Math.max(rightAns[1], root.val) , leftAns[2]+rightAns[2]+1, Math.max(leftAns[2]+rightAns[2]+1,
                    Math.max(leftAns[3], rightAns[3]))   };

        }


    }




    static  int size(Node root){
        if(root==null)
            return 0;

        return 1+ size(root.left)+size(root.right);

    }


}
