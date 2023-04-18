// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.


import java.util.Arrays;

public class MyTest {
	
    public static void main(String[] args) {
        //    test names
        //    generate an array of first names
        
    	Firstnames[] names = new Firstnames[10];
        for (int i = 0; i < names.length; i++){
            names[i] = new Firstnames();
        }

        Dates[] dates = new Dates[10];
        for (int i = 0; i < dates.length; i++){
            dates[i] = new Dates();
        }
                     
        System.out.println("Selection sort: names");
        System.out.println(Arrays.toString(names));
        long start4 = System.nanoTime();
        Selection.sort(names);
        long end4 = System.nanoTime();
        long wallClockTime4 = end4 - start4;
        //1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime4/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(names));
        Shuffling.shuffling(names);


        System.out.println("\nSelection sort: dates");
        System.out.println(Arrays.toString(dates));
        long start5 = System.nanoTime();
        Selection.sort(dates);
        long end5 = System.nanoTime();
        long wallClockTime5 = end5 - start5;
//        1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime5/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(dates));
        Shuffling.shuffling(dates);    
        //Selection.sort(dates);
                
        //////////////////////////////////////////////////////////////////////////////////////////////////

        
        
        System.out.println("\n/////////////////////////////////////////////////////////////////////");
        
        System.out.println("Insertion sort: names");
        System.out.println(Arrays.toString(names));
        long start2 = System.nanoTime();
        Insertion.sort(names);
        long end2 = System.nanoTime();
        long wallClockTime2 = end2 - start2;
        //1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime2/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(names));
        Shuffling.shuffling(names);

        System.out.println("\nInsertion sort: dates");
        System.out.println(Arrays.toString(dates));
        long start3 = System.nanoTime();
        Insertion.sort(dates);
        long end3 = System.nanoTime();
        long wallClockTime3 = end3 - start3;
//        1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime3/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(dates));
        Shuffling.shuffling(dates);
        //System.out.println(Arrays.toString(dates));
        //Insertion.sort(dates);
        //System.out.println(Arrays.toString(dates));
        
        //////////////////////////////////////////////////////////////////////////////////   
        
        System.out.println("\n////////////////////////////////////////////////////////////////////");
        
        System.out.println("Bubble sort: names");
        System.out.println(Arrays.toString(names));
        long start = System.nanoTime();
        Bubble.sort(names);
        long end = System.nanoTime();
        long wallClockTime = end - start;
        //1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(names));
        Shuffling.shuffling(names);
        
        System.out.println("\nBubble sort: dates");
        System.out.println(Arrays.toString(dates));
        long start1 = System.nanoTime();
        Bubble.sort(dates);
        long end1 = System.nanoTime();
        long wallClockTime1 = end1 - start1;
//        1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime1/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(dates));
        Shuffling.shuffling(dates);
        //System.out.println("SHUFFLED: " + Arrays.toString(dates));
        //Bubble.sort(dates);
        //System.out.println(Arrays.toString(dates));
         

        
        //////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n////////////////////////////////////////////////////////////////////");
        
        System.out.println("Shuffling sort: names");
        System.out.println(Arrays.toString(names));
        long start10 = System.nanoTime();
        Shuffling.shuffling(names);
        long end10 = System.nanoTime();
        long wallClockTime10 = end10 - start10;
        //1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime10/Math.pow(10, 9) + "seconds");
        System.out.println("RANDOMLY SHUFFLED: " + Arrays.toString(names));
        Shuffling.shuffling(names);     
        
        
        System.out.println("\nShuffling sort: dates");
        System.out.println(Arrays.toString(dates));
        long start11 = System.nanoTime();
        Shuffling.shuffling(dates);
        long end11 = System.nanoTime();
        long wallClockTime11 = end11 - start11;
//        1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        
        System.out.println(wallClockTime11/Math.pow(10, 9) + "seconds");
        System.out.println("RANDOMLY SHUFFLED: " + Arrays.toString(dates));
        Shuffling.shuffling(dates);
        
        //////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n////////////////////////////////////////////////////////////////////");
        
        System.out.println("Merge sort: names");
        System.out.println(Arrays.toString(names));
        long start6 = System.nanoTime();
        Merge.sort(names);
        long end6 = System.nanoTime();
        long wallClockTime6 = end6 - start6;
        //1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime6/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(names));
        Shuffling.shuffling(names);


        System.out.println("\nMerge sort: dates");
        System.out.println(Arrays.toString(dates));
        long start7 = System.nanoTime();
        Merge.sort(dates);
        long end7 = System.nanoTime();
        long wallClockTime7 = end7 - start7;
//        1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime7/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(dates));
        Shuffling.shuffling(dates);
        //Selection.sort(dates);
        
        /////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n////////////////////////////////////////////////////////////////////");
        
        System.out.println("Quick sort: names");
        System.out.println(Arrays.toString(names));
        long start8 = System.nanoTime();
        Quick.sort(names);
        long end8 = System.nanoTime();
        long wallClockTime8 = end8 - start8;
        //1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime8/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(names));
        Shuffling.shuffling(names);


        System.out.println("\nQuick sort: dates");
        System.out.println(Arrays.toString(dates));
        long start9 = System.nanoTime();
        Quick.sort(dates);
        long end9 = System.nanoTime();
        long wallClockTime9 = end9 - start9;
//        1 second = 1_000_000_000 nanosecond (10^9 : Math.pow(10, 9))
        System.out.println(wallClockTime9/Math.pow(10, 9) + "seconds");
        System.out.println("SORTED: " + Arrays.toString(dates));
        Shuffling.shuffling(dates);
        //Selection.sort(dates);
        
    }
}