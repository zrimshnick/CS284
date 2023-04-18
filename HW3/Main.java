import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        //str1.compareTo(str2)
        //str1 is smaller: return an integer less than 0  (<0)
        //equal: 0
        //str1 is greater: return an integer greater than 0 (>0)

        char a = 'h';
        //System.out.println((int) (a));
        char A = 'H';
        //System.out.println((int) (A));
        //String s1 = "hello";
        //String s2 = "Hello";
        String s1 = "e";
        String s2 = "c";

        System.out.println(s1.compareTo(s2));
        if (s1.compareTo(s2) < 0) {
        	System.out.println(1);
        	System.out.println("String 1 is smaller than ");
        } 
        else if (s1.compareTo(s2) > 0) {
        	System.out.println(-1);
        	System.out.println(0);
        }
        else {
        	System.out.println(0);
        	System.out.println(0);
        }




        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
////
        calendar.set(2012, 11, 10);
        String date1 = format.format(calendar.getTime());
        System.out.println(date1);
////
        calendar.set(2052, 9, 40);
        String date2 = format.format(calendar.getTime());
        System.out.println(date2);
//
//
        System.out.println(date1.compareTo(date2));


//         generate a random number with Math.random();
         int min = 100;
         int max = 200;
         int range = 200 - 100 + 1;
         int year = (int) (Math.random() * (200 - 100 + 1) + 100);



        StringBuilder s = new StringBuilder();
//        [100, 200]
        int rand = (int)(Math.random() * range) + min;
        for (int i = 0; i < 10; i++) {
            int a1 = (int) (Math.random() * (200 - 100 + 1) + 100);
            // Output is different everytime this code is executed
            s.append(a1);
            s.append(" ");
            System.out.println(s);
        }


        char A1 = 'A';
        System.out.println((int) (A1));
        char Z = 'Z';
        System.out.println((int) (Z));
        System.out.println((char) (int) (Z));
        StringBuilder n = new StringBuilder();

        char FirstLetter = (char) ((int) (Math.random() * (90 - 65 + 1)) + 65);
        n.append(FirstLetter);
        for (int i = 0; i <= 5; i++) {
            n.append((char) ((int) (Math.random() * (122 - 97 + 1)) + 97));
        }
        String name = n.toString();
        System.out.println(name);


        
        
    }

}