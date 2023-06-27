package CoreJava;

public class CustomOperators {
    public static void main(String[] args) {
        int a = 2;
        increament(++a);
        System.out.println("outside "+a);

        increament2(2);
        //System.out.println("outside "+a);
    }


    public static void increament(int a){
        while(++a<=5){
            System.out.println(a);
        }
    }
    public static void increament2(int a){
        if(a>5)
            return;

        increament2(++a);
        System.out.println(" 2: "+a);
    }
}
