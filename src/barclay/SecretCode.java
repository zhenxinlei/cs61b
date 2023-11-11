package barclay;

public class SecretCode {
    public static void main(String[] args) {
        int s = 2;
        int n = 1000000007;
        int m = 4;

//
//        int sl = s%10;
//        int nl = n%4;
//
//        System.out.println( sl+" " +nl);
//
//       long answer= (long)  Math.pow(sl , nl)%10 ;
//       int ml =  m%4;
//         answer= (long)  Math.pow(answer , m)%1000000007 ;


        int answer = 0;
        answer = (int) Math.pow((long)Math.pow(s,n)%10,(long)m)%1000000007;
        System.out.println( answer+" " +(int )answer);
    }
}
