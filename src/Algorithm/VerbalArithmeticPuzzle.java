package Algorithm;

import java.util.HashMap;

/*
    leetcode 1307 https://leetcode.com/problems/verbal-arithmetic-puzzle/

 */
public class VerbalArithmeticPuzzle {

    HashMap<Character, Integer> c2i = new HashMap<>();
    HashMap<Integer, Character> i2c = new HashMap<>();

    public static void main(String[] args) {
        VerbalArithmeticPuzzle p = new VerbalArithmeticPuzzle();

        String[] words = new String[]{"SEND", "MORE"};
        String result = "MONEY";
        boolean res = p.solution(words, result);

        System.out.println("Res "+res);
    }

    public boolean solution(String[] words, String result){

        for(int i =0; i < words.length; i ++){
            if(words[i].length()>result.length())
                return false;
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        result = new StringBuilder(result).reverse().toString();

        return helper(words, result, 0,0 ,0);
    }

    public boolean helper(String[] words, String result, int digit, int wIdx, int sum){
        int resLen = result.length();
        if (digit==resLen)
            return sum ==0;

        //if summation of the position digit complete, validate the reuslt at position digit
        if( wIdx== words.length){
            if(!c2i.containsKey(result.charAt(digit)) && !i2c.containsKey(sum%10)){ //result digit not mapped, sum remainder not mapped
                if(sum%10==0 && digit+1 == resLen) // avoid leading zero ??
                    return false;

                c2i.put(result.charAt(digit), sum%10);
                i2c.put(sum%10, result.charAt(digit));
                //digit + 1 , 下一位； sum /10 ： 进十，
                boolean tmp = helper(words, result, digit+1 , 0, sum/10);
                c2i.remove(result.charAt(digit));
                i2c.remove(sum%10);
                return tmp;
            } else if( c2i.containsKey(result.charAt(digit)) && c2i.get(result.charAt(digit)) == sum%10){ //already mapped, and sum is valid
                if(digit+1 == resLen && c2i.get(result.charAt(digit)).intValue()==0){ //avoid leading zero
                    return false;
                }
                return  helper(words, result, digit+1 , 0, sum/10);
            } else
                return false;

        }

        //igore if digit >= word[wIdx] length, move to next word
        if( digit>= words[wIdx].length())
            return helper(words, result, digit, wIdx+1, sum);

        //already mapped
        if(c2i.containsKey(words[wIdx].charAt(digit))){
            if(digit+1 == words[wIdx].length() && words[wIdx].length()>1 && c2i.get(words[wIdx].charAt(digit)).intValue()==0) //has leading zero
                return  false;
            return helper(words,result, digit, wIdx+1, sum + c2i.get(words[wIdx].charAt(digit)).intValue()); //update cur sum , and move to next word
        }

        //char not mapped yet
        //try every combination
        for(int i =0 ; i<10;i++){
            if( digit+1 == words[wIdx].length() && i==0 && words[wIdx].length()>1) //
                continue;
            if(i2c.containsKey(i)) //already mapped char and int
                continue;

            //map c2i , i2c
            c2i.put(words[wIdx].charAt(digit), i);
            i2c.put(i,words[wIdx].charAt(digit) );

            //digit wont change , since we calculate/map the same digit poition of next word
            // E       R O M
            // D       N E S
            // digit
            boolean tmp =  helper(words, result, digit, wIdx+1, sum+i);
            c2i.remove(words[wIdx].charAt(digit));
            i2c.remove(i);

            if(tmp)
                return true;

        }

        return false;
    }

}
