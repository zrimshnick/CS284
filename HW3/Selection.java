import java.util.Arrays;

// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class Selection {
	private static int swaps = 0;
	
    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swaps++;
    }
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		//swaps = 0;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (a[j].compareTo(a[min]) < 0) {
					min = j;
				}

			}				
			swap(a, i, min);
			//System.out.println(Arrays.toString(a)+ (swaps));
			
			
		}
		System.out.println(swaps-1 + " swaps");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
