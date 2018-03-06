import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author rileyp
 *
 */
public class ExpressionTreesTest {
	/**
	 * 
	 * This gets the list of all the file names in the main text file
	 * 
	 * @param args arguments given for program in runtime
	 * @return ArrayList of the file names within the given main file
	 */
	public static ArrayList<String> getExpressions(String[] args) {
		String fileName = "";
		Scanner keyboard = new Scanner(System.in);
		
		//If given arg, use that. Otherwise, ask for it
		if (args.length == 1)
			fileName = args[0].trim();
		else {
			fileName =  "postFixExpressions.txt";
		}

		Scanner allExpressions = null;
		//Scanner based on given file name
		try {
			allExpressions = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.print("\nEnter input file name: ");
			fileName = keyboard.nextLine().trim();
			try {
				allExpressions = new Scanner(new File(fileName));
			} catch (FileNotFoundException ex) {
				System.out.println("File not Found!");
				System.exit(1);
			}
		}
		
		//Create list of file names in txt file
		ArrayList<String> expressions = new ArrayList<String>();

		while (allExpressions.hasNextLine()) {
			expressions.add(allExpressions.nextLine().trim());
		}
		
		//closes up scanners
		keyboard.close();
		allExpressions.close();
		
		return expressions;
	}
	
	public static void printFormat(PrintWriter out, ExpressionTrees tr, String ex){
		out.println("The tree equals: " + tr.evalTree());
		out.println("Prefix Notation: " + tr.toPrefixNotation());
		out.println("Infix Notation: " + tr.toInfixNotation());
		out.println("Postfix Notation: " + tr.toPostfixNotation());
		out.println("postFixEval(): " + tr.postfixEval(tr.processInput(ex)));
		out.println();
		out.println();
	}
	
	public static void main(String[] args) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File("myAnswers.txt"));
		} catch (Exception e) {
			System.out.println("Output file Error!");
			System.exit(1);
		}
		
		ArrayList<String> expr = getExpressions(args);
		
		for(String ex : expr){
			ExpressionTrees tr = new ExpressionTrees(ex);
			printFormat(out,tr,ex);
		}
		
		
		/***********OLD TESTS**********/
		/*
		//String[] exp = new String[] { "2", "4", "+" };
		String expr1 = "2 4 +";
		String expr2 = "4 2 3 5 1 + + * + ";
		ExpressionTrees n = new ExpressionTrees(expr2);
		System.out.println("The tree equals: " + n.evalTree());
		System.out.println("Prefix Notation: " + n.toPrefixNotation());
		System.out.println("Postfix Notation: " + n.toPostfixNotation());
		System.out.println("Infix Notation: " + n.toInfixNotation());
	*/
	}

}
