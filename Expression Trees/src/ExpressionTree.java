import java.util.Stack;

/**
 * <p>This Class Represents an Expression Tree, and has methods to evaluate its value and convert it to various notations</p> 
 * Feb 26, 2018
 * @author Patrick Riley
 */
public class ExpressionTree extends TreeNode implements Expressions {

	/**
	 * 
	 * @param initValue
	 *            value of the root
	 * @param initLeft
	 *            node to the left
	 * @param initRight
	 *            node to the right
	 */
	public ExpressionTree(Object initValue, TreeNode initLeft, TreeNode initRight) {
		super(initValue, initLeft, initRight);
	}
	
	/**
	 * This creates a tree based on a postfix 
	 * @param s The PostFix notation String used to build the Expression Tree
	 */
	public ExpressionTree(String s) {
		super("");
		String[] exp = this.processInput(s);
		TreeNode n = buildTree(exp);
		this.setLeft(n.getLeft());
		this.setRight(n.getRight());
		this.setValue(n.getValue());
	}
	
	/**
	 * Creates a node with no children
	 * @param i the Integer value to store in the node
	 */
	public ExpressionTree(int i) {
		super(i);
	}
	
	@Override
	public TreeNode buildTree(String[] exp) {
		Stack<ExpressionTree> s = new Stack<ExpressionTree>();

		for (String o : exp) {
			try {
				int i = Integer.parseInt(o);
				s.push(new ExpressionTree(i));
			} catch (NumberFormatException e) {
				ExpressionTree b = s.pop();
				ExpressionTree r = new ExpressionTree(o,s.pop(),b);
				s.push(r);
			}
		}
		return s.pop();
	}

	@Override
	public int evalTree() {
		return recurEval(this);
	}
	
	/**
	 * This recursively evaluates an Expression Tree
	 * @param r The Node to evaluate
	 * @return int the numerical value of the tree
	 *
	 */
	private int recurEval(TreeNode r) {
		//base case
		if (r == null)
			return 0;
		else {
			//if no children, return value
			if (r.getLeft() == null && r.getRight() == null)
				return Integer.parseInt(r.getValue().toString());
			else {
				//value of left and right children
				int left = recurEval(r.getLeft());
				int right = recurEval(r.getRight());
				
				//If an operator, find out which it is and go from there
				
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
									return Integer.MAX_VALUE;
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
			String left = ((ExpressionTree) this.getLeft()).toPrefixNotation();
			String right = ((ExpressionTree) this.getRight()).toPrefixNotation();
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
			ret += ((String) ((ExpressionTree) this.getLeft()).toInfixUnfixed()) + " ";
			ret += ((String) this.getValue()) + " ";
			ret += (String) ((ExpressionTree) this.getRight()).toInfixUnfixed();
			return ret + " ) ";
		} else
			return getValue().toString();
	}

	@Override
	public String toPostfixNotation() {
		if (this.getLeft() != null || this.getRight() != null) {
			String left = ((ExpressionTree) this.getLeft()).toPostfixNotation();
			String right = ((ExpressionTree) this.getRight()).toPostfixNotation();
			return left + " " + right + " " +(String) this.getValue() + " ";
		} else
			return getValue().toString();
	}

	@Override
	public int postfixEval(String[] exp) {
		Stack<Integer> operators = new Stack<Integer>();
		for (String o : exp) {
			try {
				int i = Integer.parseInt(o);
				operators.push(i);
			} catch (NumberFormatException e) {
				switch(o) {
				case "*":
					operators.push(operators.pop() * operators.pop());
					break;
				case "/":
					operators.push(operators.pop() / operators.pop());
					break;
				case "-":
					operators.push(operators.pop() - operators.pop());
					break;
				case "%":
					operators.push(operators.pop() % operators.pop());
					break;
				default:
					operators.push(operators.pop() + operators.pop());
				}
			}
		}
		return operators.pop();
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
