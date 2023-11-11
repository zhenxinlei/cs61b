package MorganStanley;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.String;

public class SortingDates {
    enum MONTH{
        Jan("Jan", 1),
        Feb("Feb", 2),
        Mar("Mar", 3),
        Apr("Apr", 4),
        May("May", 5),
        Jun("Jun", 6),
        Jul("Jul", 7),
        Aug("Aug", 8),
        Sep("Sep", 9),
        Oct("Oct", 10),
        Nov("Nov", 11),
        Dec("Dec", 12);

        String m_mon;
        int m_val;
        MONTH(String mon, int v){
            m_mon = mon;
            m_val = v;
        }

        public static MONTH getEnum(String mon) {
            MONTH[] e = values();
            for(MONTH m: values()){
                if(m.m_mon.equals(mon))
                    return m;
            }
            return null;
        }
    }

    public static String[] solution(String[] dates){
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1==o2)
                    return 0;
                if(o1==null)
                    return -1;
                if(o2==null)
                    return 1;

                String[] date1= o1.split(" ");
                String[] date2= o2.split(" ");

                int res = Integer.valueOf( date1[2]).compareTo(Integer.valueOf(date2[2]));
                if(res!=0)
                    return res;

                res =  MONTH.getEnum(date1[1]).m_val-MONTH.getEnum( date2[1]).m_val;
                if(res!=0)
                    return res;

                res = Integer.valueOf(date1[0]).compareTo(Integer.valueOf( date2[0]));
                return res;
            }
        };


        Arrays.sort(dates,comparator);

        return dates;
    }

    public static void main(String[] args) {
        String[] dates = {"01 Feb 2017", "01 Jan 2017", "02 Jan 2016","02 Jan 2016"};
        solution(dates);
        System.out.println(Arrays.toString(dates));

    }


}
