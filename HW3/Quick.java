// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class Quick {
	private static int swaps = 0;
	
	private static int partition(Comparable[] a, int low, int high) {

		Comparable pivot = a[high];
		int i = (low-1);
		for (int j=low; j<high; j++) {
			if (a[j].compareTo(pivot) < 0) {
				i++;
				Comparable temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				//swaps++;
			}
			swaps++;
		}
		
		Comparable temp = a[i+1];
		a[i+1] = a[high];
		a[high] = temp;

		return i + 1;
	}
	
	
	
	public static void sort(Comparable[] a) {
		//Shuffling.shuffle(a);
		sort(a, 0, a.length - 1);
		System.out.println(swaps + " swaps");
	}
	/*
	private static void sort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}*/
	private static void sort(Comparable[] a, int low, int high) {
		if (high <= low) {
			return;
		}
		int j = partition(a, low, high);
		sort(a, low, j-1);
		sort(a, j+1, high);
		
	}
	
	public static void shuffling(Comparable[] a) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
