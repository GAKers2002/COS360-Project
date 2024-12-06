import java.util.ArrayList;
import java.util.Scanner;
public class Calculator {
	public static void main(String[] args) {
		// Take in user input
		String equation = UserInput();
		ArrayList<String> subEqs = parseInput(equation);
		double result = sortOp(subEqs);
		System.out.println(result);
		//Continue or quit
		String quit = "N";
		while(quit.equals("N")) {
			String x = promptUser();
			//Quit
			if(x.equals("Y")) {
				quit = x;
			}
			else {
				//Repeat
				String equation1 = UserInput();
				ArrayList<String> subEqs1 = parseInput(equation1);
				double result1 = sortOp(subEqs1);
				System.out.println(result1);
			}
		}	
	}
	
	//Takes in user input with scanner and returns String of input
	public static String UserInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an equation: ");
		String equation = input.nextLine();
		return equation;
	}
	
	public static String promptUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Quit (Y/N): ");
		String ans = input.nextLine();
		return ans;
	}
	
	/*
	 * Take in String equation and return arraylist of all subequations
	 * @param equation
	 * @return subEqs
	 */
	public static ArrayList<String> parseInput(String equation) {
		//Array of Strings made up from equation
		ArrayList<String> subEqs = new ArrayList<String>();
		String temp = "";
		// Declare operators
		char[] chars = {'(',')'};
		//Iterate through chars to see if there are parenthesis
		for(int i = 0; i < equation.length(); i++) {
			if(equation.charAt(i) == chars[0]){
				i++;
				//Adds all values until parenthesis to temp
				while(equation.charAt(i) != chars[1]) {
					temp += equation.charAt(i);
					i++;
				}
				subEqs.add(temp);
			}
			else {
				while(i < equation.length()) {
					temp += equation.charAt(i);
					if (i == equation.length() - 1) {
						subEqs.add(temp);
					}
					i++;
				}
			}
			//reset temp variable
			temp = "";
		}
		return subEqs;
	}
	
	//Perform operations and append to arraylist of values
	public static double sortOp(ArrayList<String> subEqs) {
		//Declare operations
		char[] ops = {'+','-','*','/','%'};
		double temp = 0;
		ArrayList<Double> results = new ArrayList<Double>();
		double ans = 0.0;
		//Iterate through sub equations in subEqs
		for (int i = 0; i < subEqs.size(); i++) {
			String eq = subEqs.get(i);
			//Iterate through chars in string
			for (int j = 0; j < eq.length(); j++) {
				double result = 0.0;
				//check if adding
				if (eq.charAt(j) == ops[0]) {
					result = temp + Character.getNumericValue(eq.charAt(j+1));
					results.add(result);
					temp = result;
					j++;
				}
				//check if subtracting
				else if (eq.charAt(j) == ops[1]) {
					result = temp - Character.getNumericValue(eq.charAt(j+1));
					results.add(result);
					temp = result;
					j++;
				}
				//check if multiplying
				else if (eq.charAt(j) == ops[2]) {
					result = temp * Character.getNumericValue(eq.charAt(j+1));
					results.add(result);
					temp = result;
					j++;
				}
				//check if dividing
				else if (eq.charAt(j) == ops[3]) {
					result = temp / Character.getNumericValue(eq.charAt(j+1));
					results.add(result);
					temp = result;
					j++;
				}
				//check if mod
				else if (eq.charAt(j) == ops [4]) {
					result = temp % Character.getNumericValue(eq.charAt(j+1));
					results.add(result);
					temp = result;
					j++;
				}
				//Assign temp a value
				else {
					temp = Character.getNumericValue(eq.charAt(j));
				}
			}
		}			
		return temp;
	}
}