import java.util.Arrays;
import java.util.Random;

// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class Shuffling {
//    random shuffling
//    Knuth shuffle
    private static int swaps = 0;

    public static final Random gen = new Random();
    
    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shuffling(Comparable[] a) {
    	swaps = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
        //min and max
        	/*range = max - min + 1
            int rand = (int)(Math.random() * range) + min;

            // choose index uniformly in [0, i]
            // or choose index uniformly in [i, n-1]
//            swap(a, i, r);
//            count the number of swaps
        	int r = Shuffling.uniform(i + 1);
        	swap(a, i, r);*/
        	while (n > 1) {
        		int k = gen.nextInt(n--);
        		Comparable temp = a[n];
        		a[n] = a[k];
        		a[k] = temp;
        		swaps++;
        		
        	}
        }
        System.out.println(swaps + " shuffling swaps");
        System.out.println("SHUFFLED: " + Arrays.toString(a));
    }
        
}



