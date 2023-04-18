import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class Bubble {
    private static int swaps = 0;

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(Comparable[] a) {
    	swaps = 0;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j, j+1);
                    //System.out.println(Arrays.toString(a) + (swaps+1));
                    swaps++;
                }
            }
        }
        System.out.println(swaps + " swaps");
        //System.out.println(Arrays.toString(a));
    }

    public int getSwaps(){
        return this.swaps;
    }

    public static void main(String[] args) {

    	System.out.println("starting");
    	
    	Firstnames[] list = new Firstnames[7];
    	list[0] = new Firstnames();
    	list[1] = new Firstnames();
    	list[2] = new Firstnames();
    	list[3] = new Firstnames();
    	list[4] = new Firstnames();
    	list[5] = new Firstnames();
    	list[6] = new Firstnames();
    	System.out.println(Arrays.toString(list));
    	
    	//sort(list);
    	
    }
    
}
