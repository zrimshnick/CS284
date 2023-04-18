import java.util.Arrays;

// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class Insertion {
    private static int swaps = 0;
	
    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		swaps = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j].compareTo(a[j-1]) < 0) {
					swap(a, j, j-1);
					//System.out.println(Arrays.toString(a)+ (swaps+1));
					swaps++;}
			}
		}
        System.out.println(swaps + " swaps");
        //System.out.println(Arrays.toString(a));
	}
	
    public int getSwaps(){
        return this.swaps;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
