import java.util.Stack;

/**
 * <p></p> 
 * Feb 26, 2018
 * @author Patrick Riley
 */

/**
 * @author rileyp
 *
 */
public class ExpressionTrees extends TreeNode implements Expressions {

	/**
	 * 
	 * @param initValue
	 *            value of the root
	 * @param initLeft
	 *            node to the left
	 * @param initRight
	 *            node to the right
	 */
	public ExpressionTrees(Object initValue, TreeNode initLeft, TreeNode initRight) {
		super(initValue, initLeft, initRight);
	}
	
	public ExpressionTrees(String s) {
		super("");
		String[] exp = this.processInput(s);
		TreeNode n = buildTree(exp);
		this.setLeft(n.getLeft());
		this.setRight(n.getRight());
		this.setValue(n.getValue());
	}
	
	public ExpressionTrees(int i) {
		super(i);
	}
	
	@Override
	public TreeNode buildTree(String[] exp) {
		Stack<ExpressionTrees> s = new Stack<ExpressionTrees>();

		for (String o : exp) {
			try {
				int i = Integer.parseInt(o);
				s.push(new ExpressionTrees(i));
			} catch (NumberFormatException e) {
				ExpressionTrees r = new ExpressionTrees(o, s.pop(), s.pop());
				s.push(r);
			}
		}
		return s.pop();
	}

	@Override
	public int evalTree() {
		return recurEval(this);
	}

	private int recurEval(TreeNode r) {
		if (r == null)
			return 0;
		else {
			if (r.getLeft() == null && r.getRight() == null)
				return Integer.parseInt(r.getValue().toString());
			else {
				int left = recurEval(r.getLeft());
				int right = recurEval(r.getRight());
				
				if (r.getValue().equals("*"))
					return left * right;
				else
					if(r.getValue().equals("+"))
						return left + right;
					else
						if(r.getValue().equals("-"))
							return left - right;
						else
							if(r.getValue().equals("/")) {
								if(right == 0)
									throw new ArithmeticException();
								return left / right;
							}
							else
								return left % right;
			}
		}

	}

	@Override
	public String toPrefixNotation() {
		if (this.getLeft() != null || this.getRight() != null) {
			String ret = getValue().toString();
			String left = ((ExpressionTrees) this.getLeft()).toPrefixNotation();
			String right = ((ExpressionTrees) this.getRight()).toPrefixNotation();
			return ret + " " + left + " " + right + " ";
		} else
			return getValue().toString();

	}

	@Override
	public String toInfixNotation() {
		String s = toInfixUnfixed();
		return s.substring(1, s.length()-2);

	}
	
	/**
	 * This does infix notation, but does it with the exterior brackets
	 * @return String the infix notation with the outer ()
	 */
	private String toInfixUnfixed(){
		if (this.getLeft() != null || this.getRight() != null) {
			String ret = "( ";
			ret += ((String) ((ExpressionTrees) this.getLeft()).toInfixUnfixed()) + " ";
			ret += ((String) this.getValue()) + " ";
			ret += (String) ((ExpressionTrees) this.getRight()).toInfixUnfixed();
			return ret + " ) ";
		} else
			return getValue().toString();
	}

	@Override
	public String toPostfixNotation() {
		if (this.getLeft() != null || this.getRight() != null) {
			String left = ((ExpressionTrees) this.getLeft()).toPostfixNotation();
			String right = ((ExpressionTrees) this.getRight()).toPostfixNotation();
			return left + " " + right + " " +(String) this.getValue() + " ";
		} else
			return getValue().toString();
	}

	@Override
	public int postfixEval(String[] exp) {
		TreeNode n = buildTree(exp);
		return ((ExpressionTrees) n).evalTree();
	}

	/**
	 * 
	 * Processing the input string to get the array of operators and operands
	 * 
	 * @param s
	 *            the postfix notation string
	 * @return String[] the split string in postfix notation
	 *
	 */
	public String[] processInput(String s) {
		return s.split(" ");
	}

}
