package Algorithm.leetcode;

/**
 * leetcode #1758
 * change '0','1' only string to no two adjacent char are equal
 *
 * example:
 *    0100 -> 0101  return 1 (step)
 *    01 -> 01 return 0
 *    1111 -> 0101 or 1010 return 2 (steps)
 *
 *
 * thought:
 *    iter string if cur pointing char is same flip it
 *
 */
public class MiniChangesToMakeAlterBinaryString {

    public static void main(String[] args) {
        System.out.println(solution("0100"));
    }


    public static int solution(String str ){

        int result =0;

        if (str.length()<=1)
            return 0;

        for (int i =0 ; i <str.length();i++){
            if (  str.charAt(i)-'0' != i%2){ //compare 01010101....0101, the other way to flip must be len()-result
                result++;
            }
        }



        return Math.min(result,str.length()-result);
    }
}
