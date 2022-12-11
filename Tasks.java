import java.util.*;
import java.util.stream.*;


//Main class
public class Tasks {
	public static void main(String[] args) {
		System.out.println("Enter the task number: ");
		String input = System.console().readLine();
		try {
		switch(input) {
			case "1":
				System.out.println(solutions(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2])));
				return;
			case "2":
				System.out.println(findZip(args[0]));
				return;
			case "3":
				System.out.println(checkPerfect(Integer.parseInt(args[0])));
				return;
			case "4":
				System.out.println(flipEndChars(args[0]));
				return;
			case "5":
				System.out.println(isValidHexCode(args[0]));
				return;
			case "6":
				int[] array1 = {1, 3, 4, 4, 4}; int[] array2 = {2, 5, 7};
				//int[] array1 = {9, 8, 7, 6}; int[] array2 = {4, 4, 3, 1};
				//int[] array1 = {2}; int[] array2 = {3, 3, 3, 3, 3};
				System.out.println(same(array1, array2));
				return;
			case "7":
				System.out.println(isKaprekar(Integer.parseInt(args[0])));
				return;
			case "8":
				System.out.println(longestZero(args[0]));
				return;
			case "9":
				System.out.println(nextPrime(Integer.parseInt(args[0])));
				return;
			case "10":
				System.out.println(rightTriangle(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2])));
				return;
			default:
				System.out.println("[ERROR] Input does not match a task number.");
		}
		} catch(Exception err) {
			System.out.println("An error has occured. Check what you're inputting as arguments. Error follows: ");
			System.out.println(err);
		}
	}
	
	//Figures out how many solutions does a quadratic equation have.
	public static int solutions(int a, int b, int c) {
		int D = b*b-4*a*c;
		if(D > 0) return 2;
		else if (D == 0) return 1;
		return 0;
	}
	
	//Finds second substring "zip" in a string
	public static int findZip(String s) {
		String temp[] = s.split("zip");
		String temp2 = s.replace("zip", "");
		if((s.length() - temp2.length()) / 3 > 1) {
			if(temp.length > 1) {
				return temp[0].length()+temp[1].length()+3;
			} else {
				return temp[0].length()+3;
			}
		}
		return -1;
	}
	
	//Checks if the number is perfect
	public static boolean checkPerfect(int n) {
		int sum = 0;
		for(int i = 2; i*i <= n; i++) {
			if(n%i == 0) {
				sum += i;
				sum += n/i;
			}
		}
		if(sum+1 == n || n == 0) {
			return true;
		}
		return false;
	}
	
	//Flips ends of the string around.
	public static String flipEndChars(String s) {
		if(s.length() < 2) return "Несовместимо.";
		if(s.charAt(0) == s.charAt(s.length()-1)) return "два-это пара.";
		return s.charAt(s.length()-1) + s.substring(1,s.length()-1) + s.charAt(0);
	}
	
	//Checks a for valid hex number
	public static boolean isValidHexCode(String num) {
		if(num.length() != 7) return false;
		for(int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			if(i == 0) {if(c != '#') return false;}
			else if(!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F')) {
				return false;
			}
		}
		return true;
	}
	
	//Checks if arrays contain the same number of unique elements
	public static boolean same(int[] arr1, int[] arr2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i : arr1) {
			if (!list1.contains(i)) {
				list1.add(i);
			}
		}
		for (int i : arr2) {
			if (!list2.contains(i)) {
				list2.add(i);
			}
		}
		return list1.size() == list2.size();
	}
	
	//Checks if a number is a Kaprekar number
	public static boolean isKaprekar(int x) {
		String s = Integer.toString(x*x);
		if(s.length() == 1) {
			return Integer.parseInt(s) == x;
		}
		return Integer.parseInt(s.substring(0, s.length()/2))+Integer.parseInt(s.substring(s.length()/2, s.length())) == x;
	}
	
	//Finds longest zero series
	public static String longestZero(String s) {
		char[] carr = s.toCharArray();
		int max = 0;
		int curr = 0;
		for(char c : carr) {
			if(c == '0') {
				curr++;
			} else {
				if(curr > max) {
					max = curr;
				}
				curr = 0;
			}
		}
		if(curr > max) {
			max = curr;
		}
		String temp = "";
		for(int i = 0; i < max; i++) {
			temp += '0';
		}
		return temp;
	}
	
	
	//Searches for next prime
	public static int nextPrime(int n) {
		while(!isPrime(n)) {
			n++;
		}
		return n;
	}
	
	//Checks if a number is prime
	private static boolean isPrime(int x) {
		for(int i = 2; i*i <= x; i++) {
			if(x%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	//Checks if a triplet is pythagorean numbers
	public static boolean rightTriangle(int a, int b, int c) {
		int [] arr = {a,b,c};
		Arrays.sort(arr);
		a = arr[0];
		b = arr[1];
		c = arr[2];
		return a*a+b*b == c*c;
	}
	
	//Converts an array of string to an array of integers
	protected static int[] strArrToIntArr(String array[]) {
		int nums[] = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			nums[i] = Integer.parseInt(array[i]);
		}
		return nums;
	}
}

