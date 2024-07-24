package Algorithm;

/**
 * <HFQ>AMAZON</HFQ>
 *
 */
public class SubstringWithLargestVariance {
    public static void main(String[] args) {
        largestVariance("aababbb");
    }

    public static int largestVariance(String s) {

        int [] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i++)
            freq[(int)(s.charAt(i) - 'a')]++;

        int maxVariance = 0;
        for(int a = 0 ; a < 26 ; a++){
            for(int b = 0 ; b < 26 ; b++){
                int remainingA = freq[a];
                int remainingB = freq[b];
                if(a == b || remainingA == 0 || remainingB == 0) continue;

                // run kadanes on each possible character pairs (A & B)
                int currBFreq = 0, currAFreq = 0;
                for(int i = 0 ; i < s.length() ; i++){
                    int c =  (int)(s.charAt(i) - 'a');

                    if(c == b) currBFreq++;
                    if(c == a) {
                        currAFreq++;
                        remainingA--;
                    }

                    if(currAFreq > 0) //make sure two char presented 
                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);

                    if(currBFreq < currAFreq &&  remainingA >= 1){
                        currBFreq = 0;
                        currAFreq = 0;
                    }
                }
            }
        }

        return maxVariance;
    }

    public static int largestVariance2(String s) {
        int [] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i++)
            freq[(int)(s.charAt(i) - 'a')]++;

        int maxVariance = 0;
        for(int a = 0 ; a < 26 ; a++) {
            for (int b = 0; b < 26; b++) {

            }
        }
        return maxVariance;
    }
}
