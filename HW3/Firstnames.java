import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class Firstnames implements Comparable<Firstnames>{
	
	String name;
	
	public Firstnames() {
	
		int min = 100;
		int max = 200;
		int range = 200 - 100 + 1;
		int year = (int) (Math.random() * (200 - 100 + 1) + 100);
	
		StringBuilder s = new StringBuilder();
		//  [100, 200]
		int rand = (int)(Math.random() * range) + min;
		for (int i = 0; i < 10; i++) {
			int a1 = (int) (Math.random() * (200 - 100 + 1) + 100);
			// Output is different everytime this code is executed
			s.append(a1);
			s.append(" ");
			//System.out.println(s);
		}

		char A1 = 'A';
		//System.out.println((int) (A1));
		char Z = 'Z';
		//System.out.println((int) (Z));
		//System.out.println((char) (int) (Z));
		StringBuilder n = new StringBuilder();

		char FirstLetter = (char) ((int) (Math.random() * (90 - 65 + 1)) + 65);
		n.append(FirstLetter);
		for (int i = 0; i <= 5; i++) {
			n.append((char) ((int) (Math.random() * (122 - 97 + 1)) + 97));
		}
		name = n.toString();
		//System.out.println(name);
		//return name;

	}
	
	public String toString() {
		return this.name;
	}
    public String getName() {
        return this.name;
    }
	
	@Override
	public int compareTo(Firstnames that) {
	    return this.getName().compareTo(that.getName()); 	   	
	}
	
	public static void main(String[] args) {
		Firstnames a = new Firstnames();
		//System.out.println(a.getName());  
	}

	@Override
	public int compareTo(Dates that) {
		// TODO Auto-generated method stub
		return 0;
	}


}
