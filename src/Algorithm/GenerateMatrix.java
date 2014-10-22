package Algorithm;


public class GenerateMatrix {
	public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
       int l;
       
       if (n%2==0){
           l=n/2;
       }
       else {
           l=n/2+1;
       }
       
       
       for (int i=1; i<=l; i++){
           function (i,matrix,n);
       }
       return matrix;
        
    }
    
    public void function(int l, int [][] m, int n){
        int i=l-1;//row
        int j=l-1;//coulum
        if (l==1){
            m[0][0]=1;
        }
        
        else {
            m[l-1][l-1]=m[l-1][l-2]+1;
        }
        int col=j;
        int row=i;
        // 1 row , n colum
        
        
        int f=(n-l-col)*4;
        int count=0; 
            for ( j=j; j<n-1;++j){
            	//if (m[i][j+1]!=0) return;
                m[i][j+1]=m[i][j]+1;
                count ++;
                if (count>f) return;
            }
            
            //last colum, n row 
            for (i=i;i<n-1;++i){
            	//if (m[i+1][j]!=0) return;
                m[i+1][j]=m[i][j]+1;
                count ++;
                if (count>f) return;
            }
            
            // last row, j-1 colum
            for (j=j;j>l-1;--j){
            	//if (m[i][j-1]!=0) return;
                m[i][j-1]=m[i][j]+1;
                count ++;
                if (count>f) return;
            }
            
            for (i=i;i>l;--i){
            	//if (m[i-1][j]!=0) return;
                m[i-1][j]=m[i][j]+1;
                count ++;
                if (count>f) return;
            }
            
            /*
            for ( j=0; j<n-1;++j){
                m[i][j+1]=m[0][j]+1;
            }
            for (i=n-1;i<n-1;++i){
                m[i+1][j]=m[i][j]+1;
            }
            for 
            */
        
    }
    
     public static void main(String []args){
        System.out.println("Hello World");
        GenerateMatrix hw =new GenerateMatrix();
        String s="0123456  8910 abc fed ";
        char[] chars =s.toCharArray();
     //   String str=hw.swap(s,0,4);
     //  hw.reverse(chars, 3,5);
       
       // String s="abcbdw w";
       int n=4;
       int i=0;
       int j=0;
       int [][] m=hw.generateMatrix(n);
       while (i<n){
    	   j=0;
           while (j<n){
        	  
               System.out.println(m[i][j]);
               j++;
           }
           i++;
       }
     //  System.out.println(hw.reverseWords(s));
     }

}
