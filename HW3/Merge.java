import java.util.Arrays;

// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class Merge {
	private static int swaps = 0;
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			}
			else if (j > hi) {
				a[k] = aux[i++];
			}
			else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];
			}
			else {
				a[k] = aux[i++];
			}
			//System.out.println(Arrays.toString(a) + "tracking");
			
		} swaps++;
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1);
		System.out.println(swaps + " swaps");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
