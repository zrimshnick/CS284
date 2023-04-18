// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates implements Comparable<Dates>{
    //private static char[] year;
	public String date;

    public Dates() {
    	
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            
        	int minYear = 1000;
        	int maxYear = 2022;
        	int randomYear = (int) (Math.random() * (maxYear-minYear+1) + minYear);
        	int minMonth = 1;
        	int maxMonth = 12;
        	int randomMonth = (int) (Math.random() * (maxMonth-minMonth+1) + minMonth);
        	int minDay = 1;
        	int maxDay = 28;
        	int randomDay = (int) (Math.random() * (maxDay-minDay+1) + minDay);
            
            calendar.set(randomYear, randomMonth, randomDay);
            date = format.format(calendar.getTime());
            //return date;
                   	       
    }
    
    //String date = date1;
           
    public String toString() {
        return this.date;
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public int compareTo(Dates that) {
        return this.date.compareTo(that.getDate());
        //if (this.getDate() == that.getDate()) return 0;
        //else if (this.getDate() > that.getDate()) return 1;
        //else return -1;
    	
    	//if (this.getDate() < that.getDate()) return -1;   	
    	
    }
           
    public static void main(String[] args) {
        //Dates a = new Dates();              
    	//System.out.println(a.getDate());      
    }

	@Override
	public int compareTo(Firstnames that) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}


/*
    	//System.out.println("ran");
    	
//        randomly generate a year, month and day
//        range of year: [1000, 2022]
//        range of month: [1, 12] ([0, 11] for calendar)
        //int year = calendar.get(Calendar.YEAR);
        //int month = calendar.get(Calendar.MONTH);
        //int day = calendar.get(Calendar.DAY_OF_MONTH);
        
        //SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        //Calendar calendar = Calendar.getInstance();
//        randomly generate a year, month and day
        //int minYear = -1022;
        //int maxYear = 0;
        //int minMonth =
         * 
         */
/*if ((randomYear % 4 == 0) && (randomYear % 100 != 0)) {
	if (randomMonth == 2) {
		maxDay = 29;
		//System.out.println(maxDay);
	}
}
    
if ((randomMonth < 10) && (randomDay > 9)) {
	String date = "" + randomYear + "0" + randomMonth + randomDay;
	//System.out.println(result);  
	return date1;
} 
else if ((randomMonth < 10) && (randomDay < 10)) {
	String date = "" + randomYear + "0" + randomMonth + "0" + randomDay;
	//System.out.println(result);
	return date1;} 
else if ((randomMonth > 9) && (randomDay < 10)) {
	String date = ""	+ randomYear + randomMonth + "0" + randomDay;
	//System.out.println(result);
	return date1;}
else {
	String date = "" + randomYear + randomMonth + randomDay;
	//System.out.println(result);
	return date1;}*/

//SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//Calendar calendar = Calendar.getInstance();


////


//range of year: [1000, 2022]
//range of month: [1, 12] ([0, 11] for calendar)
//int year = calendar.get(Calendar.YEAR);
//int month = calendar.get(Calendar.MONTH) + 1;
//int day = calendar.get(Calendar.DAY_OF_MONTH);
