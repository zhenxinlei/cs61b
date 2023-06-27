package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GrayCode {
    public static void main(String[] args) {



        ArrayList<Integer> list =  grayCode(3);
        System.out.println(list);
    }


    public static  ArrayList<Integer>  grayCode(int n){
        if(n<0)
            return new ArrayList<Integer>();
        if(n==0){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(0);
            return tmp;
        }

        ArrayList<Integer> tmp = grayCode(n-1); //sub prob, with halfsize,
        ArrayList<Integer> res = new ArrayList<>(tmp);
        int num = 1<< (n-1);// shift n-1 , so we have enoght space to stroe nums in tmp
        for (int i = tmp.size()-1;i>=0;i--){//must from back , then can confirm only one bit change , 

            res.add(num | tmp.get(i)); //since tmp is graycode, [00,01,10,11]+ num is also gray code
        }


        return res;
    }
}
