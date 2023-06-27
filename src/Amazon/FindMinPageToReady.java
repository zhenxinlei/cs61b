package Amazon;

import java.util.Arrays;

/*
    n= 3 chapters
    pages = [2,4,3], pages in each chapter
    days =4, days to finish all pages and all chapters

    ans minPage =3 , read min 3 pages per day s.t. finish in 4 days

 */
public class FindMinPageToReady {
    public static void main(String[] args) {
        int  n = 3;
        int days = 4;
        int[] pages = new int[]{2,4,3};

        int res = solution(n,pages,days);
        System.out.println(" res1: "+res);

        res = solution(n,new int[]{2,4,4,15,17},6);
        System.out.println(" res2: "+res);
    }

    public static  int solution(int n , int[] pages , int days){
     /*1. days must greater than pages.length
        divide and con
        can assign 1 to days-i days to read chapter i
                    i
        [ X X X X | X]

        //edeg case atleaset 1 page per day
        for( avalibleDays  to (days-i)){
            minLocal  = findMin( i-1, days-avalibleDays)
            pageToFinish at i with avalibleDays

            min  = Math.min(min, Max( minLocal, pageToFinish at chapt i) .
        }



        * */

        //Arrays.sort(pages);
        int min = findMin(n, pages, pages.length-1, days);

        return min;
    }

    public static int findMin(int n , int[] pages , int index,  int days){

        int min = Integer.MAX_VALUE;
        int indexMaxDay = days-index;

        if(index<0 || indexMaxDay<=0)
            return min;

        if(index==0 && days>=1)
            return Math.max((int) Math.ceil( pages[0]/(double)days),1);//at least one Page perDay

        for (int i = 1;i<=indexMaxDay;i++){

            int minLocal = findMin(n,pages, index-1,days-i);
            int minPageToFinishIndexChapt = Math.max( (int) Math.ceil( pages[index]/(double)i), 1); //at least one Page perDay

            min = Math.min(min, Math.max(minLocal, minPageToFinishIndexChapt));
        }

        return min;
    }

}
