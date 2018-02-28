/**
 * 
 * @author rileyp
 *
 */
public class ExpressionTreesTest {

	public static void main(String[] args) {
		String[] exp = new String[] { "2", "4", "+" };
		String expr = "2 4 +";
		ExpressionTrees n = new ExpressionTrees(expr);
		System.out.println("The tree equals: " + n.evalTree());
		System.out.println("Prefix Notation: " + n.toPrefixNotation());
		System.out.println("Postfix Notation: " + n.toPostfixNotation());
		System.out.println("Infix Notation: " + n.toInfixNotation());
	}

}
