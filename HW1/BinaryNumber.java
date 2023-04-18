package BinaryNumber;
/*
 * Homework 1 - Binary Numbers
 * Zack Rimshnick
 * CS 284 D
 * I pledge my honor that I have abided by the Stevens Honor System. 
*/
public class BinaryNumber {

	private int data[];
	private int length;
	
	// constructor for creating a binary number of length 'length' and consisting only of 0s
	public BinaryNumber(int length) throws Exception {
		//this.length = length;
		//this.data = new int[length];
		// ADD EXCEPTION HERE
		if(length < 0 || length == 0) {
			throw new Exception("Length invalid");
		}
		int[] temparray = new int[length];
		for(int i = 0; i < length; i++) {
			temparray[i] = 0;
		}
		this.length = length;
		this.data = temparray;
	}
	
	// constructor for creating a binary number given a string
	//// char java.lang.String.charAt(int index) returns the char value at index
	//// int java.land.Character.getNumericValue(char ch) returns the int value that the specified unicode character gets
	public BinaryNumber(String str) throws Exception {	
		int strlength = str.length();
		int[] newarray = new int[strlength];
		for (int i = 0; i < strlength; i++) {
			char x = str.charAt(i);
			int a = java.lang.Character.getNumericValue(x);
			if (a != 0 && a != 1) {
				throw new Exception("Number must be 1 or 0");
			}			
			newarray[i] = a;
		}
		this.length = strlength;
		this.data = newarray;
	}
	
	// operation for determining the length of a binary number.
	public int getLength() {
		return data.length;
	}
	
	// operation that returns the integer array representing the binary number
	public int[] getInnerArray() {
		return this.data;
	}
	
	// operation for obtaining a digit of a binary number given index
	/// if index is out of bounds, a message should be printed on screen
	public int getDigit(int index) {
		if(index >= data.length) {
			throw new ArrayIndexOutOfBoundsException("Index is invalid");
		}
		return data[index];
	}
	
	// operation for transforming a binary number into its decimal notation
	public int toDecimal() {
		int decimal = 0;
		for (int i = 1; i <= data.length; i++) {
			if(data[i-1] == 1) {
				decimal += Math.pow(2, data.length-i);
			}
		}
		return decimal;
		/*int decimal = 0;
		for(int i = 1; i < data.length; i++) {
			decimal += data[i] * (int)Math.pow(2, data.length - i);
		}
		return decimal;*/
	}
	
	// operation for shifting all digits left or right
		/// direction -1=left, 1=right
		public void bitShift(int direction, int amount) throws Exception {
			if(direction != 1 && direction != -1) {
				throw new IllegalArgumentException("The direction must be -1 or 1 for left or right");
			}
			if(amount < 0) {
				throw new IllegalArgumentException("The amount must be a positive number");
			}
			// RIGHT SHIFT
			if (direction == 1) {
				if (amount > data.length) {
					throw new IndexOutOfBoundsException("The amount must be less than or equal to the length");
				} else {
				int[] shiftarray = new int[data.length - amount];
				//int z = 0;
				for (int i = 0; i < shiftarray.length; i++) {
					shiftarray[i] = data[i];
				}
				data = shiftarray;
			}
			}
			// LEFT SHIFT
			else if (direction == -1) {
				int[] shiftarray = new int[data.length + amount];
				for (int i = 0; i < shiftarray.length; i++) {
					if(i < data.length) {
						shiftarray[i] = data[i];
					} else {
						shiftarray[i] = 0;
					}
				}
				data = shiftarray;
			}
		}
	
	// operation that computes the bitwise or of the two numbers
	/// both must be same length
	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.data.length != bn2.data.length) {
			throw new IllegalArgumentException("The two binary numbers need to have the same lengths");
		}
		int[] bworArray = new int[bn1.data.length];
		for (int i = 0; i < bn1.data.length; i++) {
			if (bn1.getDigit(i) == 1 || bn2.getDigit(i) == 1) {
				bworArray[i] = 1;
			} else {
				bworArray[i] = 0;
			}
		} return bworArray;
	} 
	
	// operation that computes the bitwise and of the two numbers
	/// both must be same length
	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.data.length != bn2.data.length) {
			throw new IllegalArgumentException("The two binary numbers need to have the same length");
		}
		int[] bwandArray = new int[bn1.data.length];
		for (int i = 0; i < bn1.data.length; i++) {
			if (bn1.getDigit(i) == 1 && bn2.getDigit(i) == 1) {
				bwandArray[i] = 1;
			} else {
				bwandArray[i] = 0;
			}
		} return bwandArray;
	}
	
	// operation that returns the binary number as the corresponding encoded string
	public String toString() {
		String str = "";
		for (int i = 0; i < data.length; i++) {
			str += this.data[i];
		}
		return str;
	}
	
	public void prepend(int amount) {
		int[] prependArray = new int[amount + data.length];
		for (int i = 0; i < amount; i++) {
			prependArray[i] = 0;
		}
		for (int i = 0; i < data.length; i++) {
			prependArray[i + amount] = data[i];
		}
		data = prependArray;
	}
		
	// adding two binary numbers
	/// if lengths not =, then add 0s to beginning of smaller one
	public void add(BinaryNumber aBinaryNumber) {
		if (this.length > aBinaryNumber.getLength()) {
			aBinaryNumber.prepend(data.length - aBinaryNumber.getLength());
		} else if (this.length < aBinaryNumber.getLength()) {
			prepend(aBinaryNumber.getLength() - data.length);
		}
		int[] addingArray = new int[data.length];
		int carry = 0;
		for (int i = data.length - 1; i > -1; i--) {
			int digitsAndCarry = this.data[i] + aBinaryNumber.getDigit(i) + carry;
			if (digitsAndCarry == 0) {
				addingArray[i] = 0;
				carry = 0;
			} else if (digitsAndCarry == 1) {
				addingArray[i] = 1;
				carry = 0;
			} else if (digitsAndCarry == 2) {
				addingArray[i] = 0;
				carry = 1;
			} else if (digitsAndCarry == 3) {
				addingArray[i] = 1;
				carry = 1;
			}
		}
		this.data = addingArray;
		this.length = addingArray.length;
		if (carry == 1) {
			this.prepend(1);
			this.data[0] = 1;
			this.length += 1;
		}
	}

	public static void main(String[] args) throws Exception{
	}
}


